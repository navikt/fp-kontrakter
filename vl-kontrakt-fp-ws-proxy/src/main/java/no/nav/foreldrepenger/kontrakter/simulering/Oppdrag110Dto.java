package no.nav.foreldrepenger.kontrakter.simulering;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import no.nav.vedtak.util.InputValideringRegex;

/**
 * Skal være samme som no.nav.foreldrepenger.behandlingslager.økonomioppdrag.Oppdrag110
 */
public record Oppdrag110Dto(@Valid @NotNull KodeEndring kodeEndring,
                            @Valid @NotNull KodeFagområde kodeFagomrade,
                            @NotNull @Min(0) @Max(Long.MAX_VALUE) Long fagsystemId,
                            @NotNull @Pattern(regexp = InputValideringRegex.FRITEKST) String oppdragGjelderId,
                            @NotNull @Pattern(regexp = InputValideringRegex.FRITEKST) String saksbehId,
                            @NotNull @Pattern(regexp = InputValideringRegex.FRITEKST) String nøkkelAvstemming,
                            @Valid Ompostering116Dto ompostering116,
                            @Valid @Size List<@Valid Oppdragslinje150Dto> oppdragslinje150Liste) {

    public Oppdrag110Dto {
        oppdragslinje150Liste = Optional.ofNullable(oppdragslinje150Liste).orElse(List.of());
    }
}
