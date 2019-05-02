package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class NaturalYtelseTypeDto {
    private String kode;
    private final String kodeverk = "NATURAL_YTELSE_TYPE";

    public NaturalYtelseTypeDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
