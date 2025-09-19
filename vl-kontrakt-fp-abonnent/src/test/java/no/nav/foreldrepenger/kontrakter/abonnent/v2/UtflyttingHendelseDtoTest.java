package no.nav.foreldrepenger.kontrakter.abonnent.v2;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Collections;

import jakarta.validation.Validation;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.foreldrepenger.kontrakter.abonnent.v2.pdl.UtflyttingHendelseDto;

class UtflyttingHendelseDtoTest {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    private static final AktørIdDto AKTØR_ID = new AktørIdDto("10000000001");
    private static final LocalDate NÅ = LocalDate.now();

    @Test
    void skal_serialisere_og_deserialisere_utflyttinghendelse() throws Exception {
        // Arrange
        var hendelse = new UtflyttingHendelseDto();
        hendelse.setId("id_1");
        hendelse.setEndringstype(Endringstype.OPPRETTET);
        hendelse.setAktørId(Collections.singletonList(AKTØR_ID));
        hendelse.setUtflyttingsdato(NÅ);

        // Act
        var json = WRITER.writeValueAsString(hendelse);
        //System.out.println(json);
        var roundTripped = (HendelseDto) READER.forType(HendelseDto.class).readValue(json);
        var roundTrippedCast = (UtflyttingHendelseDto) roundTripped;

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped).isInstanceOf(UtflyttingHendelseDto.class);
        assertThat((roundTripped).getHendelsetype()).isEqualTo(UtflyttingHendelseDto.HENDELSE_TYPE);
        assertThat(roundTrippedCast.getId()).isEqualTo("id_1");
        assertThat(roundTrippedCast.getAktørId().getFirst()).isEqualTo(AKTØR_ID);
        assertThat(roundTrippedCast.getUtflyttingsdato()).isEqualTo(NÅ);
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