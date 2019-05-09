package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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

    @JsonProperty(value = "grunnlagTidspunkt", required = true)
    @Valid
    @NotNull
    private ZonedDateTime tidspunkt;

    @JsonProperty(value = "arbeid")
    @Valid
    private List<ArbeidDto> arbeid;

    @JsonProperty(value = "inntekter")
    @Valid
    private List<InntekterDto> inntekt;

    @JsonProperty(value = "ytelser")
    @Valid
    private List<YtelserDto> ytelser;

    protected InntektArbeidYtelseAggregatDto() {
        // default ctor
    }

    public InntektArbeidYtelseAggregatDto(LocalDateTime tidspunkt) {
        this(tidspunkt.atZone(ZoneId.of("Europe/Oslo")));
    }

    public InntektArbeidYtelseAggregatDto(ZonedDateTime tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public List<ArbeidDto> getArbeid() {
        return arbeid;
    }

    public void setArbeid(List<ArbeidDto> arbeid) {
        this.arbeid = arbeid;
    }

    public InntektArbeidYtelseAggregatDto medArbeid(List<ArbeidDto> arbeid) {
        this.arbeid = arbeid;
        return this;
    }

    public List<InntekterDto> getInntekt() {
        return inntekt;
    }

    public InntektArbeidYtelseAggregatDto medInntekt(List<InntekterDto> inntekt) {
        this.inntekt = inntekt;
        return this;
    }

    public void setInntekt(List<InntekterDto> inntekt) {
        this.inntekt = inntekt;
    }

    public List<YtelserDto> getYtelse() {
        return ytelser;
    }

    public void setYtelse(List<YtelserDto> ytelse) {
        this.ytelser = ytelse;
    }

    public InntektArbeidYtelseAggregatDto medYtelse(List<YtelserDto> ytelse) {
        this.ytelser = ytelse;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || !(obj.getClass().equals(this.getClass()))) {
            return false;
        }
        InntektArbeidYtelseAggregatDto other = (InntektArbeidYtelseAggregatDto) obj;
        return Objects.equals(arbeid, other.arbeid)
            && Objects.equals(inntekt, other.inntekt)
            && Objects.equals(ytelser, other.ytelser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arbeid, inntekt, ytelser);
    }
}
