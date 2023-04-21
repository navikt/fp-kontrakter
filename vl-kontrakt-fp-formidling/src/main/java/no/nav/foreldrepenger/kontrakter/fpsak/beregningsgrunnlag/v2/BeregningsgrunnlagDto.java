package no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.AktivitetStatusDto;
import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.HjemmelDto;


public record BeregningsgrunnlagDto(@NotNull @Valid @Size(min = 1) List<AktivitetStatusDto> aktivitetstatusListe,
                                    @NotNull @Valid HjemmelDto hjemmel,
                                    @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000000.00") BigDecimal grunnbeløp,
                                    @Valid @NotNull @Size(min = 1) List<BeregningsgrunnlagPeriodeDto> beregningsgrunnlagperioder,
                                    @Valid boolean erBesteberegnet,
                                    @NotNull @Valid boolean seksAvDeTiBeste) {
}
