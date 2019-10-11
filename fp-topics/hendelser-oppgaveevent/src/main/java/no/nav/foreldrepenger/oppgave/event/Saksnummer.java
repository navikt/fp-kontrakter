package no.nav.foreldrepenger.oppgave.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Saksnummer {

    @JsonProperty(value = "saksnummer", required = true)
    @JsonValue
    private String saksnummer;

    @JsonCreator
    public Saksnummer(String saksnummer) {
        this.saksnummer = saksnummer;
    }

    public String asString() {
        return saksnummer;
    }

    @Override
    public String toString() {
        return "Saksnummer{" +
                "saksnummer='" + saksnummer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Saksnummer that = (Saksnummer) o;
        return saksnummer != null ? saksnummer.equals(that.saksnummer) : that.saksnummer == null;
    }

    @Override
    public int hashCode() {
        return saksnummer != null ? saksnummer.hashCode() : 0;
    }
}
