package no.nav.foreldrepenger.kontrakter.simulering;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record OppdragskontrollDto(@NotNull @Min(0) @Max(Long.MAX_VALUE) Long behandlingId,
                                  @Valid @Size(min = 1) List<@Valid @NotNull Oppdrag110Dto> oppdrag) {
}
