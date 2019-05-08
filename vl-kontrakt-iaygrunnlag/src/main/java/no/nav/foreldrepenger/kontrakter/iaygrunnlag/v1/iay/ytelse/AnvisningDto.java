package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.ALWAYS)
public class AnvisningDto {

    @JsonProperty(value = "periode", required=true)
    @Valid
    private PeriodeDto periode;
    
    @JsonProperty(value = "beløp")
    @Valid
    @DecimalMin(value="0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value="1000000.00", message="beløp må være < 1000000.00")
    private BigDecimal beløp;
    
    @JsonProperty(value = "dagsats")
    @Valid
    @DecimalMin(value="0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value="100000.00", message="beløp må være < 100000.00")
    private BigDecimal dagsats;
    
    @JsonProperty(value = "utbetalingsgrad")
    @Valid
    @DecimalMin(value="0.00", message = "prosentsats >= 0.00")
    @DecimalMax(value="100.00", message="prosentsats < 100.00")
    private BigDecimal utbetalingsgrad;

    protected AnvisningDto() {
        // default ctor
    }
    
    public AnvisningDto(PeriodeDto periode) {
        this.periode = periode;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public BigDecimal getBeløp() {
        return beløp;
    }

    public void setBeløp(BigDecimal beløp) {
        this.beløp = beløp;
    }

    public BigDecimal getDagsats() {
        return dagsats;
    }

    public void setDagsats(BigDecimal dagsats) {
        this.dagsats = dagsats;
    }

    public BigDecimal getUtbetalingsgrad() {
        return utbetalingsgrad;
    }

    public void setUtbetalingsgrad(BigDecimal utbetalingsgrad) {
        this.utbetalingsgrad = utbetalingsgrad;
    }
}
