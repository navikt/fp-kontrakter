package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FpVedtak(@NotNull List<@NotNull @Valid UttakPeriode> perioder, List<@NotNull @Valid UttakPeriodeAnnenpartEøs> perioderAnnenpartEøs, @Valid Beregningsgrunnlag beregningsgrunnlag) {}
