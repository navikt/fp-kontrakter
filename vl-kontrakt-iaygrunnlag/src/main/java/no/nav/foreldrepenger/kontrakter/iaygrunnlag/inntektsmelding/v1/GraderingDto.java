package no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class GraderingDto {

    @JsonProperty(value = "periode", required = true)
    @NotNull
    @Valid
    private Periode periode;

    @JsonProperty(value = "arbeidstidProsent", required = true)
    @DecimalMin(value = "0.00", message = "prosentsats ${validatedValue} må være >= {value}")
    @DecimalMax(value = "100.00", message = "prosentsats ${validatedValue} må være <= {value}")
    private BigDecimal arbeidstidProsent;

    protected GraderingDto() {
        // default ctor
    }

    public GraderingDto(Periode periode, BigDecimal arbeidstidProsent) {
        Objects.requireNonNull(periode, "periode");
        this.periode = periode;
        this.arbeidstidProsent = arbeidstidProsent == null ? null : arbeidstidProsent.setScale(2, RoundingMode.HALF_UP);
    }

    public GraderingDto(Periode periode, int arbeidstidProsent) {
        this(periode, BigDecimal.valueOf(arbeidstidProsent));
    }

    public Periode getPeriode() {
        return periode;
    }

    public BigDecimal getArbeidstidProsent() {
        return arbeidstidProsent;
    }
}
