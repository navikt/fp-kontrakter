package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class RelatertYtelseTilstandDto {
    private String kode;
    private final String kodeverk = "RELATERT_YTELSE_TILSTAND";

    public RelatertYtelseTilstandDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
