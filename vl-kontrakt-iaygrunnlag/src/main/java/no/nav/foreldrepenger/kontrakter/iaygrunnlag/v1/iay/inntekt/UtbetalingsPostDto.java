package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt;

import java.math.BigDecimal;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektspostTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.SkatteOgAvgiftsregelTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class UtbetalingsPostDto {

    private InntektspostTypeDto inntektspostType;
    private SkatteOgAvgiftsregelTypeDto skattAvgiftType;
    private PeriodeDto periode;
    private BigDecimal beløp;
    private YtelseTypeDto ytelseType;

    public UtbetalingsPostDto() {
    }

    public InntektspostTypeDto getInntektspostType() {
        return inntektspostType;
    }

    public void setInntektspostType(InntektspostTypeDto inntektspostType) {
        this.inntektspostType = inntektspostType;
    }

    public SkatteOgAvgiftsregelTypeDto getSkattAvgiftType() {
        return skattAvgiftType;
    }

    public void setSkattAvgiftType(SkatteOgAvgiftsregelTypeDto skattAvgiftType) {
        this.skattAvgiftType = skattAvgiftType;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public BigDecimal getBeløp() {
        return beløp;
    }

    public void setBeløp(BigDecimal beløp) {
        this.beløp = beløp;
    }

    public void setYtelseType(YtelseTypeDto ytelseType) {
        this.ytelseType = ytelseType;
    }

    public YtelseTypeDto getYtelseType() {
        return ytelseType;
    }
}
