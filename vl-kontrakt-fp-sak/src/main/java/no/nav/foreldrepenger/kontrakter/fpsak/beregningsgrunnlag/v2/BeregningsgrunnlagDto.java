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

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_ABSENT, content = JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE, setterVisibility = NONE, isGetterVisibility = NONE, creatorVisibility = NONE)
public class BeregningsgrunnlagDto {

    @JsonProperty(value = "aktivitetstatusListe")
    @NotNull
    @Valid
    @Size(min = 1)
    private List<AktivitetStatus> aktivitetstatusListe;

    @JsonProperty(value = "hjemmel")
    @NotNull
    @Valid
    private Hjemmel hjemmel;

    @JsonProperty(value = "grunnbeløp")
    @Valid
    @Digits(integer = 8, fraction = 2)
    @DecimalMin("0.00")
    @DecimalMax("10000000.00")
    private BigDecimal grunnbeløp;

    @JsonProperty(value = "beregningsgrunnlagperioder")
    @Valid
    @NotNull
    @Size(min = 1)
    private List<BeregningsgrunnlagPeriodeDto> beregningsgrunnlagperioder;

    @JsonProperty(value = "erBesteberegnet")
    @Valid
    private boolean erBesteberegnet;

    public BeregningsgrunnlagDto(@NotNull @Valid @Size(min = 1) List<AktivitetStatus> aktivitetstatusListe,
                                 @NotNull @Valid Hjemmel hjemmel,
                                 @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000000.00") BigDecimal grunnbeløp,
                                 @Valid @NotNull @Size(min = 1) List<BeregningsgrunnlagPeriodeDto> beregningsgrunnlagperioder,
                                 @Valid boolean erBesteberegnet) {
        this.aktivitetstatusListe = aktivitetstatusListe;
        this.hjemmel = hjemmel;
        this.grunnbeløp = grunnbeløp;
        this.beregningsgrunnlagperioder = beregningsgrunnlagperioder;
        this.erBesteberegnet = erBesteberegnet;
    }

    public List<AktivitetStatus> getAktivitetstatusListe() {
        return aktivitetstatusListe;
    }

    public Hjemmel getHjemmel() {
        return hjemmel;
    }

    public BigDecimal getGrunnbeløp() {
        return grunnbeløp;
    }

    public List<BeregningsgrunnlagPeriodeDto> getBeregningsgrunnlagperioder() {
        return beregningsgrunnlagperioder;
    }

    public boolean isErBesteberegnet() {
        return erBesteberegnet;
    }
}
