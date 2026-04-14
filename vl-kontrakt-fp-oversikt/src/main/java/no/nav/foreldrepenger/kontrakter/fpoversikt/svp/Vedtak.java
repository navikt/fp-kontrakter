package no.nav.foreldrepenger.kontrakter.fpoversikt.svp;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.fpoversikt.Beregningsgrunnlag;
import no.nav.foreldrepenger.kontrakter.fpoversikt.TilkjentYtelse;

import java.util.Set;


public record Vedtak(@NotNull Set<SvpArbeidsforhold> arbeidsforhold, AvslagÅrsak avslagÅrsak,
                     @Valid Beregningsgrunnlag beregningsgrunnlag, @Valid TilkjentYtelse tilkjentYtelse) {

    public enum AvslagÅrsak {
        ARBEIDSGIVER_KAN_TILRETTELEGGE,
        SØKER_ER_INNVILGET_SYKEPENGER,
        MANGLENDE_DOKUMENTASJON,
        ANNET,
    }
}
