package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Representerer et arbeidsforhold for en arbeidsgiver i en behandling. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class ArbeidsforholdReferanse {

    @JsonProperty(value = "koblingReferanse", required = true)
    @NotNull
    @Valid
    private UuidDto koblingReferanse; // kobling-referanse
    
    @JsonProperty(value = "arbeidsgiver", required = true)
    @NotNull
    @Valid
    private Aktør arbeidsgiver;
    
    @JsonProperty(value = "arbeidsforholdId", required = true)
    @Valid
    @NotNull
    private ArbeidsforholdRefDto arbeidsforholdId;
    
    protected ArbeidsforholdReferanse() {
        // default ctor
    }

    public ArbeidsforholdReferanse(String koblingReferanse, Aktør arbeidsgiver) {
        this.koblingReferanse = new UuidDto(koblingReferanse);
        this.arbeidsgiver = arbeidsgiver;
    }
    
    public ArbeidsforholdReferanse(String koblingReferanse, Aktør arbeidsgiver, ArbeidsforholdRefDto arbeidsforholdId) {
        this.koblingReferanse = new UuidDto(koblingReferanse);
        this.arbeidsgiver = arbeidsgiver;
        this.arbeidsforholdId = arbeidsforholdId;
    }

    public ArbeidsforholdReferanse(UUID koblingReferanse, Aktør arbeidsgiver, ArbeidsforholdRefDto arbeidsforholdId) {
        this.koblingReferanse = new UuidDto(koblingReferanse);
        this.arbeidsgiver = arbeidsgiver;
        this.arbeidsforholdId = arbeidsforholdId;
    }

    public UuidDto getKoblingReferanse() {
        return koblingReferanse;
    }

    public Aktør getArbeidsgiver() {
        return arbeidsgiver;
    }

    public ArbeidsforholdRefDto getArbeidsforholdId() {
        return arbeidsforholdId;
    }

}
