package no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TilkjentYtelsePeriodeV1 {
    @NotNull
    private LocalDate fom;
    @NotNull
    private LocalDate tom;
    @Valid
    @Size(min = 1, max = 100)
    private Collection<TilkjentYtelseAndelV1> andeler;

    TilkjentYtelsePeriodeV1() {
        //for jackson
    }

    public TilkjentYtelsePeriodeV1(LocalDate fom, LocalDate tom, Collection<TilkjentYtelseAndelV1> andeler) {
        this.fom = fom;
        this.tom = tom;
        this.andeler = andeler;
    }

    public LocalDate getFom() {
        return fom;
    }

    public LocalDate getTom() {
        return tom;
    }

    public Collection<TilkjentYtelseAndelV1> getAndeler() {
        return andeler;
    }

    public void kryssvalider() throws ParseException {
        for (TilkjentYtelseAndelV1 andel : andeler) {
            andel.kryssvalider();
        }
    }
}
