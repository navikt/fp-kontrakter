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

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.NaturalytelseTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.ALWAYS)
public class NaturalytelseDto {
    
    @JsonProperty(value = "periode", required = true)
    @Valid
    @NotNull
    private PeriodeDto periode;
    
    @JsonProperty("beløpPerMnd")
    @DecimalMin(value="0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value="1000000.00", message="beløp må være < 1000000.00")  // TODO: sane verdier
    private BigDecimal beløpPerMnd;
    
    @JsonProperty(value = "naturalytelseType", required = true)
    @Valid
    @NotNull
    private NaturalytelseTypeDto type;

    protected NaturalytelseDto() {
        // default ctor
    }
    
    public NaturalytelseDto(PeriodeDto periode, NaturalytelseTypeDto type, BigDecimal beløpPerMnd) {
        this.periode = periode;
        this.type = type;
        this.beløpPerMnd = beløpPerMnd;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public BigDecimal getBeløpPerMnd() {
        return beløpPerMnd;
    }

    public NaturalytelseTypeDto getType() {
        return type;
    }
}
