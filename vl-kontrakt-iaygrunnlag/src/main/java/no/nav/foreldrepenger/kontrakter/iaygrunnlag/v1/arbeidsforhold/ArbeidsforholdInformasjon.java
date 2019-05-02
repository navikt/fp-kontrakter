package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.arbeidsforhold;

import java.util.List;

public class ArbeidsforholdInformasjon {
    private List<ArbeidsforholdReferanseDto> referanser;
    private List<ArbeidsforholdOverstyringDto> overstyringer;

    public ArbeidsforholdInformasjon() {
    }

    public List<ArbeidsforholdReferanseDto> getReferanser() {
        return referanser;
    }

    public void setReferanser(List<ArbeidsforholdReferanseDto> referanser) {
        this.referanser = referanser;
    }

    public List<ArbeidsforholdOverstyringDto> getOverstyringer() {
        return overstyringer;
    }

    public void setOverstyringer(List<ArbeidsforholdOverstyringDto> overstyringer) {
        this.overstyringer = overstyringer;
    }
}
