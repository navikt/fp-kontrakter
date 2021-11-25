package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public record HentRisikovurderingDto(@NotNull UUID konsumentId) {
}
