package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public record SaksnummerDto(@NotNull @Size(max = 30) @Pattern(regexp = "^[a-zA-Z0-9_\\-]*$") String saksnummer) {

    public SaksnummerDto {
        Objects.requireNonNull(saksnummer, "saksnummer");
    }

}
