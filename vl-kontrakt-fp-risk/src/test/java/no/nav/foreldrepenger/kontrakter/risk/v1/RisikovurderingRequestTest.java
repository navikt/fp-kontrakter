package no.nav.foreldrepenger.kontrakter.risk.v1;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.validation.Validation;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.AktørId;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.Saksnummer;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.YtelseType;
import no.nav.vedtak.mapper.json.DefaultJsonMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


class RisikovurderingRequestTest {

    private static final ObjectWriter WRITER = DefaultJsonMapper.getObjectMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = DefaultJsonMapper.getObjectMapper().reader();

    private static final AktørId AKTØR_ID = new AktørId("1000000000001");
    private static final LocalDate IDAG = LocalDate.now();
    private static final UUID REF = UUID.randomUUID();
    private static final Saksnummer SAKSNUMMER = new Saksnummer("123456789");

    @Test
    void skal_serialisere_og_deserialisere_request() throws Exception {
        // Arrange
        var annenpart = new AnnenPartDto(null, "UtlandskId");
        var request = new RisikovurderingRequestDto(AKTØR_ID, IDAG, IDAG.minusMonths(17), IDAG.plusYears(3), REF, YtelseType.FORELDREPENGER, annenpart, SAKSNUMMER);

        // Act
        var json = WRITER.writeValueAsString(request);
        //System.out.println(json);
        var roundTripped = (RisikovurderingRequestDto)READER.forType(RisikovurderingRequestDto.class).readValue(json);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.søkerAktørId()).isEqualTo(AKTØR_ID);
        assertThat(roundTripped.skjæringstidspunkt()).isEqualTo(IDAG);
        assertThat(roundTripped.konsumentId()).isEqualTo(REF);
        assertThat(roundTripped.saksnummer()).isEqualTo(SAKSNUMMER);
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
