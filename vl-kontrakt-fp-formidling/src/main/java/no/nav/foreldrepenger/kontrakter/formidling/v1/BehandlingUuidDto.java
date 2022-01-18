package no.nav.foreldrepenger.kontrakter.formidling.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public record BehandlingUuidDto(@NotNull @Valid UUID behandlingUuid) {

    public BehandlingUuidDto(String behandlingUuid) {
        this(UUID.fromString(behandlingUuid));
    }

    public UUID getBehandlingUuid() {
        return behandlingUuid;
    }
}
