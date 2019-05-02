package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class RelatertYtelseTypeDto {
    private String kode;
    private final String kodeverk = "RELATERT_YTELSE_TYPE";

    public RelatertYtelseTypeDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
