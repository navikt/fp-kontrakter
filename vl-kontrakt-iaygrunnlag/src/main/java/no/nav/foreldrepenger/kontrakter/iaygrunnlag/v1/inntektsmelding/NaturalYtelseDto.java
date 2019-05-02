package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.inntektsmelding;

import java.math.BigDecimal;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.NaturalYtelseTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class NaturalYtelseDto {
    private PeriodeDto periode;
    private BigDecimal beloepPerMnd;
    private NaturalYtelseTypeDto type;

    public NaturalYtelseDto() {
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public BigDecimal getBeloepPerMnd() {
        return beloepPerMnd;
    }

    public void setBeloepPerMnd(BigDecimal beloepPerMnd) {
        this.beloepPerMnd = beloepPerMnd;
    }

    public NaturalYtelseTypeDto getType() {
        return type;
    }

    public void setType(NaturalYtelseTypeDto type) {
        this.type = type;
    }
}
