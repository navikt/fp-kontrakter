package no.nav.foreldrepenger.kontrakter.risk.v1;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.validation.Validation;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.FaresignalVurdering;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.RisikoklasseType;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.Saksnummer;
import no.nav.vedtak.mapper.json.DefaultJsonMapper;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


class RisikovurderingResultatTest {

    private static final ObjectWriter WRITER = DefaultJsonMapper.getObjectMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = DefaultJsonMapper.getObjectMapper().reader();

    private static final UUID REF = UUID.randomUUID();

    private static final Saksnummer SAKSNUMMER = new Saksnummer("123456789");

    @Test
    void skal_serialisere_og_deserialisere_request() throws Exception {
        // Arrange
        var request = new HentRisikovurderingDto(REF, SAKSNUMMER);

        // Act
        var json = WRITER.writeValueAsString(request);
        //System.out.println(json);
        var roundTripped = (HentRisikovurderingDto)READER.forType(HentRisikovurderingDto.class).readValue(json);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.konsumentId()).isEqualTo(REF);
        assertThat(roundTripped.saksnummer()).isEqualTo(SAKSNUMMER);

        validateResult(roundTripped);
    }

    @Test
    void skal_serialisere_og_deserialisere_respons() throws Exception {
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