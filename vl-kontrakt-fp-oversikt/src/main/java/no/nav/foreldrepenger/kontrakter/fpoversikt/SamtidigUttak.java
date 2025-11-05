package no.nav.foreldrepenger.kontrakter.fpoversikt;

import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;

public record SamtidigUttak(@JsonValue BigDecimal value) {
}
