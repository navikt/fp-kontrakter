package no.nav.foreldrepenger.oppgave.event.v1.attributt;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BooleanAttributt extends Attributt {
    private boolean verdi;

    @JsonCreator
    public BooleanAttributt(@JsonProperty("felt") String felt,
                            @JsonProperty("verdi") boolean verdi) {
        super(felt);
        this.verdi = verdi;
    }

    public boolean isVerdi() {
        return verdi;
    }

    @Override
    public String toString() {
        return "BooleanAttributt{" +
                "felt='" + super.getFelt() + '\'' +
                ", verdi=" + verdi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BooleanAttributt other = (BooleanAttributt) o;
        return this.verdi == other.verdi;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (verdi ? 1 : 0);
        return result;
    }
}
