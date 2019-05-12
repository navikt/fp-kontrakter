package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AktørIdPersonident extends PersonIdent {
    public static final String IDENT_TYPE = "AKTØRID";
    
    @JsonProperty(value = "ident", required = true, index = 1)
    @NotNull
    @Pattern(regexp = "^\\d{13}+$", message = "aktørId har ikke gyldig verdi (13 siffer)")
    private String ident;

    @JsonCreator
    public AktørIdPersonident(@JsonProperty("kode") String kode) {
        this.ident = kode;
    }

    @Override
    public String getIdent() {
        return ident;
    }

    @Override
    public String getIdentType() {
        return IDENT_TYPE;
    }
}
