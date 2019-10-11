package no.nav.foreldrepenger.oppgave.event.v1.attributt;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;

public class DatoAttributt extends Attributt {
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate verdi;

    @JsonCreator
    public DatoAttributt(@JsonProperty("felt") String felt,
                         @JsonProperty("verdi") LocalDate verdi) {
        super(felt);
        this.verdi = verdi;
    }

    public LocalDate getVerdi() {
        return verdi;
    }

    @Override
    public String toString() {
        return "DatoAttributt{" +
                "felt='" + super.getFelt() + '\'' +
                ", verdi=" + verdi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DatoAttributt other = (DatoAttributt) o;
        return this.verdi.equals(other.verdi);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (verdi != null ? verdi.hashCode() : 0);
        return result;
    }
}