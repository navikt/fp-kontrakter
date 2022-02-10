package no.nav.vedtak.hendelser.vtp.jsonforavro.leesah;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.Validation;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.vedtak.hendelser.vtp.jsonforavro.TestJsonMapper;

public class LeesahTest {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    @Test
    public void test_fødsel() throws Exception {
        var ref = UUID.randomUUID().toString();
        var jpId = "555555555";
        var fødsel = LeesahHendelseVTP.opprettetFødsel(List.of("FAR", "MOR", "BARN"), LocalDate.now().minusDays(1));

        String json = WRITER.writeValueAsString(fødsel);
        System.out.println(json);

        LeesahHendelseVTP roundTripped = READER.forType(LeesahHendelseVTP.class).readValue(json);

        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.personidenter()).containsAll(List.of("MOR", "FAR", "BARN"));
        assertThat(roundTripped.hendelsedato().dato()).isEqualTo(LocalDate.now().minusDays(1));
        assertThat(roundTripped.opplysningstype()).isEqualTo(Opplysningstype.FOEDSEL_V1);
        assertThat(roundTripped.endringstype()).isEqualTo(Endringstype.OPPRETTET);
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