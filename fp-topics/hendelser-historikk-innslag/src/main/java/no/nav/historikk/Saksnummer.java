package no.nav.historikk;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Saksnummer {

    @NotNull
    @JsonProperty(value = "saksnummer", required = true)
    @Size(max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9_\\-]*$")
    @JsonValue
    private String saksnummer;


    @JsonCreator
    public Saksnummer(@JsonProperty(value = "saksnummer", required = true) String saksnummer) {
        this.saksnummer = saksnummer;
    }

    public String getVerdi() {
        return saksnummer;
    }
}
