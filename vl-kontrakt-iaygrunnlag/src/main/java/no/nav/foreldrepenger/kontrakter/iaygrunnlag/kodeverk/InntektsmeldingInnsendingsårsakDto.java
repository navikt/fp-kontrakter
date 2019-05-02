package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class InntektsmeldingInnsendingsårsakDto {
    private String kode;
    private final String kodeverk = "INNTEKTSMELDING_INNSENDINGSAARSAK";

    public InntektsmeldingInnsendingsårsakDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
