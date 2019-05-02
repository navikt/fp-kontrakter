package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class TemaUnderkategoriDto {
    private String kode;
    private final String kodeverk = "TEMA_UNDERKATEGORI";

    public TemaUnderkategoriDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
