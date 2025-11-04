package no.nav.foreldrepenger.kontrakter.fpoversikt;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;

public record Arbeidstidprosent(@JsonValue BigDecimal value) {
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Arbeidstidprosent { // NOSONAR
    }
}
