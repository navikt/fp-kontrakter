package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.PersonIdent;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.UuidDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.InntektsmeldingerDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittOpptjeningDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class InntektArbeidYtelseGrunnlagDto {

    @JsonProperty(value = "grunnlagReferanse", required = true)
    @Valid
    @NotNull
    private UuidDto grunnlagReferanse;

    @JsonProperty(value = "generertTidspunkt", required = true)
    @Valid
    @NotNull
    private OffsetDateTime generertTidspunkt = OffsetDateTime.now(ZoneId.of("Europe/Oslo"));

    @JsonProperty("person")
    @Valid
    @NotNull
    private PersonIdent person;

    @JsonProperty(value = "registerGrunnlag")
    @Valid
    private InntektArbeidYtelseAggregatRegisterDto register;

    @JsonProperty(value = "overstyrtGrunnlag")
    @Valid
    private InntektArbeidYtelseAggregatOverstyrtDto overstyrt;

    @JsonProperty(value = "inntektsmeldinger")
    @Valid
    private List<InntektsmeldingerDto> inntektsmeldinger;

    /** Opptjening bruker har oppgitt selv. */
    @JsonProperty(value = "oppgittOpptjening")
    @Valid
    private OppgittOpptjeningDto oppgittOpptjening;

    protected InntektArbeidYtelseGrunnlagDto() {
        // default ctor
    }

    public InntektArbeidYtelseGrunnlagDto(PersonIdent person, UuidDto uuid) {
        Objects.requireNonNull(person, "person");
        Objects.requireNonNull(uuid, "uuid");
        this.person = person;
        this.grunnlagReferanse = uuid;
    }

    public InntektArbeidYtelseGrunnlagDto(PersonIdent person, UUID uuid) {
        Objects.requireNonNull(person, "person");
        Objects.requireNonNull(uuid, "uuid");
        this.person = person;
        this.grunnlagReferanse = new UuidDto(uuid);
    }

    public UuidDto getReferanse() {
        return grunnlagReferanse;
    }

    public InntektArbeidYtelseAggregatRegisterDto getRegister() {
        return register;
    }

    public void setRegister(InntektArbeidYtelseAggregatRegisterDto register) {
        this.register = register;
    }

    public InntektArbeidYtelseAggregatOverstyrtDto getOverstyrt() {
        return overstyrt;
    }

    public void setOverstyrt(InntektArbeidYtelseAggregatOverstyrtDto overstyrt) {
        Objects.requireNonNull(register, "Kan ikke sette overstyrt om register ikke er satt");
        this.overstyrt = overstyrt;
    }

    public InntektArbeidYtelseGrunnlagDto medOverstyrt(InntektArbeidYtelseAggregatOverstyrtDto overstyrt) {
        setOverstyrt(overstyrt);
        return this;
    }

    public InntektArbeidYtelseGrunnlagDto medRegister(InntektArbeidYtelseAggregatRegisterDto register) {
        setRegister(register);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || !(obj.getClass().equals(this.getClass()))) {
            return false;
        }
        InntektArbeidYtelseGrunnlagDto other = (InntektArbeidYtelseGrunnlagDto) obj;
        return Objects.equals(person, other.person)
            && Objects.equals(register, other.register)
            && Objects.equals(overstyrt, other.overstyrt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, register, overstyrt);
    }

    public InntektArbeidYtelseGrunnlagDto medInntektsmeldinger(List<InntektsmeldingerDto> inntektsmeldinger) {
        this.inntektsmeldinger = inntektsmeldinger;
        return this;
    }

    public InntektArbeidYtelseGrunnlagDto medOppgittOpptjening(OppgittOpptjeningDto oppgittOpptjening) {
        setOppgittOpptjening(oppgittOpptjening);
        return this;
    }

    public void setOppgittOpptjening(OppgittOpptjeningDto oppgittOpptjening) {
        this.oppgittOpptjening = oppgittOpptjening;
        
    }
}
