package no.nav.foreldrepenger.kontrakter.felles.typer;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.Pattern;

import static no.nav.foreldrepenger.kontrakter.felles.validering.InputValideringRegex.BARE_TALL;

public record AktørId(@JsonValue @Pattern(regexp = BARE_TALL) String value) {

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [aktørid='******']";
    }
}