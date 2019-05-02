package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.arbeidsforhold;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;

public class ArbeidsforholdReferanseDto {

    private ArbeidsgiverDto arbeidsgiver;
    private ArbeidsforholdRefDto arbeidsforholdReferanse;

    public ArbeidsforholdReferanseDto() {
    }

    public ArbeidsgiverDto getArbeidsgiver() {
        return arbeidsgiver;
    }

    public void setArbeidsgiver(ArbeidsgiverDto arbeidsgiver) {
        this.arbeidsgiver = arbeidsgiver;
    }

    public ArbeidsforholdRefDto getArbeidsforholdReferanse() {
        return arbeidsforholdReferanse;
    }

    public void setArbeidsforholdReferanse(ArbeidsforholdRefDto arbeidsforholdReferanse) {
        this.arbeidsforholdReferanse = arbeidsforholdReferanse;
    }
}
