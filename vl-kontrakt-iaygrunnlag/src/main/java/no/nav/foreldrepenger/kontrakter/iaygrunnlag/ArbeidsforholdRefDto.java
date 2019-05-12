package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.Fagsystem;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArbeidsforholdRefDto {

    @JsonProperty(value = "abakusReferanse", required = true, index = 0)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String abakusReferanse;

    @JsonProperty(value = "eksternReferanse", index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String eksternReferanse;

    @JsonProperty(value = "eksternReferanseSystem", index = 2)
    @NotNull
    @Valid
    private Fagsystem eksternReferanseSystem;

    @JsonCreator
    public ArbeidsforholdRefDto(@JsonProperty(value = "abakusReferanse", required = true, index = 0) String internReferanse,
                                @JsonProperty(value = "eksternReferanse", index = 1) String eksternReferanse,
                                @JsonProperty(value = "eksternReferanseSystem", index = 1) Fagsystem eksternReferanseSystem) {
        this.abakusReferanse = internReferanse;
        this.eksternReferanse = eksternReferanse;
        this.eksternReferanseSystem = eksternReferanseSystem;
    }

    /** Hjelpe ctor -default ekstern system er AAREGISTERET inntil videre. */
    public ArbeidsforholdRefDto(@JsonProperty(value = "abakusReferanse", required = true, index = 0) String internReferanse,
                                @JsonProperty(value = "eksternReferanse", index = 1) String eksternReferanse) {
        this.abakusReferanse = internReferanse;
        this.eksternReferanse = eksternReferanse;
        this.eksternReferanseSystem = Fagsystem.AAREGISTERET;
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

}
