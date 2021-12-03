package no.nav.foreldrepenger.kontrakter.risk.v1;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.FaresignalVurdering;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public record LagreRisikovurderingDto(@NotNull UUID konsumentId, @NotNull FaresignalVurdering faresignalVurdering) {
}
