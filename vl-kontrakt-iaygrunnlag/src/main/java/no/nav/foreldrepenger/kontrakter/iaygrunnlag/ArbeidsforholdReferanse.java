package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class ArbeidsforholdReferanse {

    @JsonProperty(value = "uuid")
    @NotNull
    @Valid
    private UuidDto uuid; // kobling-referanse
    
    @JsonProperty(value = "arbeidsgiver")
    @NotNull
    @Valid
    private Aktør arbeidsgiver;
    
    @JsonProperty(value = "arbeidsforholdId")
    @Pattern(regexp = "^[\\p{L}\\p{N}:_\\.\\-]+$")
    private String arbeidsforholdId;
    
    protected ArbeidsforholdReferanse() {
        // default ctor
    }

    public ArbeidsforholdReferanse(String referanse, Aktør arbeidsgiver) {
        this.uuid = new UuidDto(referanse);
        this.arbeidsgiver = arbeidsgiver;
    }
    
    public ArbeidsforholdReferanse(String referanse, Aktør arbeidsgiver, String arbeidsforholdId) {
        this.uuid = new UuidDto(referanse);
        this.arbeidsgiver = arbeidsgiver;
        this.arbeidsforholdId = arbeidsforholdId;
    }

    public ArbeidsforholdReferanse(UUID referanse, Aktør arbeidsgiver, String arbeidsforholdId) {
        this.uuid = new UuidDto(referanse);
        this.arbeidsgiver = arbeidsgiver;
        this.arbeidsforholdId = arbeidsforholdId;
    }

    public UuidDto getReferanse() {
        return uuid;
    }

    public Aktør getArbeidsgiver() {
        return arbeidsgiver;
    }

    public String getArbeidsforholdId() {
        return arbeidsforholdId;
    }

}
