package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

public class PermisjonsbeskrivelseTypeDto {
    private String kode;
    private final String kodeverk = "PERMISJONSBESKRIVELSE_TYPE";

    public PermisjonsbeskrivelseTypeDto(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }
}
