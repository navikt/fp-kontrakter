package no.nav.foreldrepenger.kontrakter.formidling.v3;

import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UuidDto(@NotNull @Valid UUID behandlingUuid) {
    public UuidDto(String uuid) {
        this(UUID.fromString(uuid));
    }
}
