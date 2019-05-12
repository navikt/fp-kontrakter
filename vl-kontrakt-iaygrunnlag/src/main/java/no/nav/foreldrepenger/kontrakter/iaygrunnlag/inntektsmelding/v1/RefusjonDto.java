package no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class RefusjonDto {
    
    @JsonProperty(value = "fom", required = true, index = 0)
    @Valid
    @NotNull
    private LocalDate fom;

    @JsonProperty(value = "refusjonBeløpPerMnd", index = 1)
    @DecimalMin(value = "0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value = "10000000.00", message = "beløp må være < 10000000.00") // TODO: sane verdier
    private BigDecimal refusjonBeløpPerMnd;

    protected RefusjonDto() {
    }

    public RefusjonDto(LocalDate fom, BigDecimal refusjonBeløpPerMnd) {
        Objects.requireNonNull(fom, "fom");
        this.fom = fom;
        this.refusjonBeløpPerMnd = refusjonBeløpPerMnd == null ? null : refusjonBeløpPerMnd.setScale(2, RoundingMode.HALF_UP);
    }

    public RefusjonDto(LocalDate fom, int refusjonBeløpPerMnd) {
        this(fom, BigDecimal.valueOf(refusjonBeløpPerMnd));
    }

    public BigDecimal getRefusjonsbeløpMnd() {
        return refusjonBeløpPerMnd;
    }

    public LocalDate getFom() {
        return fom;
    }
}
