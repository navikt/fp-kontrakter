package no.nav.vedtak.felles.dokumentbestilling.kodeverk;

import javax.validation.constraints.NotNull;

public class Kodeverk {

    @NotNull
    private String kode;

    protected Kodeverk() {
    }

    protected Kodeverk(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
}
