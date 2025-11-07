package no.nav.foreldrepenger.kontrakter.fpoversikt.inntektsmelding;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Refusjon(@NotNull BigDecimal refusjonsbeløpMnd, @NotNull LocalDate fomDato) {
}
