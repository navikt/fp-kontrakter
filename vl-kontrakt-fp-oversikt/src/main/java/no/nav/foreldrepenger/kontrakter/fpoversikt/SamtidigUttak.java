package no.nav.foreldrepenger.kontrakter.fpoversikt;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;

public record SamtidigUttak(@JsonValue BigDecimal value) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SamtidigUttak { // NOSONAR
    }
}
