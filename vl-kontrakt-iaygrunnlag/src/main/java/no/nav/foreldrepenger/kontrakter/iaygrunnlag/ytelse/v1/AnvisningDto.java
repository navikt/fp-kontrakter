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

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.ALWAYS)
public class AnvisningDto {

    @JsonProperty(value = "periode", required = true)
    @NotNull
    @Valid
    private Periode periode;

    /** Beløp i hele kroner (currency major unit). Tillater kun positive verdier.  Max verdi håndteres av mottager. */
    @JsonProperty(value = "beløp")
    @Valid
    @DecimalMin(value = "0.00", message = "beløp må være >= 0.00")
    private BigDecimal beløp;

    /** Beløp i hele kroner (currency major unit). Tillater kun positive verdier.  Max verdi håndteres av mottager. */
    @JsonProperty(value = "dagsats")
    @Valid
    @DecimalMin(value = "0.00", message = "beløp må være >= 0.00")
    private BigDecimal dagsats;

    @JsonProperty(value = "utbetalingsgrad")
    @Valid
    @DecimalMin(value = "0.00", message = "prosentsats >= 0.00")
    @DecimalMax(value = "300.00", message = "prosentsats < 300.00")
    private BigDecimal utbetalingsgrad;

    protected AnvisningDto() {
        // default ctor
    }

    public AnvisningDto(Periode periode) {
        this.periode = periode;
    }

    public Periode getPeriode() {
        return periode;
    }

    public BigDecimal getBeløp() {
        return beløp;
    }

    public void setBeløp(BigDecimal beløp) {
        this.beløp = beløp == null ? null : beløp.setScale(2, RoundingMode.HALF_UP);
    }

    public AnvisningDto medBeløp(BigDecimal beløp) {
        setBeløp(beløp);
        return this;
    }

    public AnvisningDto medBeløp(int beløp) {
        setBeløp(BigDecimal.valueOf(beløp));
        return this;
    }

    public BigDecimal getDagsats() {
        return dagsats;
    }

    public void setDagsats(BigDecimal dagsats) {
        this.dagsats =  dagsats == null ? null : dagsats.setScale(2, RoundingMode.HALF_UP);
    }

    public AnvisningDto medDagsats(BigDecimal dagsats) {
        setDagsats(dagsats);
        return this;
    }

    public AnvisningDto medDagsats(int dagsats) {
        return medDagsats(BigDecimal.valueOf(dagsats));
    }

    public BigDecimal getUtbetalingsgrad() {
        return utbetalingsgrad;
    }

    public void setUtbetalingsgrad(BigDecimal utbetalingsgrad) {
        this.utbetalingsgrad = utbetalingsgrad == null ? null : utbetalingsgrad.setScale(2, RoundingMode.HALF_UP);
    }
    
    public AnvisningDto medUtbetalingsgrad(BigDecimal utbetalingsgrad) {
        setUtbetalingsgrad(utbetalingsgrad);
        return this;
    }
    
    public AnvisningDto medUtbetalingsgrad(int utbetalingsgrad) {
        setUtbetalingsgrad(BigDecimal.valueOf(utbetalingsgrad));
        return this;
    }

}
