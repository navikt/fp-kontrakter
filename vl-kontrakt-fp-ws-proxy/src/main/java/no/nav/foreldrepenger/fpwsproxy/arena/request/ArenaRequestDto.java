package no.nav.foreldrepenger.fpwsproxy.arena.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
