package no.nav.foreldrepenger.kontrakter.fpoversikt.svp;

import jakarta.validation.constraints.NotNull;

import java.util.Set;


public record Vedtak(@NotNull Set<SvpArbeidsforhold> arbeidsforhold, AvslagÅrsak avslagÅrsak) {

    public enum AvslagÅrsak {
        ARBEIDSGIVER_KAN_TILRETTELEGGE,
        SØKER_ER_INNVILGET_SYKEPENGER,
        MANGLENDE_DOKUMENTASJON,
        ANNET,
    }
}
