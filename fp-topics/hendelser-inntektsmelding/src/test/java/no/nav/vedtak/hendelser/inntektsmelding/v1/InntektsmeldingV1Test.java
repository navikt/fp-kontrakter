package no.nav.vedtak.hendelser.inntektsmelding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.Validation;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public class InntektsmeldingV1Test {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    @Test
    public void test_innteksmelding_fp() throws Exception {
        String arRef = "AR123456";
        LocalDate startDato = LocalDate.now().plusWeeks(3);
        LocalDateTime innsending = LocalDateTime.now().minusMinutes(3);
        var inntektsmelding = new InntektsmeldingV1.Builder()
                .medAktørId("1234567891234")
                .medReferanseId(arRef)
                .medInnsendingsTidspunkt(innsending)
                .medStartDato(startDato)
                .medArbeidsgiverId("987654321")
                .medSaksnummer("99977755")
                .medJournalpostId("11224466")
                .medInnsendingsÅrsak("ENDRING")
                .build();

        String json = WRITER.writeValueAsString(inntektsmelding);
        System.out.println(json);

        InntektsmeldingV1 roundTripped = READER.forType(InntektsmeldingV1.class).readValue(json);

        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.getReferanseId()).isEqualTo(arRef);
        assertThat(roundTripped.getHendelse()).isEqualTo(InntektsmeldingV1.HENDELSE_INNTEKTSMELDING + "ENDRING");
        assertThat(roundTripped.getInnsendingsTidspunkt()).isEqualToIgnoringNanos(innsending);
        assertThat(roundTripped.getStartDato()).isEqualTo(startDato);
        validateResult(roundTripped);
    }

    @Test
    public void  test_innteksmelding_svp() throws Exception {
        String arRef = "AR123456";
        var inntektsmelding = new InntektsmeldingV1.Builder()
                .medAktørId("1234567891234")
                .medReferanseId(arRef)
                .medInnsendingsTidspunkt(LocalDateTime.now())
                .medArbeidsgiverId("9876543210432")
                .medSaksnummer("99977755")
                .medJournalpostId("11224466")
                .medInnsendingsÅrsak("NY")
                .build();

        String json = WRITER.writeValueAsString(inntektsmelding);
        System.out.println(json);

        InntektsmeldingV1 roundTripped = READER.forType(InntektsmeldingV1.class).readValue(json);

        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.getReferanseId()).isNotNull();
        assertThat(roundTripped.getHendelse()).isEqualTo(InntektsmeldingV1.HENDELSE_INNTEKTSMELDING + "NY");
        assertThat(roundTripped.getStartDato()).isNull();
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