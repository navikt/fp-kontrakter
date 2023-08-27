package no.nav.foreldrepenger.kontrakter.fpwsproxy.simulering.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record UtbetalingsgradDto(@Min(0) @Max(100) @Digits(integer = 3, fraction = 0) @JsonValue Integer verdi) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static UtbetalingsgradDto valueOf(Number verdi) {
        return new UtbetalingsgradDto(verdi.intValue());
    }

    @Override
    public Integer verdi() {
        return verdi;
    }
}
