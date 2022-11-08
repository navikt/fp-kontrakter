package no.nav.foreldrepenger.kontrakter.simulering.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record SatsDto(@Min(0) @Max(value = Integer.MAX_VALUE) @Digits(integer = 9, fraction = 0) @JsonValue Integer verdi) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SatsDto valueOf(Number verdi) {
        return new SatsDto(verdi.intValue());
    }

    @Override
    public Integer verdi() {
        return verdi;
    }
}
