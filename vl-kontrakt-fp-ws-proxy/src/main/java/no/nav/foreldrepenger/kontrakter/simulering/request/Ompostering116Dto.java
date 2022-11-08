package no.nav.foreldrepenger.kontrakter.simulering.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record Ompostering116Dto(@NotNull boolean omPostering,
                                LocalDate datoOmposterFom,
                                @NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String tidspktReg) {
}
