package no.nav.foreldrepenger.kontrakter.risk.v1;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.FaresignalVurdering;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record LagreFaresignalVurderingDto(@NotNull UUID konsumentId, @NotNull FaresignalVurdering faresignalVurdering) {
}
