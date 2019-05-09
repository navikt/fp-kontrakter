package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.PersonIdent;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.UuidDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class GrunnlagDto {

    @JsonProperty(value = "grunnlagReferanse", required = true)
    @Valid
    @NotNull
    private UuidDto grunnlagReferanse;

    @JsonProperty(value = "generertTidspunkt", required = true)
    @Valid
    @NotNull
    private ZonedDateTime generertTidspunkt = ZonedDateTime.now(ZoneId.of("Europe/Oslo"));

    @JsonProperty("person")
    @Valid
    @NotNull
    private PersonIdent person;

    @JsonProperty(value = "registerGrunnlag")
    @Valid
    private InntektArbeidYtelseAggregatDto register;

    @JsonProperty(value = "overstyrtGrunnlag")
    @Valid
    private InntektArbeidYtelseAggregatDto overstyrt;

    protected GrunnlagDto() {
        // default ctor
    }

    public GrunnlagDto(PersonIdent person, UuidDto uuid) {
        Objects.requireNonNull(person, "person");
        Objects.requireNonNull(uuid, "uuid");
        this.person = person;
        this.grunnlagReferanse = uuid;
    }

    public GrunnlagDto(PersonIdent person, UUID uuid) {
        Objects.requireNonNull(person, "person");
        Objects.requireNonNull(uuid, "uuid");
        this.person = person;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || !(obj.getClass().equals(this.getClass()))) {
            return false;
        }
        GrunnlagDto other = (GrunnlagDto) obj;
        return Objects.equals(person, other.person)
            && Objects.equals(register, other.register)
            && Objects.equals(overstyrt, other.overstyrt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, register, overstyrt);
    }
}
