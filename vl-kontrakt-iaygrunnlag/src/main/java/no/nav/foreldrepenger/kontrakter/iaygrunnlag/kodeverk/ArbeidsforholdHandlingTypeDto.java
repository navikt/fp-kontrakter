package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class ArbeidsforholdHandlingTypeDto {
    private String kode;
    private final String kodeverk = "ARBEIDSFORHOLD_HANDLING_TYPE";

    public ArbeidsforholdHandlingTypeDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
