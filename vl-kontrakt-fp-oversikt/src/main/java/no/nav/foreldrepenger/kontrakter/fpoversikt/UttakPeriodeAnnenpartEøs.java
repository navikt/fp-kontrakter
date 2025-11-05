package no.nav.foreldrepenger.kontrakter.fpoversikt;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.KontoType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UttakPeriodeAnnenpartEøs(@NotNull LocalDate fom,
                                       @NotNull LocalDate tom,
                                       @NotNull KontoType trekkonto,
                                       @NotNull KontoType kontoType,
                                       @Valid @NotNull Trekkdager trekkdager) {

    public record Trekkdager(@Min(0) @Digits(integer = 3, fraction = 1) @JsonValue BigDecimal verdi) {
    }
}
