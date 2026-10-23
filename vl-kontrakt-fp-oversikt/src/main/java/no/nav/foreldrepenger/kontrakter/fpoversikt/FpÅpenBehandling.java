package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.constraints.NotNull;

public record FpÅpenBehandling(@NotNull BehandlingTilstand tilstand) { }
