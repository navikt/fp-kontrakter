package no.nav.foreldrepenger.kontrakter.felles.typer;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import static no.nav.foreldrepenger.kontrakter.felles.validering.InputValideringRegex.FRITEKST;
import static no.nav.foreldrepenger.kontrakter.felles.validering.InputValideringRegex.NORSK_FØDSELSNUMMER;

public record Fødselsnummer(@Pattern(regexp = NORSK_FØDSELSNUMMER) @NotNull @JsonValue String value) {

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [fnr=******]";
    }
}
