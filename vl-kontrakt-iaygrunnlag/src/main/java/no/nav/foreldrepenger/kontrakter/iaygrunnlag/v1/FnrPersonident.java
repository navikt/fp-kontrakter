package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class FnrPersonident extends PersonIdent {
    static final String IDENT_TYPE = "FNR";
    
    @JsonProperty(value = "ident", required = true, index = 1)
    @NotNull
    @Pattern(regexp = "^\\d{11}+$")
    private String ident;

    public FnrPersonident(String kode) {
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
