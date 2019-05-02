package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class FagsystemDto {
    private String kode;
    private final String kodeverk = "FAGSYSTEM";

    public FagsystemDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
