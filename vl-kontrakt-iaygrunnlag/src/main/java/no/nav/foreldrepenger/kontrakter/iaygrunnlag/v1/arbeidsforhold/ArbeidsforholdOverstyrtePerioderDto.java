package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.arbeidsforhold;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class ArbeidsforholdOverstyrtePerioderDto {
    private PeriodeDto overstyrtPeriode;

    public ArbeidsforholdOverstyrtePerioderDto() {
    }

    public PeriodeDto getOverstyrtPeriode() {
        return overstyrtPeriode;
    }

    public void setOverstyrtPeriode(PeriodeDto overstyrtPeriode) {
        this.overstyrtPeriode = overstyrtPeriode;
    }
}
