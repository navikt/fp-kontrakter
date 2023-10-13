package no.nav.foreldrepenger.kontrakter.fpsak.tilkjentytelse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record TilkjentYtelseDagytelseDto(@Valid @NotNull TilkjentYtelsePeriodeDto[] perioder) {}
