package no.nav.foreldrepenger.kontrakter.fpsak.tilkjentytelse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TilkjentYtelseDagytelseDto(@Valid @NotNull List<TilkjentYtelsePeriodeDto> perioder) {}
