package no.nav.foreldrepenger.kontrakter.risk.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.Validation;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.AktørId;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.YtelseType;


public class RisikovurderingRequestTest {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    private static final AktørId AKTØR_ID = new AktørId("1000000000001");
    private static final LocalDate IDAG = LocalDate.now();
    private static final UUID REF = UUID.randomUUID();

    @Test
    public void skal_serialisere_og_deserialisere_request() throws Exception {
        // Arrange
        var annenpart = new AnnenPartDto(null, "UtlandskId");
        var request = new RisikovurderingRequestDto(AKTØR_ID, IDAG, IDAG.minusMonths(17), IDAG.plusYears(3), REF, YtelseType.FORELDREPENGER, annenpart);

        // Act
        var json = WRITER.writeValueAsString(request);
        //System.out.println(json);
        var roundTripped = (RisikovurderingRequestDto)READER.forType(RisikovurderingRequestDto.class).readValue(json);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.søkerAktørId()).isEqualTo(AKTØR_ID);
        assertThat(roundTripped.skjæringstidspunkt()).isEqualTo(IDAG);
        assertThat(roundTripped.konsumentId()).isEqualTo(REF);
        assertThat(roundTripped.annenPart().annenpartAktørId()).isNull();

        validateResult(roundTripped); // Generer ny versjon
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
