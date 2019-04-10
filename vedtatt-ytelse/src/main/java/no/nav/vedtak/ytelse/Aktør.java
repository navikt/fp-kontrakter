package no.nav.vedtak.ytelse;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Aktør {

    @NotNull
    @JsonProperty("verdi")
    @Pattern(regexp = "\\d{11}|\\d{13}") // Fnr / aktørid
    private String verdi;

    public Aktør() {
    }

    public String getVerdi() {
        return verdi;
    }

    public void setVerdi(String verdi) {
        this.verdi = verdi;
    }
}
