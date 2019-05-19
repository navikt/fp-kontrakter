package no.nav.foreldrepenger.kontrakter.iaygrunnlag.ytelse.v1;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Aktør;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektPeriodeType;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class FordelingDto {

    @JsonProperty(value="arbeidsgiver", required = true)
    @Valid
    @NotNull
    private Aktør arbeidsgiver;
    
    @JsonProperty("beløp")
    @Valid
    @DecimalMin(value="0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value="100000000.00", message="beløp må være < 100000000.00")  // TODO: sane verdier
    private BigDecimal beløp;
    
    /** Angir hvilken periode beløp gjelder for. */
    @JsonProperty("inntektPeriodeType")
    @Valid
    @NotNull
    private InntektPeriodeType inntektPeriodeType;

    protected FordelingDto() {
    }
    
    public FordelingDto(Aktør arbeidsgiver, InntektPeriodeType inntektPeriodeType, int beløp) {
        this(arbeidsgiver, inntektPeriodeType, BigDecimal.valueOf(beløp));
    }
    
    public FordelingDto(Aktør arbeidsgiver, InntektPeriodeType inntektPeriodeType, BigDecimal beløp) {
        this.arbeidsgiver = arbeidsgiver;
        this.inntektPeriodeType = inntektPeriodeType;
        this.beløp = beløp==null?null:beløp.setScale(2, RoundingMode.HALF_UP);
    }

    public Aktør getArbeidsgiver() {
        return arbeidsgiver;
    }

    public BigDecimal getBeløp() {
        return beløp;
    }

    public InntektPeriodeType getHyppighet() {
        return inntektPeriodeType;
    }

}