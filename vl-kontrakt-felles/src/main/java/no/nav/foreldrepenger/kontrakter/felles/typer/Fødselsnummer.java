package no.nav.foreldrepenger.kontrakter.felles.typer;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import static no.nav.foreldrepenger.kontrakter.felles.validering.InputValideringRegex.FRITEKST;

public record Fødselsnummer(@Pattern(regexp = FRITEKST) @NotNull @JsonValue String value) {

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [fnr=******]";
    }
}
