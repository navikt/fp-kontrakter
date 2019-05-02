package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class PeriodeDto {

    @NotNull
    private LocalDate fom;
    @NotNull
    private LocalDate tom;

    public PeriodeDto(LocalDate fom, LocalDate tom) {
        this.fom = fom;
        this.tom = tom;
    }

    public LocalDate getFom() {
        return fom;
    }

    public void setFom(LocalDate fom) {
        this.fom = fom;
    }

    public LocalDate getTom() {
        return tom;
    }

    public void setTom(LocalDate tom) {
        this.tom = tom;
    }
}
