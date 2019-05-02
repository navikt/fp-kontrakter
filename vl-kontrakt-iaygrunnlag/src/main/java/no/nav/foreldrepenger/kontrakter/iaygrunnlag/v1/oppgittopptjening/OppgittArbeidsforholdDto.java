package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class OppgittArbeidsforholdDto {
    private PeriodeDto periode;
    private boolean erUtenlandskInntekt;
    private ArbeidTypeDto arbeidTypeDto;
    private OppgittUtenlandskVirksomhetDto utenlandskVirksomhet;

    public OppgittArbeidsforholdDto() {
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public boolean isErUtenlandskInntekt() {
        return erUtenlandskInntekt;
    }

    public void setErUtenlandskInntekt(boolean erUtenlandskInntekt) {
        this.erUtenlandskInntekt = erUtenlandskInntekt;
    }

    public ArbeidTypeDto getArbeidTypeDto() {
        return arbeidTypeDto;
    }

    public void setArbeidTypeDto(ArbeidTypeDto arbeidTypeDto) {
        this.arbeidTypeDto = arbeidTypeDto;
    }

    public OppgittUtenlandskVirksomhetDto getUtenlandskVirksomhet() {
        return utenlandskVirksomhet;
    }

    public void setUtenlandskVirksomhet(OppgittUtenlandskVirksomhetDto utenlandskVirksomhet) {
        this.utenlandskVirksomhet = utenlandskVirksomhet;
    }
}
