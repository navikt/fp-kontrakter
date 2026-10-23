package no.nav.foreldrepenger.kontrakter.fpoversikt.svp;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record OppholdPeriode(@NotNull LocalDate fom, @NotNull LocalDate tom, @NotNull OppholdPeriode.OppholdÅrsak årsak, @NotNull OppholdKilde oppholdKilde) {
    public enum OppholdÅrsak {
        SYKEPENGER,
        FERIE
    }
    public enum OppholdKilde {
        SAKSBEHANDLER,
        INNTEKTSMELDING,
        SØKNAD
    }
}
