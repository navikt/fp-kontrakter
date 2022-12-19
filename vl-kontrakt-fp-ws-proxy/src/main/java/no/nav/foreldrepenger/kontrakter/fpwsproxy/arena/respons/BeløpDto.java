package no.nav.foreldrepenger.kontrakter.fpwsproxy.arena.respons;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record BeløpDto(@JsonValue BigDecimal verdi) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public BeløpDto { // NOSONAR
    }

    @Override
    public BigDecimal verdi() {
        return verdi;
    }
}
