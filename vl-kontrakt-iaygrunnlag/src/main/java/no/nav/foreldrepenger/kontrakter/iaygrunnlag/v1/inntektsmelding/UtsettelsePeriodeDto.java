package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.inntektsmelding;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.UtsettelseÅrsakDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class UtsettelsePeriodeDto {
    private PeriodeDto periode;
    private UtsettelseÅrsakDto utsettelseÅrsakDto;

    public UtsettelsePeriodeDto() {
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public UtsettelseÅrsakDto getUtsettelseÅrsakDto() {
        return utsettelseÅrsakDto;
    }

    public void setUtsettelseÅrsakDto(UtsettelseÅrsakDto utsettelseÅrsakDto) {
        this.utsettelseÅrsakDto = utsettelseÅrsakDto;
    }
}
