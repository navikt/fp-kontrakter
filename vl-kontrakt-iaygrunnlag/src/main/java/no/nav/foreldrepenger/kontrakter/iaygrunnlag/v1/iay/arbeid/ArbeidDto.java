package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid;

import java.util.List;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.AktørDto;

public class ArbeidDto {

    private AktørDto aktør;
    private List<YrkesaktivitetDto> yrkesaktiviteter;

    public ArbeidDto() {
    }

    public AktørDto getAktør() {
        return aktør;
    }

    public void setAktør(AktørDto aktør) {
        this.aktør = aktør;
    }

    public List<YrkesaktivitetDto> getYrkesaktiviteter() {
        return yrkesaktiviteter;
    }

    public void setYrkesaktiviteter(List<YrkesaktivitetDto> yrkesaktiviteter) {
        this.yrkesaktiviteter = yrkesaktiviteter;
    }
}
