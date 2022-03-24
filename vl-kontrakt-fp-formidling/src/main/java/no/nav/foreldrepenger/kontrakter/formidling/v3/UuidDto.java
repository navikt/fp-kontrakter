package no.nav.foreldrepenger.kontrakter.formidling.v3;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public record UuidDto(@NotNull @Valid UUID behandlingUuid) {
    public UuidDto(String uuid) {
        this(UUID.fromString(uuid));
    }
}
