package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt;

import java.util.List;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.AktørDto;

public class InntekterDto {

    private AktørDto aktør;
    private List<UtbetalingDto> utbetalinger;

    public InntekterDto() {
    }

    public AktørDto getAktør() {
        return aktør;
    }

    public void setAktør(AktørDto aktør) {
        this.aktør = aktør;
    }

    public List<UtbetalingDto> getUtbetalinger() {
        return utbetalinger;
    }

    public void setUtbetalinger(List<UtbetalingDto> utbetalinger) {
        this.utbetalinger = utbetalinger;
    }
}
