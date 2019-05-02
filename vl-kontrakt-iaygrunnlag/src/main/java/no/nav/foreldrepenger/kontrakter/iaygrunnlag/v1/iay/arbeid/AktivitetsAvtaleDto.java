package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid;

import java.math.BigDecimal;
import java.time.LocalDate;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class AktivitetsAvtaleDto {

    private PeriodeDto periode;
    private BigDecimal stillingsprosent;
    private BigDecimal antallTimer;
    private LocalDate sistLønnsendring;

    public AktivitetsAvtaleDto() {
    }

    public LocalDate getSistLønnsendring() {
        return sistLønnsendring;
    }

    public void setSistLønnsendring(LocalDate sistLønnsendring) {
        this.sistLønnsendring = sistLønnsendring;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public BigDecimal getStillingsprosent() {
        return stillingsprosent;
    }

    public void setStillingsprosent(BigDecimal stillingsprosent) {
        this.stillingsprosent = stillingsprosent;
    }

    public BigDecimal getAntallTimer() {
        return antallTimer;
    }

    public void setAntallTimer(BigDecimal antallTimer) {
        this.antallTimer = antallTimer;
    }
}
