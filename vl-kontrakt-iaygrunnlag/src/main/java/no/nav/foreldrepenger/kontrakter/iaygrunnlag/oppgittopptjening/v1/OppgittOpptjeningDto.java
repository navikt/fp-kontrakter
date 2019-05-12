package no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class OppgittOpptjeningDto {

    @JsonProperty(value = "arbeidsforhold")
    @Valid
    private List<OppgittArbeidsforholdDto> arbeidsforhold;

    @JsonProperty(value = "egenNæring")
    @Valid
    private List<OppgittEgenNæringDto> egenNæring;

    @JsonProperty(value = "annenAktivitet")
    @Valid
    private List<OppgittAnnenAktivitetDto> annenAktivitet;

    @JsonProperty(value = "frilans")
    @Valid
    private OppgittFrilansDto frilans;

    public OppgittOpptjeningDto() {
    }

    @AssertTrue(message = "Må oppgi minst en av arbeidsforhold, egenNæring, annenAktivitet eller frilans")
    private boolean isOk() {
        return arbeidsforhold != null && !arbeidsforhold.isEmpty()
            || egenNæring != null && !egenNæring.isEmpty()
            || annenAktivitet != null && !annenAktivitet.isEmpty()
            || frilans != null;
    }

    public List<OppgittArbeidsforholdDto> getArbeidsforhold() {
        return arbeidsforhold;
    }

    public void setArbeidsforhold(List<OppgittArbeidsforholdDto> oppgittArbeidsforhold) {
        this.arbeidsforhold = oppgittArbeidsforhold;
    }

    public OppgittOpptjeningDto medArbeidsforhold(List<OppgittArbeidsforholdDto> oppgittArbeidsforhold) {
        setArbeidsforhold(oppgittArbeidsforhold);
        return this;
    }

    public List<OppgittEgenNæringDto> getEgenNæring() {
        return egenNæring;
    }

    public void setEgenNæring(List<OppgittEgenNæringDto> egenNæring) {
        this.egenNæring = egenNæring;
    }

    public OppgittOpptjeningDto medEgenNæring(List<OppgittEgenNæringDto> egenNæring) {
        setEgenNæring(egenNæring);
        return this;
    }

    public List<OppgittAnnenAktivitetDto> getAnnenAktivitet() {
        return annenAktivitet;
    }

    public void setAnnenAktivitet(List<OppgittAnnenAktivitetDto> annenAktivitet) {
        this.annenAktivitet = annenAktivitet;
    }

    public OppgittOpptjeningDto medAnnenAktivitet(List<OppgittAnnenAktivitetDto> annenAktivitet) {
        setAnnenAktivitet(annenAktivitet);
        return this;
    }

    public OppgittFrilansDto getFrilans() {
        return frilans;
    }

    public void setFrilans(OppgittFrilansDto frilans) {
        this.frilans = frilans;
    }

    public OppgittOpptjeningDto medFrilans(OppgittFrilansDto frilans) {
        setFrilans(frilans);
        return this;
    }
}
