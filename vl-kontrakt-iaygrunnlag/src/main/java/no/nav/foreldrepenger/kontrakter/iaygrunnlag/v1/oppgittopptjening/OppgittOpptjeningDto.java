package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import java.util.List;

public class OppgittOpptjeningDto {
    private List<OppgittArbeidsforholdDto> oppgittArbeidsforhold;
    private List<OppgittEgenNæringDto> egenNæring;
    private List<OppgittAnnenAktivitetDto> annenAktivitet;
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
