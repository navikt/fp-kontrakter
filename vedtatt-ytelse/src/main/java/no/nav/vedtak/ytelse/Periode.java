package no.nav.vedtak.ytelse;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class Periode {

    @NotNull
    private LocalDate fom;
    @NotNull
    private LocalDate tom;

    public Periode() {
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
