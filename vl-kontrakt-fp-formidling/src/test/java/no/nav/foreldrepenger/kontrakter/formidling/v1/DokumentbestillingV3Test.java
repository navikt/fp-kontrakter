package no.nav.foreldrepenger.kontrakter.formidling.v1;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.validation.Validation;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMal;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.Saksnummer;
import no.nav.foreldrepenger.kontrakter.formidling.v3.DokumentBestillingDto;
import no.nav.vedtak.mapper.json.DefaultJsonMapper;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class DokumentbestillingV3Test {

    private static final ObjectWriter WRITER = DefaultJsonMapper.getObjectMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = DefaultJsonMapper.getObjectMapper().reader();

    private static final Saksnummer SAKSNUMMER  = new Saksnummer("123459789");
    private static final UUID REF1 = UUID.randomUUID();
    private static final UUID REF2 = UUID.randomUUID();

    @Test
    void skal_serialisere_og_deserialisere_request() throws Exception {
        // Arrange
        var request = new DokumentBestillingDto(REF1, SAKSNUMMER, REF2,
                DokumentMal.ETTERLYS_INNTEKTSMELDING, null, "Fri tekst ...",null);
//@NotNull @Valid UUID behandlingUuid,
//                                    @Valid Saksnummer saksnummer,
//                                    @NotNull @Valid UUID dokumentbestillingUuid,
//                                    @NotNull @Valid DokumentMal dokumentMal,
//                                    @Valid RevurderingÅrsak revurderingÅrsak,
//                                    String fritekst,
//                                    @Valid DokumentMal journalførSom
        // Act
        var json = WRITER.writeValueAsString(request);
        //System.out.println(json);
        var roundTripped = (DokumentBestillingDto)READER.forType(DokumentBestillingDto.class).readValue(json);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.dokumentbestillingUuid()).isEqualTo(REF2);
        assertThat(roundTripped.saksnummer()).isEqualTo(SAKSNUMMER);
        assertThat(roundTripped.revurderingÅrsak()).isNull();
        assertThat(roundTripped.dokumentMal()).isEqualTo(DokumentMal.ETTERLYS_INNTEKTSMELDING);

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
