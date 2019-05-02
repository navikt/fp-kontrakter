package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class ArbeidTypeDto {
    private String kode;
    private final String kodeverk = "ARBEID_TYPE";

    public ArbeidTypeDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
