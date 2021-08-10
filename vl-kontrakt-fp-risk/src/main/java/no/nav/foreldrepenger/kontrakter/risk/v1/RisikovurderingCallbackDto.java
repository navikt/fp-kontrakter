package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.RisikoklasseType;

public record RisikovurderingCallbackDto(@NotNull @Valid UUID behandlingUuid, @NotNull RisikoklasseType risikoklasse) {
}
