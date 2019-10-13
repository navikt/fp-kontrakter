package no.nav.vedtak.brukerdialog;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Aktør {

    @NotNull
    @JsonProperty("verdi")
    @Pattern(regexp = "\\d{9}|\\d{11}|\\d{13}") // Orgnr / Fnr / aktørid
    private String verdi;

    public Aktør() {
    }

    public Aktør(String verdi) {
        this.verdi = verdi;
    }


    public String getVerdi() {
        return verdi;
    }

    public void setVerdi(String verdi) {
        this.verdi = verdi;
    }
}
