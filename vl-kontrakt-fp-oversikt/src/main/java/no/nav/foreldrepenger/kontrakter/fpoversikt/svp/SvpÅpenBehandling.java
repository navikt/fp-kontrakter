package no.nav.foreldrepenger.kontrakter.fpoversikt.svp;

import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.fpoversikt.BehandlingTilstand;

public record SvpÅpenBehandling(@NotNull BehandlingTilstand tilstand, @NotNull Søknad søknad) {
}
