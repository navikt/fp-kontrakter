package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record AnnenPartSak(@NotNull List<@Valid @NotNull UttakPeriode> perioder, LocalDate termindato, @NotNull DekningsgradSak dekningsgrad, @NotNull int antallBarn) {
}
