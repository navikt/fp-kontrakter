package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.fpoversikt.svp.SvpSak;

import java.util.Set;

public record Saker(@NotNull Set<FpSak> foreldrepenger,
                    @NotNull Set<EsSak> engangsstønad,
                    @NotNull Set<SvpSak> svangerskapspenger) {
}
