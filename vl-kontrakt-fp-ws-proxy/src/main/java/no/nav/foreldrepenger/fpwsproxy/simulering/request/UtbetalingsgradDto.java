package no.nav.foreldrepenger.fpwsproxy.simulering.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
