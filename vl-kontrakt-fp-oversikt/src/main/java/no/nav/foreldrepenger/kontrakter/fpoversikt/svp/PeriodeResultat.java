package no.nav.foreldrepenger.kontrakter.fpoversikt.svp;

import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;

public record PeriodeResultat(Utbetalingsgrad utbetalingsgrad) {

    public record Utbetalingsgrad(@JsonValue BigDecimal value) { }
}
