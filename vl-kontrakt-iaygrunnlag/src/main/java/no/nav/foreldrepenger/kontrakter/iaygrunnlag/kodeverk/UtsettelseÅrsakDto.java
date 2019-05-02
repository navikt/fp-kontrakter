package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class UtsettelseÅrsakDto {
    private String kode;
    private final String kodeverk = "UTSETTELSE_AARSAK_TYPE";

    public UtsettelseÅrsakDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
