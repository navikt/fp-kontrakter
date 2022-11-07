package no.nav.foreldrepenger.kontrakter.simulering;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

/**
 * Samme som DatoIntervallEntitet
 * @param fomDate
 * @param tomDate
 */
public record LukketPeriode(@NotNull LocalDate fomDate, @NotNull LocalDate tomDate) {
}
