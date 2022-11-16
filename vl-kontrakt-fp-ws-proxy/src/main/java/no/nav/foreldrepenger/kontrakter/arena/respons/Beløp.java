package no.nav.foreldrepenger.kontrakter.arena.respons;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record Beløp(@JsonValue BigDecimal verdi) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Beløp { // NOSONAR
    }

    @Override
    public BigDecimal verdi() {
        return verdi;
    }
}
