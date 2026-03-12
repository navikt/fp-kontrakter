package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.constraints.NotNull;

public record Gradering(@NotNull Arbeidstidprosent arbeidstidprosent, Aktivitet aktivitet) {
}
