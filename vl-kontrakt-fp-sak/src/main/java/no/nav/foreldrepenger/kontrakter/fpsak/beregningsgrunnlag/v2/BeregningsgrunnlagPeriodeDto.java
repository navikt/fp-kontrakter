package no.nav.foreldrepenger.web.app.tjenester.formidling.beregningsgrunnlag.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.nav.foreldrepenger.fpformidling.beregningsgrunnlag.v2.kodeverk.PeriodeÅrsak;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record BeregningsgrunnlagPeriodeDto(@Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000.00") Long dagsats,
                                           @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000000.00") BigDecimal bruttoPrÅr,
                                           @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000000.00") BigDecimal avkortetPrÅr,
                                           @Valid List<PeriodeÅrsak> periodeårsaker,
                                           @Valid LocalDate beregningsgrunnlagperiodeFom,
                                           @Valid LocalDate beregningsgrunnlagperiodeTom,
                                           @Valid @Size(min = 1) List<BeregningsgrunnlagAndelDto> beregningsgrunnlagandeler) {
}
