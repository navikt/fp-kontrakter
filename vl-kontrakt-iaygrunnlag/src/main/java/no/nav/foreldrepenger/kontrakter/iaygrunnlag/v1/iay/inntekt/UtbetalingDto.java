package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt;

import java.util.List;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektsKildeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;

public class UtbetalingDto {

    private ArbeidsgiverDto utbetaler;
    private InntektsKildeDto kilde;
    private List<UtbetalingsPostDto> poster;

    public UtbetalingDto() {
    }

    public ArbeidsgiverDto getUtbetaler() {
        return utbetaler;
    }

    public void setUtbetaler(ArbeidsgiverDto utbetaler) {
        this.utbetaler = utbetaler;
    }

    public InntektsKildeDto getKilde() {
        return kilde;
    }

    public void setKilde(InntektsKildeDto kilde) {
        this.kilde = kilde;
    }

    public List<UtbetalingsPostDto> getPoster() {
        return poster;
    }

    public void setPoster(List<UtbetalingsPostDto> poster) {
        this.poster = poster;
    }
}
