package no.nav.foreldrepenger.fpwsproxy.simulering.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Skal være samme som no.nav.foreldrepenger.behandlingslager.økonomioppdrag.Oppdrag110
 */
public record Oppdrag110Dto(@Valid @NotNull KodeEndring kodeEndring,
                            @Valid @NotNull KodeFagområde kodeFagomrade,
                            @NotNull @Min(0) @Max(Long.MAX_VALUE) Long fagsystemId,
                            @NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String oppdragGjelderId,
                            @NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String saksbehId,
                            @Valid Ompostering116Dto ompostering116,
                            @Valid @NotNull @Size(min = 1) List<@Valid @NotNull Oppdragslinje150Dto> oppdragslinje150Liste) {

}
