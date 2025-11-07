package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.constraints.NotNull;

public record UttakPeriodeResultat(@NotNull boolean innvilget, @NotNull boolean trekkerMinsterett, @NotNull boolean trekkerDager, @NotNull UttakPeriodeResultatÅrsak årsak) {

    public enum UttakPeriodeResultatÅrsak {
        ANNET,
        AVSLAG_HULL_MELLOM_FORELDRENES_PERIODER,
        AVSLAG_FRATREKK_PLEIEPENGER,
        AVSLAG_UTSETTELSE_TILBAKE_I_TID,
        INNVILGET_UTTAK_AVSLÅTT_GRADERING_TILBAKE_I_TID,
    }
}

