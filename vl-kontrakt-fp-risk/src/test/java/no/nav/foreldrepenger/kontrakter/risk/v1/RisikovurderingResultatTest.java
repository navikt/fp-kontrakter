package no.nav.foreldrepenger.kontrakter.risk.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;

import javax.validation.Validation;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.RisikoklasseType;


public class RisikovurderingResultatTest {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    private static final UUID REF = UUID.randomUUID();

    @Test
    public void skal_serialisere_og_deserialisere_request() throws Exception {
        // Arrange
        var request = new HentRisikovurderingDto(REF);

        // Act
        var json = WRITER.writeValueAsString(request);
        //System.out.println(json);
        var roundTripped = (HentRisikovurderingDto)READER.forType(HentRisikovurderingDto.class).readValue(json);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.konsumentId()).isEqualTo(REF);

        validateResult(roundTripped);
    }

    @Test
    public void skal_serialisere_og_deserialisere_respons() throws Exception {
        // Arrange
        var opptjening = new RisikogruppeDto(List.of("Tekst1", "Tekst2", "Tekst3"));
        var response = new RisikovurderingResultatDto(RisikoklasseType.HØY, null, opptjening);

        // Act
        var json = WRITER.writeValueAsString(response);
        //System.out.println(json);
        var roundTripped = (RisikovurderingResultatDto)READER.forType(RisikovurderingResultatDto.class).readValue(json);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.risikoklasse()).isEqualTo(RisikoklasseType.HØY);
        assertThat(roundTripped.medlemskapFaresignalerNonNull()).isEmpty();
        assertThat(roundTripped.opptjeningFaresignalerNonNull()).hasSize(3);

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