package no.nav.foreldrepenger.kontrakter.abonnent.v2;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Collections;

import jakarta.validation.Validation;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.foreldrepenger.kontrakter.abonnent.v2.pdl.FødselHendelseDto;

public class FødselHendelseDtoTest {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    private static final AktørIdDto AKTØR_ID = new AktørIdDto("10000000001");
    private static final LocalDate NÅ = LocalDate.now();

    @Test
    public void skal_serialisere_og_deserialisere_fødselshendelse() throws Exception {
        // Arrange
        var hendelse = new FødselHendelseDto();
        hendelse.setId("id_1");
        hendelse.setEndringstype(Endringstype.OPPRETTET);
        hendelse.setAktørIdForeldre(Collections.singletonList(AKTØR_ID));
        hendelse.setFødselsdato(NÅ);

        // Act
        var json = WRITER.writeValueAsString(hendelse);
        //System.out.println(json);
        var roundTrippedUncast = (HendelseDto)READER.forType(HendelseDto.class).readValue(json);
        var roundTripped = (FødselHendelseDto) roundTrippedUncast;

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTrippedUncast).isInstanceOf(FødselHendelseDto.class);
        assertThat(roundTripped.getId()).isEqualTo("id_1");
        assertThat(roundTripped.getAktørIdForeldre().get(0)).isEqualTo(AKTØR_ID);
        assertThat(roundTripped.getFødselsdato()).isEqualTo(NÅ);
        assertThat(roundTripped.getHendelsetype()).isEqualTo(FødselHendelseDto.HENDELSE_TYPE);
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