package no.nav.foreldrepenger.web.app.tjenester.formidling.beregningsgrunnlag.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.nav.foreldrepenger.fpformidling.beregningsgrunnlag.v2.kodeverk.AktivitetStatus;
import no.nav.foreldrepenger.fpformidling.beregningsgrunnlag.v2.kodeverk.Hjemmel;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;


public record BeregningsgrunnlagDto(@NotNull @Valid @Size(min = 1) List<AktivitetStatus> aktivitetstatusListe,
                                    @NotNull @Valid Hjemmel hjemmel,
                                    @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000000.00") BigDecimal grunnbeløp,
                                    @Valid @NotNull @Size(min = 1) List<BeregningsgrunnlagPeriodeDto> beregningsgrunnlagperioder,
                                    @Valid boolean erBesteberegnet) {
}
