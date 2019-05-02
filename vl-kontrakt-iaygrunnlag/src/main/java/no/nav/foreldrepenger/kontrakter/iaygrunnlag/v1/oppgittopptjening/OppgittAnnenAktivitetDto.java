package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class OppgittAnnenAktivitetDto {
    private PeriodeDto periode;
    private ArbeidTypeDto arbeidTypeDto;

    public OppgittAnnenAktivitetDto() {
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public ArbeidTypeDto getArbeidTypeDto() {
        return arbeidTypeDto;
    }

    public void setArbeidTypeDto(ArbeidTypeDto arbeidTypeDto) {
        this.arbeidTypeDto = arbeidTypeDto;
    }
}
