package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ArbeidsforholdForAktørPåDatoDto {

    @NotNull
    @Valid
    private AktørDto aktør;
    @NotNull
    @Valid
    private LocalDate dato;

    public ArbeidsforholdForAktørPåDatoDto() {
    }

    public AktørDto getAktør() {
        return aktør;
    }

    public void setAktør(AktørDto aktør) {
        this.aktør = aktør;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }
}
