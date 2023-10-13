package no.nav.foreldrepenger.kontrakter.fpsak.tilkjentytelse;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record TilkjentYtelseEngangsstønadDto(@Min(0) @Max(Long.MAX_VALUE) Long beregnetTilkjentYtelse) {}
