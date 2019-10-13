package no.nav.vedtak.brukerdialog.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

public class InntektsmeldingV1Test {

    @Test
    public void test_innteksmelding_fp() {
        String arRef = "AR123456";
        var inntektsmelding = new InntektsmeldingV1.Builder()
                .medAktørId("1234567891234")
                .medReferanseId(arRef)
                .medInnsendingsTidspunkt(LocalDateTime.now())
                .medStartDato(LocalDate.now().plusWeeks(3))
                .medArbeidsgiver("987654321")
                .medSaksnummer("99977755")
                .medJournalpostId("11224466")
                .medInnsendingAarsak("ENDRING")
                .build();
        assertThat(inntektsmelding.getReferanseId()).isEqualTo(arRef);
        assertThat(inntektsmelding.getHendelse()).isEqualTo(InntektsmeldingV1.HENDELSE_INNTEKTSMELDING);
        // Denne validerer. Test med å dra inn hibernate-validator og validation . validate
    }

    @Test
    public void  test_innteksmelding_svp() {
        String arRef = "AR123456";
        var inntektsmelding = new InntektsmeldingV1.Builder()
                .medAktørId("1234567891234")
                .medReferanseId(arRef)
                .medInnsendingsTidspunkt(LocalDateTime.now())
                .medArbeidsgiver("9876543210432")
                .medSaksnummer("99977755")
                .medJournalpostId("11224466")
                .medInnsendingAarsak("NY")
                .build();
        assertThat(inntektsmelding.getReferanseId()).isEqualTo(arRef);
        assertThat(inntektsmelding.getHendelse()).isEqualTo(InntektsmeldingV1.HENDELSE_INNTEKTSMELDING);
        // Denne validerer. Test med å dra inn hibernate-validator og validation . validate
    }

}