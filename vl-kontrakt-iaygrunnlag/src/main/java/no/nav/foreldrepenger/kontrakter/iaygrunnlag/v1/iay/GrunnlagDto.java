package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.UuidDto;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class GrunnlagDto {
    
    @JsonProperty(value="referanse", required = true)
    @Valid
    private UuidDto referanse;
    
    @JsonProperty(value="register")
    @Valid
    private InntektArbeidYtelseAggregatDto register;
    
    @JsonProperty(value="overstyrt")
    @Valid
    private InntektArbeidYtelseAggregatDto overstyrt;

    protected GrunnlagDto() {
        // default ctor
    }

    public UuidDto getReferanse() {
        return referanse;
    }

    public void setReferanse(UuidDto referanse) {
        this.referanse = referanse;
    }

    public InntektArbeidYtelseAggregatDto getRegister() {
        return register;
    }

    public void setRegister(InntektArbeidYtelseAggregatDto register) {
        this.register = register;
    }

    public InntektArbeidYtelseAggregatDto getOverstyrt() {
        return overstyrt;
    }

    public void setOverstyrt(InntektArbeidYtelseAggregatDto overstyrt) {
        this.overstyrt = overstyrt;
    }
}
