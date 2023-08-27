package no.nav.foreldrepenger.kontrakter.fpwsproxy.simulering.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record OppdragskontrollDto(@NotNull @Min(0) @Max(Long.MAX_VALUE) Long behandlingId,
                                  @Valid @Size(min = 1) List<@Valid @NotNull Oppdrag110Dto> oppdrag) {
}
