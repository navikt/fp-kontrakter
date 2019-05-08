package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.NON_EMPTY)
public class AktivitetsAvtaleDto {

    @JsonProperty("periode")
    @Valid
    @NotNull
    private PeriodeDto periode;
    
    @JsonProperty("stillingsprosent")
    @Valid
    @DecimalMin(value="0.00", message = "stillingsprosent må være >= 0.00")
    @DecimalMax(value="500.00", message = "stillingsprosent må være < 500.00") // suspekt å jobbe en måned i løpet av en uke, men så sier Aa-reg.
    private BigDecimal stillingsprosent;
    
    @JsonProperty("antallTimer")
    @Valid
    @DecimalMin(value="0.00", message = "antallTimer må være >= 0.00")
    @DecimalMax(value="1900.00", message = "antallTimer må være < 1900") // suspekt å jobbe ett år i løpet av en uke, men så sier Aa-reg
    private BigDecimal antallTimer;
    
    @JsonProperty("sistLønnsendring")
    private LocalDate sistLønnsendring;

    public AktivitetsAvtaleDto() {
    }

    public LocalDate getSistLønnsendring() {
        return sistLønnsendring;
    }

    public void setSistLønnsendring(LocalDate sistLønnsendring) {
        this.sistLønnsendring = sistLønnsendring;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public BigDecimal getStillingsprosent() {
        return stillingsprosent;
    }

    public void setStillingsprosent(BigDecimal stillingsprosent) {
        this.stillingsprosent = stillingsprosent;
    }

    public BigDecimal getAntallTimer() {
        return antallTimer;
    }

    public void setAntallTimer(BigDecimal antallTimer) {
        this.antallTimer = antallTimer;
    }
}
