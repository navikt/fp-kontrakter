package no.nav.vedtak.brukerdialog;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Aktør {

    @NotNull
    @JsonValue
    @Pattern(regexp = "\\d{9}|\\d{11}|\\d{13}") // Orgnr / Fnr / aktørid
    private String id;

    public Aktør() {
    }

    public Aktør(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(@JsonProperty("id") String id) {
        this.id = id;
    }
}
