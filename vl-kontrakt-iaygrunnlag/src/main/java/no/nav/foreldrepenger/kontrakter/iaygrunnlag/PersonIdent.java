package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

// marker class for aktører av type person
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
