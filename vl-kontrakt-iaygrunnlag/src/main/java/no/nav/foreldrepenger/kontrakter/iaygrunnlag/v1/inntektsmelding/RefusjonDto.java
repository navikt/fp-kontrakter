package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.inntektsmelding;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.NON_EMPTY)
public class RefusjonDto {
    
    @JsonProperty("refusjonBeløpPerMnd")
    @DecimalMin(value="0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value="1000000.00", message="beløp må være < 1000000.00")  // TODO: sane verdier
    private BigDecimal refusjonBeløpPerMnd;
    
    @JsonProperty(value = "fom", required = true)
    @Valid
    @NotNull
    private LocalDate fom;

    protected RefusjonDto() {
    }

    public RefusjonDto(LocalDate fom, BigDecimal refusjonBeløpPerMnd) {
        this.fom = fom;
        this.refusjonBeløpPerMnd = refusjonBeløpPerMnd;
    }

    public BigDecimal getRefusjonsbeløpMnd() {
        return refusjonBeløpPerMnd;
    }
    public LocalDate getFom() {
        return fom;
    }
}
