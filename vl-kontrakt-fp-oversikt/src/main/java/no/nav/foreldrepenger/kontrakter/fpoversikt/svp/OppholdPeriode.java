package no.nav.foreldrepenger.kontrakter.fpoversikt.svp;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record OppholdPeriode(@NotNull LocalDate fom, @NotNull LocalDate tom, @NotNull OppholdPeriode.OppholdÅrsak årsak) {
    public enum OppholdÅrsak {
        SYKEPENGER,
        FERIE
    }
}
