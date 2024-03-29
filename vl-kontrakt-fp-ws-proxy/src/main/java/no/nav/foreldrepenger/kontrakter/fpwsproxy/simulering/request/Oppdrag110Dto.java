package no.nav.foreldrepenger.kontrakter.fpwsproxy.simulering.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Skal være samme som no.nav.foreldrepenger.behandlingslager.økonomioppdrag.Oppdrag110
 */
public record Oppdrag110Dto(@Valid @NotNull KodeEndring kodeEndring,
                            @Valid @NotNull KodeFagområde kodeFagomrade,
                            @NotNull @Pattern(regexp = "^[a-zA-Z0-9-]+$") String fagsystemId,
                            @NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String oppdragGjelderId,
                            @NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String saksbehId,
                            @Valid Ompostering116Dto ompostering116,
                            @Valid @NotNull @Size(min = 1) List<@Valid @NotNull Oppdragslinje150Dto> oppdragslinje150Liste) {

}
