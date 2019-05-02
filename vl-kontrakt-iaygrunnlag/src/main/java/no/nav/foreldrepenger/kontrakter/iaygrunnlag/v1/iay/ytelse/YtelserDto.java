package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse;

import java.util.List;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.AktørDto;

public class YtelserDto {
    private AktørDto aktør;
    private List<YtelseDto> ytelser;

    public YtelserDto() {
    }

    public AktørDto getAktør() {
        return aktør;
    }

    public void setAktør(AktørDto aktør) {
        this.aktør = aktør;
    }

    public List<YtelseDto> getYtelser() {
        return ytelser;
    }

    public void setYtelser(List<YtelseDto> ytelser) {
        this.ytelser = ytelser;
    }
}
