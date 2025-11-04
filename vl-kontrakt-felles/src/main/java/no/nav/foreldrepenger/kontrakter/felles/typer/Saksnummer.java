package no.nav.foreldrepenger.kontrakter.felles.typer;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

public record Saksnummer(@JsonValue @NotNull @Digits(integer = 18, fraction = 0) String value) {

}
