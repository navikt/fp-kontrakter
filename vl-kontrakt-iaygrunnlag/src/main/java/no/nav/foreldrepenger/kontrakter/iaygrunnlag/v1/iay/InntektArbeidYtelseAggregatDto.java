package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import java.util.List;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.ReferanseDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid.ArbeidDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt.InntekterDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse.YtelserDto;

public class InntektArbeidYtelseAggregatDto {

    private List<ArbeidDto> arbeid;
    private List<InntekterDto> inntekt;
    private List<YtelserDto> ytelse;

    public InntektArbeidYtelseAggregatDto() {
    }

    public List<ArbeidDto> getArbeid() {
        return arbeid;
    }

    public void setArbeid(List<ArbeidDto> arbeid) {
        this.arbeid = arbeid;
    }

    public List<InntekterDto> getInntekt() {
        return inntekt;
    }

    public void setInntekt(List<InntekterDto> inntekt) {
        this.inntekt = inntekt;
    }

    public List<YtelserDto> getYtelse() {
        return ytelse;
    }

    public void setYtelse(List<YtelserDto> ytelse) {
        this.ytelse = ytelse;
    }
}
