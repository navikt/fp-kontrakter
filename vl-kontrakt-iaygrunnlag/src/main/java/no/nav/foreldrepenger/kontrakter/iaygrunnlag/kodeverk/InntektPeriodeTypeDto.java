package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class InntektPeriodeTypeDto {
    private String kode;
    private final String kodeverk = "INNTEKT_PERIODE_TYPE";

    public InntektPeriodeTypeDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
