package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse;

import java.math.BigDecimal;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektPeriodeTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;

public class FordelingDto {

    private ArbeidsgiverDto arbeidsgiver;
    private BigDecimal beløp;
    private InntektPeriodeTypeDto hyppighet;

    public FordelingDto() {
    }

    public ArbeidsgiverDto getArbeidsgiver() {
        return arbeidsgiver;
    }

    public void setArbeidsgiver(ArbeidsgiverDto arbeidsgiver) {
        this.arbeidsgiver = arbeidsgiver;
    }

    public BigDecimal getBeløp() {
        return beløp;
    }

    public void setBeløp(BigDecimal beløp) {
        this.beløp = beløp;
    }

    public InntektPeriodeTypeDto getHyppighet() {
        return hyppighet;
    }

    public void setHyppighet(InntektPeriodeTypeDto hyppighet) {
        this.hyppighet = hyppighet;
    }
}
