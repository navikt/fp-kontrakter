package no.nav.foreldrepenger.kontrakter.felles.typer;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import no.nav.foreldrepenger.kontrakter.felles.validering.Orgnr;

import static no.nav.foreldrepenger.kontrakter.felles.validering.InputValideringRegex.FRITEKST;
import static no.nav.foreldrepenger.kontrakter.felles.validering.InputValideringRegex.ORGNUMMER;

public record Orgnummer(@JsonValue @Pattern(regexp = ORGNUMMER) @NotNull @Orgnr String value) {

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [orgnr='******']";
    }
}
