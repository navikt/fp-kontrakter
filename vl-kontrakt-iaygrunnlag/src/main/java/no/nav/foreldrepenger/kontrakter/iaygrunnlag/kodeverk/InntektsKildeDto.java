package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class InntektsKildeDto {
    private String kode;
    private final String kodeverk = "INNTEKTS_KILDE";

    public InntektsKildeDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
