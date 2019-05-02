package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class InntektspostTypeDto {
    private String kode;
    private final String kodeverk = "INNTEKTSPOST_TYPE";

    public InntektspostTypeDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
