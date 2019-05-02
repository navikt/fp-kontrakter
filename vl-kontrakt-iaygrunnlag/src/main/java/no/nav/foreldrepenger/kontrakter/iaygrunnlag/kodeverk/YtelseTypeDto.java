package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class YtelseTypeDto {
    private String kode;
    private String kodeverk;

    public YtelseTypeDto(String kode, String kodeverk) {
        this.kode = kode;
        this.kodeverk = kodeverk;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
