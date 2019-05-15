package no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeid.v1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class AktivitetsAvtaleDto {

    @JsonProperty("periode")
    @Valid
    @NotNull
    private Periode periode;
    
    @JsonProperty("stillingsprosent")
    @Valid
    @DecimalMin(value="0.00", message = "stillingsprosent må være >= 0.00")
    @DecimalMax(value="500.00", message = "stillingsprosent må være < 500.00") // suspekt å jobbe en måned i løpet av en uke, men så sier Aa-reg.
    private BigDecimal stillingsprosent;
    
    /** Antall timer arbeidet (per uke). */
    @JsonProperty("antallTimer")
    @Valid
    @DecimalMin(value="0.00", message = "antallTimer må være >= 0.00")
    @DecimalMax(value="1900.00", message = "antallTimer må være < 1900") // suspekt å jobbe ett år i løpet av en uke, men så sier Aa-reg
    private BigDecimal antallTimer;
    
    @JsonProperty("sistLønnsendring")
    @Valid
    private LocalDate sistLønnsendring;

    protected AktivitetsAvtaleDto() {
    }
    
    public AktivitetsAvtaleDto(@Valid @NotNull Periode periode) {
        this.periode = periode;
    }
    
    public AktivitetsAvtaleDto(LocalDate fom, LocalDate tom) {
        this(new Periode(fom, tom));
    }

    public LocalDate getSistLønnsendring() {
        return sistLønnsendring;
    }
    
    @AssertTrue(message="Må ha minst en av stillingsprosent eller antallTimer")
    private boolean isOk() {
        return stillingsprosent!=null || antallTimer!=null;
    }
    
    public void setSistLønnsendring(LocalDate sistLønnsendring) {
        this.sistLønnsendring = sistLønnsendring;
    }
    
    public AktivitetsAvtaleDto medSistLønnsendring(LocalDate sistLønnsendring) {
        setSistLønnsendring(sistLønnsendring);
        return this;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public BigDecimal getStillingsprosent() {
        return stillingsprosent;
    }

    public void setStillingsprosent(BigDecimal stillingsprosent) {
        this.stillingsprosent = stillingsprosent==null?null:stillingsprosent.setScale(2, RoundingMode.HALF_UP);
    }
    
    public AktivitetsAvtaleDto medStillingsprosent(BigDecimal stillingsprosent) {
        setStillingsprosent(stillingsprosent);
        return this;
    }

    public AktivitetsAvtaleDto medStillingsprosent(int prosentHeltall) {
        setStillingsprosent(BigDecimal.valueOf(prosentHeltall));
        return this;
    }


    public BigDecimal getAntallTimer() {
        return antallTimer;
    }

    public void setAntallTimer(BigDecimal antallTimer) {
        this.antallTimer = antallTimer==null?null:antallTimer.setScale(2, RoundingMode.HALF_UP);
    }

    public AktivitetsAvtaleDto medAntallTimer(BigDecimal antallTimer) {
        setAntallTimer(antallTimer);
        return this;
    }
    
    public AktivitetsAvtaleDto medAntallTimer(long antallTimer) {
        return medAntallTimer(BigDecimal.valueOf(antallTimer));
    }
    
    
}
