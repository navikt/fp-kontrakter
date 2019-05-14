package no.nav.foreldrepenger.kontrakter.formidling.kodeverk;

import javax.validation.constraints.NotNull;

public class Kodeverk {

    @NotNull
    private String kodeverk;
    @NotNull
    private String kode;

    protected Kodeverk() {
    }

    protected Kodeverk(String kodeverk, String kode) {
        this.kodeverk = kodeverk;
        this.kode = kode;
    }

    public String getKodeverk() {
        return kodeverk;
    }

    public void setKodeverk(String kodeverk) {
        this.kodeverk = kodeverk;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
}
