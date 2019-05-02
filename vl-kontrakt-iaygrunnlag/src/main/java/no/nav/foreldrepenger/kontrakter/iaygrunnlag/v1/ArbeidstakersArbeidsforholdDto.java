package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import java.util.List;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.arbeidsforhold.ArbeidsforholdDto;

public class ArbeidstakersArbeidsforholdDto {
    private List<ArbeidsforholdDto> arbeidsforhold;

    public ArbeidstakersArbeidsforholdDto() {
    }

    public List<ArbeidsforholdDto> getArbeidsforhold() {
        return arbeidsforhold;
    }

    public void setArbeidsforhold(List<ArbeidsforholdDto> arbeidsforhold) {
        this.arbeidsforhold = arbeidsforhold;
    }
}
