package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class ArbeidskategoriDto {
    private String kode;
    private final String kodeverk = "ARBEIDSKATEGORI";

    public ArbeidskategoriDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
