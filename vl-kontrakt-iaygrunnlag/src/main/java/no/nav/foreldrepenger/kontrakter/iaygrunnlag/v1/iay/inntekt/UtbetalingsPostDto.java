package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektspostTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.SkatteOgAvgiftsregelTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.NON_EMPTY)
public class UtbetalingsPostDto {

    @JsonProperty(value="inntektspostType", required = true)
    @Valid
    private InntektspostTypeDto inntektspostType;
    
    @JsonProperty("skattAvgiftType")
    @Valid
    private SkatteOgAvgiftsregelTypeDto skattAvgiftType;
    
    @JsonProperty(value = "periode", required=true)
    @Valid
    private PeriodeDto periode;
    
    @JsonProperty("beløp")
    @Valid
    @DecimalMin(value="0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value="1000000.00", message="beløp må være < 1000000.00")
    private BigDecimal beløp;
    
    @JsonProperty(value= "ytelseType", required=true)
    @Valid
    private YtelseTypeDto ytelseType;

    protected UtbetalingsPostDto() {
    }
    
    public UtbetalingsPostDto(YtelseTypeDto ytelseType, PeriodeDto periode, InntektspostTypeDto inntektspostType) {
        this.ytelseType = ytelseType;
        this.periode = periode;
        this.inntektspostType = inntektspostType;
    }

    public InntektspostTypeDto getInntektspostType() {
        return inntektspostType;
    }

    public SkatteOgAvgiftsregelTypeDto getSkattAvgiftType() {
        return skattAvgiftType;
    }

    public void setSkattAvgiftType(SkatteOgAvgiftsregelTypeDto skattAvgiftType) {
        this.skattAvgiftType = skattAvgiftType;
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

    public YtelseTypeDto getYtelseType() {
        return ytelseType;
    }
}
