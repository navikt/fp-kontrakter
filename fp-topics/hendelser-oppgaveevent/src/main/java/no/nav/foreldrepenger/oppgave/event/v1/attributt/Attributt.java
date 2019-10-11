package no.nav.foreldrepenger.oppgave.event.v1.attributt;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DatoAttributt.class, name = "timestamp"),
        @JsonSubTypes.Type(value = HeltallAttributt.class, name = "heltall"),
        @JsonSubTypes.Type(value = BooleanAttributt.class, name = "boolean")
})
public abstract class Attributt {
    private String felt;

    Attributt(String felt) {
        this.felt = felt;
    }

    public String getFelt() {
        return felt;
    }

    @Override
    public String toString() {
        return "Attributt{" +
                "felt='" + felt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attributt other = (Attributt) o;
        return this.felt != null ? this.felt.equals(other.felt) : other.felt == null;
    }

    @Override
    public int hashCode() {
        return felt != null ? felt.hashCode() : 0;
    }
}
