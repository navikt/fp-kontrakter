package no.nav.foreldrepenger.kontrakter.fpwsproxy.simulering.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record Refusjonsinfo156Dto(@NotNull LocalDate maksDato,
                                  @NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String refunderesId,
                                  @NotNull LocalDate datoFom) {
}
