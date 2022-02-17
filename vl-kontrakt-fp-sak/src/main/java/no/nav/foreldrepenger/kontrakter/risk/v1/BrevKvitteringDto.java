package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record BrevKvitteringDto(
        @NotNull UUID behandlingUuid,
        @NotNull UUID bestillingUuid,
        @NotNull @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$") String journalpostId) {
}
