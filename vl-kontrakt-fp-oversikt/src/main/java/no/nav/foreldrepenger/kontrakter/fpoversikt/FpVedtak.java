package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.Valid;

public record FpVedtak(@Valid Beregningsgrunnlag beregningsgrunnlag,
                       @Valid TilkjentYtelse tilkjentYtelse) {
}
