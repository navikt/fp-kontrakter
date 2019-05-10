package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** Identifiserer en aktør (person, virksomhet). */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property="identType", defaultImpl = Void.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Organisasjon.class, name = Organisasjon.IDENT_TYPE),
    @JsonSubTypes.Type(value = AktørIdPersonident.class, name = AktørIdPersonident.IDENT_TYPE),
    @JsonSubTypes.Type(value = FnrPersonident.class, name = FnrPersonident.IDENT_TYPE),
})
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public abstract class Aktør {

    protected Aktør() {
    }
    
    /** Returnerer Id (format ihht angitt type. *). */
    public abstract String getIdent();
    
    /** Type ident. (per ident fra subklasse). */
    public abstract String getIdentType();
}
