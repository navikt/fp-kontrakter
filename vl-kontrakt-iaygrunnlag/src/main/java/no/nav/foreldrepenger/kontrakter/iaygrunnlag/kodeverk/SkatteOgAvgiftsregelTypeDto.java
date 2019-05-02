package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class SkatteOgAvgiftsregelTypeDto {
    private String kode;
    private final String kodeverk = "SKATTE_OG_AVGIFTSREGEL";

    public SkatteOgAvgiftsregelTypeDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
