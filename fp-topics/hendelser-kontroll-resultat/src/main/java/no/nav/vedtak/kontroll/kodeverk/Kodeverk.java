package no.nav.vedtak.kontroll.kodeverk;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Kodeverk {

    @NotNull
    @JsonProperty("kodeverk")
    private String kodeverk;
    @NotNull
    @JsonProperty("kode")
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
