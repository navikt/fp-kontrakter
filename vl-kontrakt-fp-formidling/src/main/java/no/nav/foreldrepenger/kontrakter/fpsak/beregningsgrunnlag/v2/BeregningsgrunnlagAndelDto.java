package no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.AktivitetStatus;
import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.OpptjeningAktivitetType;

public record BeregningsgrunnlagAndelDto(
        @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000.00") Long dagsats,
        @Valid @NotNull AktivitetStatus aktivitetStatus,
        @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000000.00") BigDecimal bruttoPrÅr,
        @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000000.00") BigDecimal avkortetPrÅr,
        @Valid Boolean erNyIArbeidslivet,
        @Valid @NotNull OpptjeningAktivitetType arbeidsforholdType,
        @Valid LocalDate beregningsperiodeFom,
        @Valid LocalDate beregningsperiodeTom,
        @Valid BgAndelArbeidsforholdDto arbeidsforhold,
        @Valid Boolean erTilkommetAndel) {
}
