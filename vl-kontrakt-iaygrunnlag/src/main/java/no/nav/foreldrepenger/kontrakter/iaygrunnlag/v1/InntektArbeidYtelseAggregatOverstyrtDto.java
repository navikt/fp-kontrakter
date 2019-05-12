package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class InntektArbeidYtelseAggregatOverstyrtDto extends InntektArbeidYtelseAggregatDto<InntektArbeidYtelseAggregatOverstyrtDto> {

    protected InntektArbeidYtelseAggregatOverstyrtDto() {
        // default ctor
    }

    public InntektArbeidYtelseAggregatOverstyrtDto(LocalDateTime tidspunkt) {
        super(tidspunkt);
    }

    public InntektArbeidYtelseAggregatOverstyrtDto(OffsetDateTime tidspunkt) {
        super(tidspunkt);
    }

}
