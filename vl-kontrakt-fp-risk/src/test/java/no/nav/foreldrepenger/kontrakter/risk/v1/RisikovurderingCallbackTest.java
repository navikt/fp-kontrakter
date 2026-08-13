package no.nav.foreldrepenger.kontrakter.risk.v1;

import jakarta.validation.Validation;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.RisikoklasseType;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.Saksnummer;
import no.nav.vedtak.mapper.json.DefaultJsonMapper;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


class RisikovurderingCallbackTest {

    private static final UUID REF = UUID.randomUUID();
    private static final Saksnummer SAKSNUMMER = new Saksnummer("123456789");

    @Test
    void skal_serialisere_og_deserialisere_respons() {
        // Arrange
        var response = new RisikovurderingCallbackDto(REF, SAKSNUMMER, RisikoklasseType.IKKE_HØY);

        // Act
        var json = DefaultJsonMapper.toPrettyJson(response);
        //System.out.println(json);
        var roundTripped = DefaultJsonMapper.fromJson(json, RisikovurderingCallbackDto.class);

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