package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

// marker class for aktører av type person
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "identType", defaultImpl = Void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AktørIdPersonident.class, name = AktørIdPersonident.IDENT_TYPE),
        @JsonSubTypes.Type(value = FnrPersonident.class, name = FnrPersonident.IDENT_TYPE),
})
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public abstract class PersonIdent extends Aktør {

    @Override
    public boolean getErOrganisasjon() {
        return false;
    }

    @Override
    public boolean getErPerson() {
        return true;
    }
}
