package no.nav.foreldrepenger.kontrakter.fpoversikt.svp;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.fpoversikt.Aktivitet;

import java.time.LocalDate;
import java.util.Set;

public record SvpArbeidsforhold(@NotNull @Valid Aktivitet aktivitet,
                                LocalDate behovFrom,
                                String risikofaktorer,
                                String tiltak,
                                @NotNull Set<@Valid @NotNull Tilrettelegging> tilrettelegginger,
                                @NotNull Set<@Valid @NotNull OppholdPeriode> oppholdsperioder,
                                AvslutningÅrsak avslutningÅrsak) {
}
