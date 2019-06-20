package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.Fagsystem;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class ArbeidsforholdRefDto {


    @JsonProperty(value = "eksternReferanse", required = true, index = 0)
    @Pattern(regexp = "^[\\p{L}\\p{N}_()\\[\\]\\\\/£$%=#@\\+,\\.\\-:\\s]+$", message = "Eksternreferanse ${validatedValue} matcher ikke tillatt pattern '{regexp}'")
    @NotNull
    private String eksternReferanse;

    @JsonProperty(value = "eksternReferanseSystem", index = 1)
    @NotNull
    @Valid
    private Fagsystem eksternReferanseSystem;
    
    @JsonProperty(value = "abakusReferanse", index = 2)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$", message = "Abakusreferanse ${validatedValue} matcher ikke tillatt pattern '{regexp}'")
    private String abakusReferanse;

    @JsonCreator
    public ArbeidsforholdRefDto(@JsonProperty(value = "abakusReferanse", index = 1) String internReferanse,
                                @JsonProperty(value = "eksternReferanse", required = true, index = 0) String eksternReferanse,
                                @JsonProperty(value = "eksternReferanseSystem", index = 1) Fagsystem eksternReferanseSystem) {
        this.abakusReferanse = internReferanse; // kan sende null, abakus må da generere.
        this.eksternReferanse = Objects.requireNonNull(eksternReferanse, "eksternReferanse");
        this.eksternReferanseSystem = Objects.requireNonNull(eksternReferanseSystem, "eksternReferanseSystem");
    }

    /** Hjelpe ctor -default ekstern system er AAREGISTERET inntil videre. */
    public ArbeidsforholdRefDto(@JsonProperty(value = "abakusReferanse", index = 1) String internReferanse,
                                @JsonProperty(value = "eksternReferanse", required = true, index = 0) String eksternReferanse) {
        this(internReferanse, eksternReferanse, Fagsystem.AAREGISTERET);
    }

    public String getAbakusReferanse() {
        return abakusReferanse;
    }

    public String getEksternReferanse() {
        return eksternReferanse;
    }

    public Fagsystem getEksternReferanseSystem() {
        return eksternReferanseSystem;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "<abakusRef=" + getAbakusReferanse() + ", eksternRef=" + getEksternReferanse() +
            " (" + getEksternReferanseSystem() + ")>";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        var other = getClass().cast(obj);
        return Objects.equals(this.abakusReferanse, other.abakusReferanse)
            && Objects.equals(this.eksternReferanse, other.eksternReferanse)
            && Objects.equals(this.eksternReferanseSystem, other.eksternReferanseSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abakusReferanse, eksternReferanse, eksternReferanseSystem);
    }

}
