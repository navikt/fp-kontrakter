package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeid.v1.ArbeidDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public abstract class InntektArbeidYtelseAggregatDto<S extends InntektArbeidYtelseAggregatDto<S>> {

    @JsonProperty(value = "grunnlagTidspunkt", required = true)
    @Valid
    @NotNull
    private OffsetDateTime tidspunkt;

    @JsonProperty(value = "arbeid")
    @Valid
    private List<ArbeidDto> arbeid;

    protected InntektArbeidYtelseAggregatDto() {
        // default ctor
    }

    public InntektArbeidYtelseAggregatDto(LocalDateTime tidspunkt) {
        this(tidspunkt.atZone(ZoneId.of("Europe/Oslo")).toOffsetDateTime());
    }

    public InntektArbeidYtelseAggregatDto(OffsetDateTime tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public List<ArbeidDto> getArbeid() {
        return arbeid;
    }

    public void setArbeid(List<ArbeidDto> arbeid) {
        this.arbeid = arbeid;
    }

    @SuppressWarnings("unchecked")
    public S medArbeid(List<ArbeidDto> arbeid) {
        this.arbeid = arbeid;
        return (S) this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || !(obj.getClass().equals(this.getClass()))) {
            return false;
        }
        @SuppressWarnings("rawtypes")
        InntektArbeidYtelseAggregatDto other = (InntektArbeidYtelseAggregatDto) obj;
        return Objects.equals(arbeid, other.arbeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arbeid);
    }
}
