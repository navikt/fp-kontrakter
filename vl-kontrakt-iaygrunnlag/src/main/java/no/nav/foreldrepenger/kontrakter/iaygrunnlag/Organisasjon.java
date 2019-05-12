package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class Organisasjon extends Aktør {
    static final String IDENT_TYPE = "ORGNUMMER";
    
    @JsonProperty(value = "ident", required = true, index = 1)
    @NotNull
    @Pattern(regexp = "^\\d{9}+$", message = "orgnr har ikke gyldig verdi (9 siffer)")
    private String ident;

    @JsonCreator
    public Organisasjon(@JsonProperty("kode") String kode) {
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
    
    @Override
    public boolean getErOrganisasjon() {
        return true;
    }
    
    @Override
    public boolean getErPerson() {
        return false;
    }
}
