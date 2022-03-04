package no.nav.foreldrepenger.kontrakter.formidling.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import javax.validation.Validation;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.HistorikkAktør;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.YtelseType;

public class DokumentbestillingV2Test {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    private static final String ENHET  ="NAV Familie- og Pensjonsytelser Oslo 1";
    private static final UUID REF1 = UUID.randomUUID();
    private static final UUID REF2 = UUID.randomUUID();

    @Test
    public void skal_serialisere_og_deserialisere_request() throws Exception {
        // Arrange
        var request = new DokumentbestillingV2Dto(REF1, REF2,
            YtelseType.FP, HistorikkAktør.VEDTAKSLØSNINGEN,
            "INNLYS", "Fri tekst ...",
            ENHET, null);

        // Act
        var json = WRITER.writeValueAsString(request);
        //System.out.println(json);
        var roundTripped = (DokumentbestillingV2Dto)READER.forType(DokumentbestillingV2Dto.class).readValue(json);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.dokumentbestillingUuid()).isEqualTo(REF2);
        assertThat(roundTripped.behandlendeEnhetNavn()).isEqualTo(ENHET);
        assertThat(roundTripped.arsakskode()).isNull();
        assertThat(roundTripped.historikkAktør()).isEqualTo(HistorikkAktør.VEDTAKSLØSNINGEN);
        assertThat(roundTripped.ytelseType()).isEqualTo(YtelseType.FP);

        validateResult(roundTripped);
    }

    private void validateResult(Object roundTripped) {
        assertThat(roundTripped).isNotNull();
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            var validator = factory.getValidator();
            var violations = validator.validate(roundTripped);
            assertThat(violations).isEmpty();
        }
    }



}
