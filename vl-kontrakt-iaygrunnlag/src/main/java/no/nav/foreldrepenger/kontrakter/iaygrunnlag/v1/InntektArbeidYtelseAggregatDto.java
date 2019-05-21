package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.UuidDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeid.v1.ArbeidDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public abstract class InntektArbeidYtelseAggregatDto<S extends InntektArbeidYtelseAggregatDto<S>> {

    @JsonProperty(value = "opprettetTidspunkt", required = true)
    @Valid
    @NotNull
    private OffsetDateTime opprettetTidspunkt;

    /** Unik referanse for dette aggregatet. Kan benyttes f.eks. til å de-duplisere overførte data. */
    @JsonProperty(value = "aggregatReferanse", required = true)
    @Valid
    private UuidDto aggregatReferanse;

    @JsonProperty(value = "arbeid")
    @Valid
    private List<ArbeidDto> arbeid;

    protected InntektArbeidYtelseAggregatDto() {
        // default ctor
    }

    public InntektArbeidYtelseAggregatDto(LocalDateTime tidspunkt, UuidDto aggregatReferanse) {
        this(tidspunkt.atZone(ZoneId.of("Europe/Oslo")).toOffsetDateTime(), aggregatReferanse);
    }

    public InntektArbeidYtelseAggregatDto(OffsetDateTime tidspunkt, UuidDto aggregatReferanse) {
        this.opprettetTidspunkt = tidspunkt;
        this.aggregatReferanse = aggregatReferanse;
    }

    public InntektArbeidYtelseAggregatDto(OffsetDateTime tidspunkt, UUID aggregatReferanse) {
        this(tidspunkt, new UuidDto(aggregatReferanse));
    }

    public InntektArbeidYtelseAggregatDto(LocalDateTime tidspunkt, UUID aggregatReferanse) {
        this(tidspunkt.atZone(ZoneId.of("Europe/Oslo")).toOffsetDateTime(), aggregatReferanse);
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
