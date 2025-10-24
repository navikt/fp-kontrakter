package no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record OverføringsPeriodeDto(@NotNull LocalDate fom,
                                    @NotNull LocalDate tom,
                                    @NotNull Overføringsårsak årsak,
                                    @NotNull KontoType konto) implements Uttaksplanperiode {
}
