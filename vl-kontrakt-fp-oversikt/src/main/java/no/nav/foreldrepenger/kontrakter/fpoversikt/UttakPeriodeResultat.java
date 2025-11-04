package no.nav.foreldrepenger.kontrakter.fpoversikt;

public record UttakPeriodeResultat(boolean innvilget, boolean trekkerMinsterett, boolean trekkerDager, UttakPeriodeResultatÅrsak årsak) {

    public enum UttakPeriodeResultatÅrsak {
        ANNET,
        AVSLAG_HULL_MELLOM_FORELDRENES_PERIODER,
        AVSLAG_FRATREKK_PLEIEPENGER,
        AVSLAG_UTSETTELSE_TILBAKE_I_TID,
        INNVILGET_UTTAK_AVSLÅTT_GRADERING_TILBAKE_I_TID,
    }
}

