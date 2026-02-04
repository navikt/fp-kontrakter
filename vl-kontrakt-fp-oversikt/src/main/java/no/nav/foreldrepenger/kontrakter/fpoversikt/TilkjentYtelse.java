package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.AktivitetStatus;

import java.time.LocalDate;
import java.util.List;

public record TilkjentYtelse(@NotNull List<TilkjentYtelsePeriode> utbetalingsPerioder,
                             @NotNull List<FeriepengeAndel> feriepenger) {

    public record TilkjentYtelsePeriode(@NotNull LocalDate fom, @NotNull LocalDate tom, @NotNull List<Andel> andeler) {
        public record Andel(AktivitetStatus aktivitetStatus,
                            String arbeidsgiverIdent,
                            String arbeidsgivernavn,
                            @NotNull Integer dagsats,
                            @NotNull boolean tilBruker,
                            @NotNull Double utbetalingsgrad) {
        }
    }

    public record FeriepengeAndel(@NotNull LocalDate opptjeningsår, @NotNull Integer årsbeløp,
                                  @NotNull String arbeidsgiverIdent, @NotNull boolean tilBruker) {
    }

}
