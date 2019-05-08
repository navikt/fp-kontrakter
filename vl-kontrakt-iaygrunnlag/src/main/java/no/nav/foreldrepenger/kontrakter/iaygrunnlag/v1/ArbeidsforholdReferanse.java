package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class ArbeidsforholdReferanse {

    @JsonProperty(value = "uuid")
    @NotNull
    @Valid
    private UuidDto uuid; // kobling-referanse
    
    @JsonProperty(value = "arbeidsgiver")
    @NotNull
    @Valid
    private ArbeidsgiverDto arbeidsgiver;
    
    @JsonProperty(value = "arbeidsforholdId")
    @Pattern(regexp = ".*")
    private String arbeidsforholdId;

    public ArbeidsforholdReferanse(String referanse, ArbeidsgiverDto arbeidsgiver, String arbeidsforholdId) {
        this.uuid = new UuidDto(referanse);
        this.arbeidsgiver = arbeidsgiver;
        this.arbeidsforholdId = arbeidsforholdId;
    }

    public UuidDto getReferanse() {
        return uuid;
    }

    public void setReferanse(UuidDto referanse) {
        this.uuid = referanse;
    }

    public ArbeidsgiverDto getArbeidsgiver() {
        return arbeidsgiver;
    }

    public void setArbeidsgiver(ArbeidsgiverDto arbeidsgiver) {
        this.arbeidsgiver = arbeidsgiver;
    }

    public String getArbeidsforholdId() {
        return arbeidsforholdId;
    }

    public void setArbeidsforholdId(String arbeidsforholdId) {
        this.arbeidsforholdId = arbeidsforholdId;
    }
}
