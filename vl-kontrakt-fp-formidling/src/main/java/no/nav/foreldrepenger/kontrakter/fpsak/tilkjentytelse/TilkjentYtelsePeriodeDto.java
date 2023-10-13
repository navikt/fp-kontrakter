package no.nav.foreldrepenger.kontrakter.fpsak.tilkjentytelse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record TilkjentYtelsePeriodeDto(@NotNull LocalDate fom,
                                       @NotNull LocalDate tom,
                                       Integer dagsats,
                                       @Valid List<TilkjentYtelseAndelDto> andeler) {}
