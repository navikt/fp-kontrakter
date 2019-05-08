package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid.ArbeidDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt.InntekterDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse.YtelserDto;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class InntektArbeidYtelseAggregatDto {

    @JsonProperty(value="arbeid")
    @Valid
    private List<ArbeidDto> arbeid;
    
    @JsonProperty(value="inntekter")
    @Valid
    private List<InntekterDto> inntekt;
    
    @JsonProperty(value="ytelser")
    @Valid
    private List<YtelserDto> ytelse;

    public InntektArbeidYtelseAggregatDto() {
    }

    public List<ArbeidDto> getArbeid() {
        return arbeid;
    }

    public void setArbeid(List<ArbeidDto> arbeid) {
        this.arbeid = arbeid;
    }

    public List<InntekterDto> getInntekt() {
        return inntekt;
    }

    public void setInntekt(List<InntekterDto> inntekt) {
        this.inntekt = inntekt;
    }

    public List<YtelserDto> getYtelse() {
        return ytelse;
    }

    public void setYtelse(List<YtelserDto> ytelse) {
        this.ytelse = ytelse;
    }
}
