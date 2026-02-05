package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.AktivitetStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record Beregningsgrunnlag(@NotNull LocalDate skjæringsTidspunkt,
                                 @NotNull List<@Valid BeregningsAndel> beregningsandeler,
                                 @NotNull List<@Valid BeregningAktivitetStatus> beregningAktivitetStatuser,
                                 BigDecimal grunnbeløp) {

    public record BeregningsAndel(@NotNull AktivitetStatus aktivitetStatus,
                                  @Min(0) @Digits(integer = 10, fraction = 2) BigDecimal fastsattPrÅr,
                                  Inntektskilde inntektsKilde,
                                  @Valid Arbeidsforhold arbeidsforhold,
                                  @NotNull @Min(0) @Digits(integer = 4, fraction = 0) BigDecimal dagsatsArbeidsgiver,
                                  @NotNull @Digits(integer = 4, fraction = 0) BigDecimal dagsatsSøker) {
    }

    public record Arbeidsforhold(@NotNull String arbeidsgiverIdent, @NotNull String arbeidsgiverNavn,
                                 @NotNull @Min(0) @Digits(integer = 10, fraction = 2) BigDecimal refusjonPrMnd) {
    }

    public record BeregningAktivitetStatus(@NotNull AktivitetStatus aktivitetStatus, String hjemmel) {
    }
}

