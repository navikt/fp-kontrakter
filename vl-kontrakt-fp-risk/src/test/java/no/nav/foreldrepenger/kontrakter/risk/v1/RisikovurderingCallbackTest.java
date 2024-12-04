package no.nav.foreldrepenger.kontrakter.risk.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import jakarta.validation.Validation;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.Saksnummer;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.RisikoklasseType;


public class RisikovurderingCallbackTest {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    private static final UUID REF = UUID.randomUUID();
    private static final Saksnummer SAKSNUMMER = new Saksnummer("123456789");

    @Test
    public void skal_serialisere_og_deserialisere_respons() throws Exception {
        // Arrange
        var response = new RisikovurderingCallbackDto(REF, SAKSNUMMER, RisikoklasseType.IKKE_HØY);

        // Act
        var json = WRITER.writeValueAsString(response);
        //System.out.println(json);
        var roundTripped = (RisikovurderingCallbackDto)READER.forType(RisikovurderingCallbackDto.class).readValue(json);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.behandlingUuid()).isEqualTo(REF);
        assertThat(roundTripped.saksnummer()).isEqualTo(SAKSNUMMER);
        assertThat(roundTripped.risikoklasse()).isEqualTo(RisikoklasseType.IKKE_HØY);

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