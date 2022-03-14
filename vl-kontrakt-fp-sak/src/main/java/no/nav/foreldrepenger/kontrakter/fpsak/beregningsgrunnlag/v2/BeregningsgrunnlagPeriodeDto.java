package no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.PeriodeÅrsak;

public record BeregningsgrunnlagPeriodeDto(
        @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000.00") Long dagsats,
        @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000000.00") BigDecimal bruttoPrÅr,
        @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000000.00") BigDecimal avkortetPrÅr,
        @Valid List<PeriodeÅrsak> periodeårsaker,
        @Valid LocalDate beregningsgrunnlagperiodeFom,
        @Valid LocalDate beregningsgrunnlagperiodeTom,
        @Valid @Size(min = 1) List<BeregningsgrunnlagAndelDto> beregningsgrunnlagandeler) {
}
