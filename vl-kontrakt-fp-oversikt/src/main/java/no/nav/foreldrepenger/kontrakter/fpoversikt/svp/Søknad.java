package no.nav.foreldrepenger.kontrakter.fpoversikt.svp;

import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record Søknad(@NotNull Set<SvpArbeidsforhold> arbeidsforhold) {
}
