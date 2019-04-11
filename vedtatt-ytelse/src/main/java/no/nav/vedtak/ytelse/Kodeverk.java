package no.nav.vedtak.ytelse;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

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
