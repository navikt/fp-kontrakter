package no.nav.foreldrepenger.kontrakter.abonnent.v2;

import jakarta.validation.Validation;
import no.nav.foreldrepenger.kontrakter.abonnent.v2.pdl.UtflyttingHendelseDto;
import no.nav.vedtak.mapper.json.DefaultJsonMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class UtflyttingHendelseDtoTest {

    private static final AktørIdDto AKTØR_ID = new AktørIdDto("10000000001");
    private static final LocalDate NÅ = LocalDate.now();

    @Test
    void skal_serialisere_og_deserialisere_utflyttinghendelse() {
        // Arrange
        var hendelse = new UtflyttingHendelseDto();
        hendelse.setId("id_1");
        hendelse.setEndringstype(Endringstype.OPPRETTET);
        hendelse.setAktørId(Collections.singletonList(AKTØR_ID));
        hendelse.setUtflyttingsdato(NÅ);

        // Act
        var json = DefaultJsonMapper.toPrettyJson(hendelse);
        //System.out.println(json);
        var roundTripped = (HendelseDto) DefaultJsonMapper.fromJson(json, HendelseDto.class);
        var roundTrippedCast = (UtflyttingHendelseDto) roundTripped;

        // Assert
        assertThat(roundTripped).isNotNull().isInstanceOf(UtflyttingHendelseDto.class);
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