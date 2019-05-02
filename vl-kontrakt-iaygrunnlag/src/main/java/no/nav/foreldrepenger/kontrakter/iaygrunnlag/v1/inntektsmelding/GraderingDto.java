package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.inntektsmelding;

import java.math.BigDecimal;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class GraderingDto {
    private PeriodeDto periode;
    private BigDecimal arbeidstidProsent;

    public GraderingDto() {
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public BigDecimal getArbeidstidProsent() {
        return arbeidstidProsent;
    }

    public void setArbeidstidProsent(BigDecimal arbeidstidProsent) {
        this.arbeidstidProsent = arbeidstidProsent;
    }
}
