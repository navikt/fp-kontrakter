package no.nav.foreldrepenger.web.app.tjenester.formidling.beregningsgrunnlag.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.nav.foreldrepenger.fpformidling.beregningsgrunnlag.v2.kodeverk.AktivitetStatus;
import no.nav.foreldrepenger.fpformidling.beregningsgrunnlag.v2.kodeverk.OpptjeningAktivitetType;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record BeregningsgrunnlagAndelDto(@Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000.00") Long dagsats,
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
