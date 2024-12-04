package no.nav.foreldrepenger.kontrakter.risk.v1;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.Saksnummer;

import java.util.UUID;

public record HentRisikovurderingDto(@NotNull UUID konsumentId,
                                     @Valid Saksnummer saksnummer) {
}
