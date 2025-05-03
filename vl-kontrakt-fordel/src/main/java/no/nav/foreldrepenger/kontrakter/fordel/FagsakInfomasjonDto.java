package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record FagsakInfomasjonDto(@NotNull @Digits(integer = 19, fraction = 0) String aktørId,
                                  @NotNull @Size(max = 8) @Pattern(regexp = "^[a-zA-Z0-9_-æøåÆØÅ]*$") String behandlingstemaOffisiellKode) {

}
