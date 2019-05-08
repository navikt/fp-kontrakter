package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class OppgittOpptjeningDto {

    @JsonProperty(value = "oppgittArbeidsforhold")
    @Valid
    private List<OppgittArbeidsforholdDto> oppgittArbeidsforhold;

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

    public List<OppgittArbeidsforholdDto> getOppgittArbeidsforhold() {
        return oppgittArbeidsforhold;
    }

    public void setOppgittArbeidsforhold(List<OppgittArbeidsforholdDto> oppgittArbeidsforhold) {
        this.oppgittArbeidsforhold = oppgittArbeidsforhold;
    }

    public List<OppgittEgenNæringDto> getEgenNæring() {
        return egenNæring;
    }

    public void setEgenNæring(List<OppgittEgenNæringDto> egenNæring) {
        this.egenNæring = egenNæring;
    }

    public List<OppgittAnnenAktivitetDto> getAnnenAktivitet() {
        return annenAktivitet;
    }

    public void setAnnenAktivitet(List<OppgittAnnenAktivitetDto> annenAktivitet) {
        this.annenAktivitet = annenAktivitet;
    }

    public OppgittFrilansDto getFrilans() {
        return frilans;
    }

    public void setFrilans(OppgittFrilansDto frilans) {
        this.frilans = frilans;
    }
}
