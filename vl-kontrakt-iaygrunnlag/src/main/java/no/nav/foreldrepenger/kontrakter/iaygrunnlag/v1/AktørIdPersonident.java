package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

public class AktørIdPersonident extends PersonIdent {
    static final String IDENT_TYPE = "NAV-AKTØR-ID";
    
    @JsonProperty(value = "ident", required = true, index = 1)
    @NotNull
    @Pattern(regexp = "^\\d{13}+$")
    private String ident;

    public AktørIdPersonident(String kode) {
        super();
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
