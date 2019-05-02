package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class LandkoderDto {
    private String kode;
    private final String kodeverk = "LANDKODER";

    public LandkoderDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
