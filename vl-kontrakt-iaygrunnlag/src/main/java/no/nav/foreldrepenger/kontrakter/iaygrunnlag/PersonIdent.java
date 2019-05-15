package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

// marker class for aktører av type person
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
