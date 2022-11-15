package no.nav.foreldrepenger.kontrakter.arena.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record ArenaRequestDto(@NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String ident,
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
