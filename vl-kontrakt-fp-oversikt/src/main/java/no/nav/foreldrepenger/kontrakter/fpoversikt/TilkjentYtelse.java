package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.AktivitetStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record TilkjentYtelse(@NotNull List<@Valid TilkjentYtelsePeriode> utbetalingsperioder,
                             @NotNull List<@Valid FeriepengeAndel> feriepenger) {

    public record TilkjentYtelsePeriode(@NotNull LocalDate fom, @NotNull LocalDate tom, @NotNull List<Andel> andeler) {
        public record Andel(@NotNull AktivitetStatus aktivitetStatus, String arbeidsgiverIdent, String arbeidsgivernavn,
                            @NotNull BigDecimal dagsats, @NotNull boolean tilBruker,
                            @NotNull @Min(0) @Max(100) @Digits(integer = 3, fraction = 2) BigDecimal utbetalingsgrad) {
        }
    }

    public record FeriepengeAndel(@NotNull LocalDate opptjeningsår, @NotNull BigDecimal årsbeløp,
                                  String arbeidsgiverIdent, @NotNull boolean tilBruker) {
    }

}
