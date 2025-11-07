package no.nav.foreldrepenger.kontrakter.fpoversikt.inntektsmelding;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BortfaltNaturalytelse(@NotNull LocalDate fomDato, @NotNull LocalDate tomDato, @NotNull BigDecimal beløpPerMnd, @NotNull NaturalytelseType type) {
}
