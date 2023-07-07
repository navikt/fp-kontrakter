package no.nav.foreldrepenger.kontrakter.formidling.v1;

import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record BehandlingUuidDto(@NotNull @Valid UUID behandlingUuid) {

    public BehandlingUuidDto(String behandlingUuid) {
        this(UUID.fromString(behandlingUuid));
    }

    @Deprecated // Bruk behandlingUuid()
    public UUID getBehandlingUuid() {
        return behandlingUuid;
    }
}
