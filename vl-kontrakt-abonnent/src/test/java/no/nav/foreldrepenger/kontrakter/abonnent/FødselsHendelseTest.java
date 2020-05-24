package no.nav.foreldrepenger.kontrakter.abonnent;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Collections;

import javax.validation.Validation;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.foreldrepenger.kontrakter.abonnent.tps.FødselHendelseDto;

public class FødselsHendelseTest {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    private static final String AKTØR_ID = "10000000001";
    private static final LocalDate NÅ = LocalDate.now();

    @Test
    public void test_fødselshendelse() throws Exception {
        var fødselsHendelse = new FødselHendelseDto();
        fødselsHendelse.setId("id_1");
        fødselsHendelse.setAktørIdForeldre(Collections.singletonList(AKTØR_ID));
        fødselsHendelse.setFødselsdato(NÅ);


        String json = WRITER.writeValueAsString(fødselsHendelse);
        System.out.println(json);

        FødselHendelseDto roundTripped = READER.forType(FødselHendelseDto.class).readValue(json);

        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.getId()).isEqualTo("id_1");
        assertThat(roundTripped.getAktørIdForeldre().get(0)).isEqualTo(AKTØR_ID);
        assertThat(roundTripped.getFødselsdato()).isEqualTo(NÅ);
        assertThat(roundTripped.getHendelsetype()).isEqualTo("FØDSEL");
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