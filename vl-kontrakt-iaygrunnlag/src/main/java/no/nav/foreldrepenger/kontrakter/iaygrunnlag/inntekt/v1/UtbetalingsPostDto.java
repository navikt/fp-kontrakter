package no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntekt.v1;

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
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektspostType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.SkatteOgAvgiftsregelType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.UtbetaltYtelseType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class UtbetalingsPostDto {

    @JsonProperty(value = "inntektspostType", required = true)
    @Valid
    @NotNull
    private InntektspostType inntektspostType;

    @JsonProperty(value = "periode", required = true)
    @NotNull
    @Valid
    private Periode periode;
    
    @JsonProperty("skattAvgiftType")
    @Valid
    private SkatteOgAvgiftsregelType skattAvgiftType;

    @JsonProperty("beløp")
    @Valid
    @DecimalMin(value = "0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value = "1000000.00", message = "beløp må være < 1000000.00")
    private BigDecimal beløp;

    /** Satt dersom dette gjelder en ytelse, ellers ikke (henger sammen med {@link UtbetalingDto#getKilde()}) */
    @JsonProperty(value = "ytelseType")
    @Valid
    private UtbetaltYtelseType ytelseType;

    protected UtbetalingsPostDto() {
    }

    public UtbetalingsPostDto(Periode periode, InntektspostType inntektspostType) {
        Objects.requireNonNull(periode, "periode");
        Objects.requireNonNull(inntektspostType, "inntektspostType");
        this.periode = periode;
        this.inntektspostType = inntektspostType;
    }

    public InntektspostType getInntektspostType() {
        return inntektspostType;
    }

    public SkatteOgAvgiftsregelType getSkattAvgiftType() {
        return skattAvgiftType;
    }

    public void setSkattAvgiftType(SkatteOgAvgiftsregelType skattAvgiftType) {
        this.skattAvgiftType = skattAvgiftType;
    }
    
    public void setUtbetaltYtelseType(UtbetaltYtelseType ytelseType) {
        this.ytelseType = ytelseType;
    }

    public UtbetalingsPostDto medUtbetaltYtelseType(UtbetaltYtelseType ytelseType) {
        setUtbetaltYtelseType(ytelseType);
        return this;
    }
    
    public UtbetalingsPostDto medSkattAvgiftType(SkatteOgAvgiftsregelType skattAvgiftType) {
        setSkattAvgiftType(skattAvgiftType);
        return this;
    }

    public UtbetalingsPostDto medSkattAvgiftType(String kode) {
        setSkattAvgiftType(new SkatteOgAvgiftsregelType(kode));
        return this;
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

    public UtbetalingsPostDto medBeløp(BigDecimal beløp) {
        setBeløp(beløp);
        return this;
    }

    public UtbetalingsPostDto medBeløp(int beløp) {
        setBeløp(BigDecimal.valueOf(beløp));
        return this;
    }

    public UtbetaltYtelseType getYtelseType() {
        return ytelseType;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        var other = this.getClass().cast(obj);

        return Objects.equals(inntektspostType, other.inntektspostType)
            && Objects.equals(periode, other.periode)
            && Objects.equals(ytelseType, other.ytelseType)
            ;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(inntektspostType, periode, ytelseType);
    }

}
