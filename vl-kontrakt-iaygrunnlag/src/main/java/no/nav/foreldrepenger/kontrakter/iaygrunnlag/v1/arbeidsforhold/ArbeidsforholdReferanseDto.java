package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.arbeidsforhold;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class ArbeidsforholdReferanseDto {

    @JsonProperty(value = "arbeidsgiver", required = true)
    @Valid
    @NotNull
    private ArbeidsgiverDto arbeidsgiver;

    @JsonProperty("arbeidsforholdId")
    @Valid
    @NotNull
    private ArbeidsforholdRefDto arbeidsforholdId;

    protected ArbeidsforholdReferanseDto() {
    }

    public ArbeidsforholdReferanseDto(ArbeidsgiverDto arbeidsgiver, ArbeidsforholdRefDto arbeidsforholdId) {
        super();
        this.arbeidsgiver = arbeidsgiver;
        this.arbeidsforholdId = arbeidsforholdId;
    }

    public ArbeidsgiverDto getArbeidsgiver() {
        return arbeidsgiver;
    }

    public ArbeidsforholdRefDto getArbeidsforholdReferanse() {
        return arbeidsforholdId;
    }

}
