package no.nav.foreldrepenger.kontrakter.formidling.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BehandlingUuidDto {

    public static final String NAME = "uuid";
    public static final String DESC = "behandlingUUID";

    @NotNull
    @Valid
    private UUID behandlingUuid;

    public BehandlingUuidDto() { //For Jackson
    }

    public BehandlingUuidDto(UUID behandlingUuid) {
        this.behandlingUuid = behandlingUuid;
    }

    public BehandlingUuidDto(String behandlingUuid) {
        this(UUID.fromString(behandlingUuid));
    }

    public UUID getBehandlingUuid() {
        return behandlingUuid;
    }
}
