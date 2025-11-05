package no.nav.foreldrepenger.kontrakter.fpoversikt.inntektsmelding;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BortfaltNaturalytelse(LocalDate fomDato, LocalDate tomDato, BigDecimal beløpPerMnd, NaturalytelseType type) {
}
