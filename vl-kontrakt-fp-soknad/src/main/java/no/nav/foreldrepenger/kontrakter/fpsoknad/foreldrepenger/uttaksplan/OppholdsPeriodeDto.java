package no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record OppholdsPeriodeDto(@NotNull LocalDate fom, @NotNull LocalDate tom, @NotNull Oppholdsårsak årsak) implements Uttaksplanperiode {
}
