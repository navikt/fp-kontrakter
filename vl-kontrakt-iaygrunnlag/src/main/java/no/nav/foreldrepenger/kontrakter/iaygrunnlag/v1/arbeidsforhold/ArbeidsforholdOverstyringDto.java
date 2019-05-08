package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.arbeidsforhold;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidsforholdHandlingTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class ArbeidsforholdOverstyringDto {
    
    @JsonProperty(value = "arbeidsgiver", required = true)
    @Valid
    @NotNull
    private ArbeidsgiverDto arbeidsgiver;
    
    @JsonProperty(value = "arbeidsforholdReferanse")
    @Valid
    @NotNull
    private ArbeidsforholdRefDto arbeidsforholdRef;
    
    @JsonProperty(value = "nyArbeidsforholdReferanse")
    @Valid
    private ArbeidsforholdRefDto nyArbeidsforholdRef;
    
    @JsonProperty(value = "arbeidsforholdHandlingType")
    @Valid
    private ArbeidsforholdHandlingTypeDto handling;
    
    @JsonProperty(value = "overstyringBegrunnelse")
    @Pattern(regexp = "^[\\p{L}\\p{N}_.- \\n\\t\\r]+$")
    private String begrunnelse;
    
    @JsonProperty(value = "navn")
    @Pattern(regexp = "^[\\p{L}\\p{N}_.- ]+$")
    @NotNull
    private String navn;
    
    @JsonProperty(value = "stillingsprosent")
    @DecimalMin(value="0.00", message = "må være >= 0.00")
    @DecimalMax(value="500.00", message="må være < 500.00") // TODO: mer sane verdier
    private BigDecimal stillingsprosent;
    
    @JsonProperty(value = "overstyrtePerioder")
    @Valid
    private List<PeriodeDto> arbeidsforholdOverstyrtePerioder;

    protected ArbeidsforholdOverstyringDto() {
        // default ctor
    }

    public ArbeidsforholdOverstyringDto(ArbeidsgiverDto arbeidsgiver, ArbeidsforholdRefDto arbeidsforholdRef) {
        super();
        this.arbeidsgiver = arbeidsgiver;
        this.arbeidsforholdRef = arbeidsforholdRef;
    }

    public ArbeidsgiverDto getArbeidsgiver() {
        return arbeidsgiver;
    }

    public void setArbeidsgiver(ArbeidsgiverDto arbeidsgiver) {
        this.arbeidsgiver = arbeidsgiver;
    }

    public ArbeidsforholdRefDto getArbeidsforholdRef() {
        return arbeidsforholdRef;
    }

    public void setArbeidsforholdRef(ArbeidsforholdRefDto arbeidsforholdRef) {
        this.arbeidsforholdRef = arbeidsforholdRef;
    }

    public ArbeidsforholdRefDto getNyArbeidsforholdRef() {
        return nyArbeidsforholdRef;
    }

    public void setNyArbeidsforholdRef(ArbeidsforholdRefDto nyArbeidsforholdRef) {
        this.nyArbeidsforholdRef = nyArbeidsforholdRef;
    }

    public ArbeidsforholdHandlingTypeDto getHandling() {
        return handling;
    }

    public void setHandling(ArbeidsforholdHandlingTypeDto handling) {
        this.handling = handling;
    }

    public String getBegrunnelse() {
        return begrunnelse;
    }

    public void setBegrunnelse(String begrunnelse) {
        this.begrunnelse = begrunnelse;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public BigDecimal getStillingsprosent() {
        return stillingsprosent;
    }

    public void setStillingsprosent(BigDecimal stillingsprosent) {
        this.stillingsprosent = stillingsprosent;
    }

    public List<PeriodeDto> getArbeidsforholdOverstyrtePerioder() {
        return arbeidsforholdOverstyrtePerioder;
    }

    public void setArbeidsforholdOverstyrtePerioder(List<PeriodeDto> arbeidsforholdOverstyrtePerioder) {
        this.arbeidsforholdOverstyrtePerioder = arbeidsforholdOverstyrtePerioder;
    }
}
