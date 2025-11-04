package no.nav.foreldrepenger.kontrakter.fpoversikt.svp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;

public record PeriodeResultat(ResultatType resultatType,
                              Utbetalingsgrad utbetalingsgrad) {

    public record Utbetalingsgrad(@JsonValue BigDecimal value) {
        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        public Utbetalingsgrad { // NOSONAR
        }
    }

    public enum ResultatType {
        INNVILGET,
        AVSLAG_SØKNADSFRIST,
        AVSLAG_ANNET
    }
}
