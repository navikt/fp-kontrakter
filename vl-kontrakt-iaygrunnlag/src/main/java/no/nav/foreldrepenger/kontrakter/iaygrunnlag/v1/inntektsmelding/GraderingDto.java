package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.inntektsmelding;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class GraderingDto {
    
    @JsonProperty(value = "periode", required = true)
    @NotNull
    @Valid
    private PeriodeDto periode;
    
    @JsonProperty(value = "arbeidstidProsent", required = true)
    @DecimalMin(value="0.00", message = "prosentsats >= 0.00")
    @DecimalMax(value="500.00", message="prosentsats < 500.00") // TODO: sane maks verdi
    private BigDecimal arbeidstidProsent;

    protected GraderingDto() {
        // default ctor
    }
    
    public GraderingDto(PeriodeDto periode, BigDecimal arbeidstidProsent) {
        this.periode = periode;
        this.arbeidstidProsent = arbeidstidProsent;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public BigDecimal getArbeidstidProsent() {
        return arbeidstidProsent;
    }
}
