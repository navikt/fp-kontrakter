package no.nav.foreldrepenger.kontrakter.formidling.v1;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record BrevmalDto(@NotNull @Pattern(regexp = "[A-Z]{6}") String kode,
                         @NotNull String navn,
                         boolean tilgjengelig) {
}
