package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektPeriodeTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class FordelingDto {

    @JsonProperty(value="arbeidsgiver", required = true)
    @Valid
    @NotNull
    private ArbeidsgiverDto arbeidsgiver;
    
    @JsonProperty("beløp")
    @DecimalMin(value="0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value="100000.00", message="beløp må være < 100000.00")  // TODO: sane verdier
    private BigDecimal beløp;
    
    @JsonProperty("inntektPeriodeType")
    @Valid
    @NotNull
    private InntektPeriodeTypeDto hyppighet;

    protected FordelingDto() {
    }
    
    public FordelingDto(ArbeidsgiverDto arbeidsgiver, InntektPeriodeTypeDto inntektPeriodeType, BigDecimal beløp) {
        this.arbeidsgiver = arbeidsgiver;
        this.hyppighet = inntektPeriodeType;
        this.beløp = beløp;
    }

    public ArbeidsgiverDto getArbeidsgiver() {
        return arbeidsgiver;
    }

    public BigDecimal getBeløp() {
        return beløp;
    }

    public InntektPeriodeTypeDto getHyppighet() {
        return hyppighet;
    }

}
