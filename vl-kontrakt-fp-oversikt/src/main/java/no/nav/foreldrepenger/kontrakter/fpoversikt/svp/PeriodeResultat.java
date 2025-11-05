package no.nav.foreldrepenger.kontrakter.fpoversikt.svp;

import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;

public record PeriodeResultat(ResultatType resultatType, Utbetalingsgrad utbetalingsgrad) {

    public record Utbetalingsgrad(@JsonValue BigDecimal value) { }

    public enum ResultatType {
        INNVILGET,
        AVSLAG_SØKNADSFRIST,
        AVSLAG_ANNET
    }
}
