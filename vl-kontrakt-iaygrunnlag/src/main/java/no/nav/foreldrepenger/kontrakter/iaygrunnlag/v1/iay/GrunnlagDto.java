package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.ReferanseDto;

public class GrunnlagDto {
    private ReferanseDto referanse;
    private InntektArbeidYtelseAggregatDto register;
    private InntektArbeidYtelseAggregatDto overstyrt;

    public GrunnlagDto() {
    }

    public ReferanseDto getReferanse() {
        return referanse;
    }

    public void setReferanse(ReferanseDto referanse) {
        this.referanse = referanse;
    }

    public InntektArbeidYtelseAggregatDto getRegister() {
        return register;
    }

    public void setRegister(InntektArbeidYtelseAggregatDto register) {
        this.register = register;
    }

    public InntektArbeidYtelseAggregatDto getOverstyrt() {
        return overstyrt;
    }

    public void setOverstyrt(InntektArbeidYtelseAggregatDto overstyrt) {
        this.overstyrt = overstyrt;
    }
}
