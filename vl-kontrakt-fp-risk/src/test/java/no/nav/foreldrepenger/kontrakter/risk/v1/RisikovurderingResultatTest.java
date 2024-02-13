package no.nav.foreldrepenger.kontrakter.risk.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Validation;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.FaresignalVurdering;
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
        var saksnummer = "999999999";
        var request = new HentRisikovurderingDto(REF, saksnummer);

        // Act
        var json = WRITER.writeValueAsString(request);
        //System.out.println(json);
        var roundTripped = (HentRisikovurderingDto)READER.forType(HentRisikovurderingDto.class).readValue(json);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.konsumentId()).isEqualTo(REF);
        assertThat(roundTripped.saksnummer()).isEqualTo(saksnummer);

        validateResult(roundTripped);
    }

    @Test
    public void skal_serialisere_og_deserialisere_respons() throws Exception {
        // Arrange
        var opptjening = new RisikogruppeDto(List.of("Tekst1", "Tekst2", "Tekst3"));
        var response = new RisikovurderingResultatDto(RisikoklasseType.HØY, null, opptjening, FaresignalVurdering.AVSLAG_ANNET);

        // Act
        var json = WRITER.writeValueAsString(response);
        //System.out.println(json);
        var roundTripped = (RisikovurderingResultatDto)READER.forType(RisikovurderingResultatDto.class).readValue(json);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.risikoklasse()).isEqualTo(RisikoklasseType.HØY);
        assertThat(roundTripped.faresignalvurdering()).isEqualTo(FaresignalVurdering.AVSLAG_ANNET);
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
