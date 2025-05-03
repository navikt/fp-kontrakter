package no.nav.foreldrepenger.kontrakter.simulering.resultat.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SimuleringResultatRequest(@NotNull @Min(0) @Max(Long.MAX_VALUE) Long behandlingId,
                                        @NotNull @Valid UUID behandlingUuid,
                                        @NotNull @Digits(integer = 18, fraction = 0) String saksnummer) { }
