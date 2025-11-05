package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FpÅpenBehandling(@NotNull BehandlingTilstand tilstand, @NotNull List<UttakPeriode> søknadsperioder) { }
