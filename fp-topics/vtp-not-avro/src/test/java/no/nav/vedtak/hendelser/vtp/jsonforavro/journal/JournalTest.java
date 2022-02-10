package no.nav.vedtak.hendelser.vtp.jsonforavro.journal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import javax.validation.Validation;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.vedtak.hendelser.vtp.jsonforavro.TestJsonMapper;

public class JournalTest {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    @Test
    public void test_innteksmelding() throws Exception {
        var ref = UUID.randomUUID().toString();
        var jpId = "555555555";
        var inntektsmelding = JournalføringHendelseVTP.standardInngåendeInntektsmelding(jpId, Tema.FOR, ref);

        String json = WRITER.writeValueAsString(inntektsmelding);
        System.out.println(json);

        JournalføringHendelseVTP roundTripped = READER.forType(JournalføringHendelseVTP.class).readValue(json);

        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.journalpostId()).isEqualTo(jpId);
        assertThat(roundTripped.temaNytt()).isEqualTo(Tema.FOR);
        assertThat(roundTripped.hendelsesType()).isEqualTo(HendelsesType.JournalpostMottatt);
        assertThat(roundTripped.mottaksKanal()).isEqualTo(Mottakskanal.ALTINN);
        assertThat(roundTripped.kanalReferanseId()).isEqualTo(ref);
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