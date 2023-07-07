package no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.AktivitetStatusDto;
import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.HjemmelDto;


public record BeregningsgrunnlagDto(@NotNull @Valid @Size(min = 1) List<AktivitetStatusDto> aktivitetstatusListe,
                                    @NotNull @Valid HjemmelDto hjemmel,
                                    @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000000.00") BigDecimal grunnbeløp,
                                    @Valid @NotNull @Size(min = 1) List<BeregningsgrunnlagPeriodeDto> beregningsgrunnlagperioder,
                                    @Valid boolean erBesteberegnet,
                                    @NotNull @Valid boolean seksAvDeTiBeste) {
}
