package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektspostTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.SkatteOgAvgiftsregelTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.Periode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class UtbetalingsPostDto {

    @JsonProperty(value = "inntektspostType", required = true)
    @Valid
    @NotNull
    private InntektspostTypeDto inntektspostType;

    @JsonProperty("skattAvgiftType")
    @Valid
    private SkatteOgAvgiftsregelTypeDto skattAvgiftType;

    @JsonProperty(value = "periode", required = true)
    @NotNull
    @Valid
    private Periode periode;

    @JsonProperty("beløp")
    @Valid
    @DecimalMin(value = "0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value = "1000000.00", message = "beløp må være < 1000000.00")
    private BigDecimal beløp;

    @JsonProperty(value = "ytelseType", required = true)
    @Valid
    @NotNull
    private YtelseType ytelseType;

    protected UtbetalingsPostDto() {
    }

    public UtbetalingsPostDto(YtelseType ytelseType, Periode periode, InntektspostTypeDto inntektspostType) {
        Objects.requireNonNull(ytelseType, "ytelseType");
        Objects.requireNonNull(periode, "periode");
        Objects.requireNonNull(inntektspostType, "inntektspostType");
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

    public UtbetalingsPostDto medSkattAvgiftType(SkatteOgAvgiftsregelTypeDto skattAvgiftType) {
        setSkattAvgiftType(skattAvgiftType);
        return this;
    }

    public UtbetalingsPostDto medSkattAvgiftType(String kode) {
        setSkattAvgiftType(new SkatteOgAvgiftsregelTypeDto(kode));
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

    public YtelseType getYtelseType() {
        return ytelseType;
    }

}
