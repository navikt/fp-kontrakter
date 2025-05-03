package no.nav.foreldrepenger.kontrakter.fpwsproxy.simulering.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record StartSimuleringRequest(@NotNull @Valid OppdragskontrollDto dto,
                                     @NotNull @Valid UUID behandlingUuid,
                                     @NotNull @Digits(integer = 18, fraction = 0) String saksnummer) {}
