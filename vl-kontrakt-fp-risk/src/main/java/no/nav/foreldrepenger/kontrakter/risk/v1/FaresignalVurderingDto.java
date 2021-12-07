package no.nav.foreldrepenger.kontrakter.risk.v1;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.FaresignalVurdering;

import javax.validation.constraints.NotNull;

public record FaresignalVurderingDto(@NotNull FaresignalVurdering faresignalVurdering) {}
