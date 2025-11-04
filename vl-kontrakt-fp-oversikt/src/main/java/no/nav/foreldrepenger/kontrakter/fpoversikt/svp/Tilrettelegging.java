package no.nav.foreldrepenger.kontrakter.fpoversikt.svp;

import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.fpoversikt.Arbeidstidprosent;

import java.time.LocalDate;

public record Tilrettelegging(@NotNull LocalDate fom,
                              @NotNull LocalDate tom,
                              TilretteleggingType type,
                              Arbeidstidprosent arbeidstidprosent,
                              PeriodeResultat resultat) {

}
