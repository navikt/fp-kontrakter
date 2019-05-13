package no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Aktør;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.ArbeidsforholdRefDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class InntektsmeldingSomIkkeKommerDto {

    @JsonProperty(value = "arbeidsgiver", required = true)
    @Valid
    @NotNull
    private Aktør arbeidsgiver;

    @JsonProperty("arbeidsforholdId")
    @Valid
    private ArbeidsforholdRefDto arbeidsforholdId;

    protected InntektsmeldingSomIkkeKommerDto() {
    }

    public InntektsmeldingSomIkkeKommerDto(@Valid @NotNull Aktør arbeidsgiver) {
        this(arbeidsgiver, null);
    }

    @JsonCreator
    public InntektsmeldingSomIkkeKommerDto(@JsonProperty(value = "arbeidsgiver", required = true) @Valid @NotNull Aktør arbeidsgiver,
                                           @JsonProperty(value = "arbeidsforholdId") @Valid ArbeidsforholdRefDto arbeidsforholdId) {
        this.arbeidsgiver = arbeidsgiver;
        this.arbeidsforholdId = arbeidsforholdId;
    }

    public Aktør getArbeidsgiver() {
        return arbeidsgiver;
    }

    public ArbeidsforholdRefDto getArbeidsforholdId() {
        return arbeidsforholdId;
    }

}
