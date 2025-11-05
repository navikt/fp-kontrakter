package no.nav.foreldrepenger.kontrakter.fpoversikt.inntektsmelding;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Refusjon(BigDecimal refusjonsbeløpMnd, LocalDate fomDato) {
}
