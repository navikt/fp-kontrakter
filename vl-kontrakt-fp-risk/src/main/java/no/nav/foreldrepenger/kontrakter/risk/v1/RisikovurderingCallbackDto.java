package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.RisikoklasseType;

public record RisikovurderingCallbackDto(@NotNull UUID behandlingUuid, @NotNull RisikoklasseType risikoklasse) {
}
