package no.nav.vedtak.hendelser.behandling;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class AktørId {

    @NotNull
    @JsonValue
    @Pattern(regexp = "^\\d{13}$")
    private String aktørId;

    public AktørId() {
    }

    public AktørId(String aktørId) {
        this.aktørId = aktørId;
    }


    public String getAktørId() {
        return aktørId;
    }

    public void setAktørId(@JsonProperty("aktørId") String aktørId) {
        this.aktørId = aktørId;
    }
}
