package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class OppgittFrilansoppdragDto {
    private String oppdragsgiver;
    private PeriodeDto periode;

    public OppgittFrilansoppdragDto() {
    }

    public String getOppdragsgiver() {
        return oppdragsgiver;
    }

    public void setOppdragsgiver(String oppdragsgiver) {
        this.oppdragsgiver = oppdragsgiver;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }
}
