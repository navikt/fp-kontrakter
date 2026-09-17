package no.nav.foreldrepenger.kontrakter.fpoversikt;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.KontoType;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.MorsAktivitet;


public record FellesUttaksplanDto(LocalDate termindato,
                                  @NotNull Integer antallBarn,
                                  @NotNull Dekningsgrad dekningsgrad,
                                  @NotNull List<UttakPeriodeDto> perioder) {

    public record UttakPeriodeDto(@NotNull LocalDate fom,
                                  @NotNull LocalDate tom,
                                  UttakDto søker,
                                  UttakDto annenPart, //ikke både eøs og norge samtidig
                                  EøsUttakDto annenPartEøs) { //Eøs er ikke i bruk i mottak av søknad
    }

    public record UttakDto(@NotNull Rolle forelder,
                           KontoType kontoType,
                           UtsettelseÅrsak utsettelseÅrsak,
                           OverføringÅrsak overføringÅrsak,
                           Gradering gradering,
                           MorsAktivitet morsAktivitet,
                           SamtidigUttak samtidigUttak,
                           @NotNull boolean flerbarnsdager,
                           VedtattResultat resultat) {
    }

    public enum Dekningsgrad {
        ÅTTI, HUNDRE
    }

    public enum UtsettelseÅrsak {
        ARBEID,
        FERIE,
        SØKER_SYKDOM,
        SØKER_INNLAGT,
        BARN_INNLAGT,
        HV_ØVELSE,
        NAV_TILTAK,
        FRI,
    }

    public enum OverføringÅrsak {
        INSTITUSJONSOPPHOLD_ANNEN_FORELDER,
        SYKDOM_ANNEN_FORELDER,
        ALENEOMSORG,
        IKKE_RETT_ANNEN_FORELDER
    }

    public record VedtattResultat(@NotNull boolean innvilget,
                                  @NotNull boolean trekkerMinsterett,
                                  @NotNull boolean trekkerDager,
                                  @NotNull Årsak årsak) {

        public enum Årsak {
            ANNET,
            AVSLAG_HULL_MELLOM_FORELDRENES_PERIODER,
            AVSLAG_FRATREKK_PLEIEPENGER,
            AVSLAG_UTSETTELSE_TILBAKE_I_TID,
            INNVILGET_UTTAK_AVSLÅTT_GRADERING_TILBAKE_I_TID,
        }
    }

    public record Gradering(@NotNull Arbeidstidprosent arbeidstidprosent, Aktivitet aktivitet) {

    }

    public record Arbeidstidprosent(@JsonValue BigDecimal value) {
    }

    public record Aktivitet(@NotNull AktivitetType type, Arbeidsgiver arbeidsgiver, String arbeidsgiverNavn) {

        public enum AktivitetType {
            FRILANS, ORDINÆRT_ARBEID, SELVSTENDIG_NÆRINGSDRIVENDE, ANNET
        }
    }

    public record EøsUttakDto(@NotNull KontoType kontoType, @NotNull Trekkdager trekkdager) {

        public record Trekkdager(@Min(0) @Digits(integer = 3, fraction = 1) @JsonValue BigDecimal verdi) {
        }
    }

    public enum Rolle {
        MOR,
        FAR_MEDMOR
    }

    public record SamtidigUttak(@JsonValue BigDecimal value) {
    }


    public record Arbeidsgiver(@NotNull String id, ArbeidsgiverType type) {

        public enum ArbeidsgiverType {
            PRIVAT,
            ORGANISASJON
        }

        @Override
        public String toString() {
            return "Arbeidsgiver{" + "id='******', type=" + type + '}';
        }
    }
}
