package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class OrganisasjonstypeDto {
    private String kode;
    private static final String kodeverk = "ORGANISASJONSTYPE";

    public OrganisasjonstypeDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
