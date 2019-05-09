package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.UuidDto;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class GrunnlagDto {
    
    @JsonProperty(value="grunnlagReferanse", required = true)
    @Valid
    private UuidDto grunnlagReferanse;
    
    @JsonProperty(value="registerGrunnlag")
    @Valid
    private InntektArbeidYtelseAggregatDto register;
    
    @JsonProperty(value="overstyrtGrunnlag")
    @Valid
    private InntektArbeidYtelseAggregatDto overstyrt;

    protected GrunnlagDto() {
        // default ctor
    }
    
    public GrunnlagDto(UuidDto uuid) {
        grunnlagReferanse = uuid;
    }
    
    public GrunnlagDto(UUID uuid) {
        Objects.requireNonNull(uuid, "uuid");
        this.grunnlagReferanse = new UuidDto(uuid);
    }

    public UuidDto getReferanse() {
        return grunnlagReferanse;
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
        Objects.requireNonNull(register, "Kan ikke sette overstyrt om register ikke er satt");
        this.overstyrt = overstyrt;
    }
    
    public GrunnlagDto medOverstyrt(InntektArbeidYtelseAggregatDto overstyrt) {
        setOverstyrt(overstyrt);
        return this;
    }
 
    public GrunnlagDto medRegister(InntektArbeidYtelseAggregatDto register) {
        setRegister(register);
        return this;
    }

}
