package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.UuidDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class InntektArbeidYtelseAggregatOverstyrtDto extends InntektArbeidYtelseAggregatDto<InntektArbeidYtelseAggregatOverstyrtDto> {

    protected InntektArbeidYtelseAggregatOverstyrtDto() {
        // default ctor
    }

    public InntektArbeidYtelseAggregatOverstyrtDto(LocalDateTime tidspunkt, UuidDto aggregatReferanse) {
        super(tidspunkt, aggregatReferanse);
    }

    public InntektArbeidYtelseAggregatOverstyrtDto(OffsetDateTime tidspunkt, UUID aggregatReferanse) {
        super(tidspunkt, aggregatReferanse);
    }

    public InntektArbeidYtelseAggregatOverstyrtDto(LocalDateTime tidspunkt, UUID aggregatReferanse) {
        super(tidspunkt, aggregatReferanse);
    }

    public InntektArbeidYtelseAggregatOverstyrtDto(OffsetDateTime tidspunkt, String aggregatReferanse) {
        super(tidspunkt, UUID.fromString(aggregatReferanse));
    }

}
