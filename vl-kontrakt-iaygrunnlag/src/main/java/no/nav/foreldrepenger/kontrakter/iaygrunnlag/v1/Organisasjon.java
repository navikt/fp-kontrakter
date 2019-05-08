package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class Organisasjon extends Aktør {
    static final String IDENT_TYPE = "ORGNUMMER";
    
    @JsonProperty(value = "ident", required = true, index = 1)
    @NotNull
    @Pattern(regexp = "^\\d{9}+$")
    private String ident;

    public Organisasjon(String kode) {
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
