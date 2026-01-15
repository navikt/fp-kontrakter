package no.nav.foreldrepenger.kontrakter.simulering.resultat.v1;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PeriodeDto(@NotNull LocalDate fom, @NotNull LocalDate tom) { }
