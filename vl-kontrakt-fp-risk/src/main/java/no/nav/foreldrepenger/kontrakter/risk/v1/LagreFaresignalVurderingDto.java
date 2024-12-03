package no.nav.foreldrepenger.kontrakter.risk.v1;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.FaresignalVurdering;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.Saksnummer;

import java.util.UUID;

public record LagreFaresignalVurderingDto(@NotNull UUID konsumentId,
                                          @Valid Saksnummer saksnummer,
                                          @NotNull FaresignalVurdering faresignalVurdering) {
}
