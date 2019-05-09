package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.inntektsmelding;

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

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.NaturalytelseTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.Periode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.ALWAYS)
public class NaturalytelseDto {

    @JsonProperty(value = "periode", required = true, index = 0)
    @Valid
    @NotNull
    private Periode periode;

    @JsonProperty(value = "naturalytelseType", required = true, index = 1)
    @Valid
    @NotNull
    private NaturalytelseTypeDto type;

    @JsonProperty(value = "beløpPerMnd", index = 3)
    @DecimalMin(value = "0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value = "1000000.00", message = "beløp må være < 1000000.00") // TODO: sane verdier
    private BigDecimal beløpPerMnd;

    protected NaturalytelseDto() {
        // default ctor
    }

    public NaturalytelseDto(Periode periode, NaturalytelseTypeDto type, BigDecimal beløpPerMnd) {
        Objects.requireNonNull(periode, "periode");
        Objects.requireNonNull(type, "type");
        this.periode = periode;
        this.type = type;
        this.beløpPerMnd = beløpPerMnd == null ? null : beløpPerMnd.setScale(2, RoundingMode.HALF_UP);
    }

    public Periode getPeriode() {
        return periode;
    }

    public BigDecimal getBeløpPerMnd() {
        return beløpPerMnd;
    }

    public NaturalytelseTypeDto getType() {
        return type;
    }
}
