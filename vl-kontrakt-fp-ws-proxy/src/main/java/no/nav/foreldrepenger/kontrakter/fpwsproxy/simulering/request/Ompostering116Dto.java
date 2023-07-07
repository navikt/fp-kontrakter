package no.nav.foreldrepenger.kontrakter.fpwsproxy.simulering.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record Ompostering116Dto(@NotNull boolean omPostering,
                                LocalDate datoOmposterFom,
                                @NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String tidspktReg) {
}
