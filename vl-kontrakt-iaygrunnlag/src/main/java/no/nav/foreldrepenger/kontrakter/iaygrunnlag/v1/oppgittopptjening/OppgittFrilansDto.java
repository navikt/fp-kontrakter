package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import java.util.List;

public class OppgittFrilansDto {
    private boolean harInntektFraFosterhjem;
    private boolean erNyoppstartet;
    private boolean harNærRelasjon;
    private List<OppgittFrilansoppdragDto> frilansoppdrag;

    public OppgittFrilansDto() {
    }

    public boolean isHarInntektFraFosterhjem() {
        return harInntektFraFosterhjem;
    }

    public void setHarInntektFraFosterhjem(boolean harInntektFraFosterhjem) {
        this.harInntektFraFosterhjem = harInntektFraFosterhjem;
    }

    public boolean isErNyoppstartet() {
        return erNyoppstartet;
    }

    public void setErNyoppstartet(boolean erNyoppstartet) {
        this.erNyoppstartet = erNyoppstartet;
    }

    public boolean isHarNærRelasjon() {
        return harNærRelasjon;
    }

    public void setHarNærRelasjon(boolean harNærRelasjon) {
        this.harNærRelasjon = harNærRelasjon;
    }

    public List<OppgittFrilansoppdragDto> getFrilansoppdrag() {
        return frilansoppdrag;
    }

    public void setFrilansoppdrag(List<OppgittFrilansoppdragDto> frilansoppdrag) {
        this.frilansoppdrag = frilansoppdrag;
    }
}
