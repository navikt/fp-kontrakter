package no.nav.foreldrepenger.oppgave.event.v1.attributt;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class HeltallAttributt extends Attributt {
    private Integer verdi;

    @JsonCreator
    public HeltallAttributt(@JsonProperty("felt") String felt,
                            @JsonProperty("verdi") Integer verdi) {
        super(felt);
        this.verdi = verdi;
    }

    public Integer getVerdi() {
        return verdi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HeltallAttributt other = (HeltallAttributt) o;
        return this.verdi.equals(other.verdi);
    }

    @Override
    public int hashCode() {
        int begge = Objects.hash(super.getFelt(), this.verdi);
        int kunHeltall = Objects.hash(this.verdi);
        System.out.println("super + heltall: " + begge);
        System.out.println("kun heltall: " + kunHeltall);
        return begge;
    }

    @Override
    public String toString() {
        return "HeltallAttributt{" +
                "felt='" + super.getFelt() + '\'' +
                ", verdi=" + verdi +
                '}';
    }
}