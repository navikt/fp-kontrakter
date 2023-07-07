package no.nav.foreldrepenger.kontrakter.fpwsproxy.arena.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ArenaRequestDto(@NotNull @Pattern(regexp = "^\\d{11}$", message = "Fnr har ikke gyldig verdi (pattern '{regexp}')") String ident,
                              LocalDate fom, LocalDate tom) {

    @Override
    public String toString() {
        return "ArenaRequestDto{" +
                "ident='***'" +
                ", fom=" + fom +
                ", tom=" + tom +
                '}';
    }
}
