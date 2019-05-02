package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class VirksomhetTypeDto {
    private String kode;
    private final String kodeverk = "VIRKSOMHET_TYPE";

    public VirksomhetTypeDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
