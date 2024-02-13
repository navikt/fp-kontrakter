package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

// TODO Sett @NotNull på saksnummer når fpsak og fprisk tar i bruk ny kontrakt
public record HentRisikovurderingDto(@NotNull UUID konsumentId, String saksnummer) {}
