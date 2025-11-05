package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.KontoType;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.MorsAktivitet;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.Overføringsårsak;

import java.time.LocalDate;
import java.util.Objects;

public record UttakPeriode(@NotNull LocalDate fom,
                           @NotNull LocalDate tom,
                           KontoType kontoType,
                           UttakPeriodeResultat resultat,
                           UttakUtsettelseÅrsak utsettelseÅrsak,
                           UttakOppholdÅrsak oppholdÅrsak,
                           Overføringsårsak overføringÅrsak,
                           Gradering gradering,
                           MorsAktivitet morsAktivitet,
                           SamtidigUttak samtidigUttak,
                           boolean flerbarnsdager,
                           BrukerRolleSak forelder) {

    public boolean likBortsattFraTidsperiode(UttakPeriode that) { //Brukes for å slå sammen like perioder
        return flerbarnsdager == that.flerbarnsdager && kontoType == that.kontoType && Objects.equals(gradering, that.gradering)
                && oppholdÅrsak == that.oppholdÅrsak && morsAktivitet == that.morsAktivitet && Objects.equals(samtidigUttak,
                that.samtidigUttak) && Objects.equals(resultat, that.resultat) && utsettelseÅrsak == that.utsettelseÅrsak
                && overføringÅrsak == that.overføringÅrsak && forelder == that.forelder;
    }
}
