package no.nav.foreldrepenger.kontrakter.fpsoknad.builder;

import no.nav.foreldrepenger.kontrakter.felles.kodeverk.KontoType;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.MorsAktivitet;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.OppholdsPeriodeDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.Oppholdsårsak;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.OverføringsPeriodeDto;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.Overføringsårsak;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.UtsettelsesPeriodeDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.UtsettelsesÅrsak;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.UttaksPeriodeDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.Uttaksplanperiode;

import java.time.LocalDate;
import java.util.List;


public class UttakplanPeriodeBuilder {

    public static UttaksperiodeBuilder uttak(KontoType konto, LocalDate fom, LocalDate tom) {
        return new UttaksperiodeBuilder(konto, fom, tom);
    }

    public static GradertUttaksperiodeBuilder gradert(KontoType konto, LocalDate fom, LocalDate tom, Double stillingsprosent) {
        return new GradertUttaksperiodeBuilder(konto, fom, tom, stillingsprosent);
    }

    public static OppholdsPeriodeBuilder opphold(Oppholdsårsak oppholdsårsak, LocalDate fom, LocalDate tom) {
        return new OppholdsPeriodeBuilder(fom, tom, oppholdsårsak);
    }

    public static OverføringsperioderBuilder overføring(Overføringsårsak årsak, KontoType konto, LocalDate fom, LocalDate tom) {
        return new OverføringsperioderBuilder(konto, fom, tom, årsak);
    }

    public static UtsettelsePeriodeBuilder utsettelse(UtsettelsesÅrsak årsak, LocalDate fom, LocalDate tom) {
        return new UtsettelsePeriodeBuilder(fom, tom, årsak);
    }

    public static UtsettelsePeriodeBuilder friUtsettelse(LocalDate fom, LocalDate tom) {
        return new UtsettelsePeriodeBuilder(fom, tom, UtsettelsesÅrsak.FRI);
    }


    public static class UttaksperiodeBuilder {
        private final LocalDate fom;
        private final LocalDate tom;
        private final KontoType konto;
        private MorsAktivitet morsAktivitetIPerioden;
        private Boolean ønskerSamtidigUttak;
        private Boolean ønskerFlerbarnsdager;
        private Boolean ønskerGradering;
        private Double samtidigUttakProsent;

        public UttaksperiodeBuilder(KontoType konto, LocalDate fom, LocalDate tom) {
            this.fom = fom;
            this.tom = tom;
            this.konto = konto;
        }

        public UttaksperiodeBuilder medMorsAktivitetIPerioden(MorsAktivitet morsAktivitetIPerioden) {
            this.morsAktivitetIPerioden = morsAktivitetIPerioden;
            return this;
        }

        public UttaksperiodeBuilder medØnskerSamtidigUttak(Boolean ønskerSamtidigUttak) {
            this.ønskerSamtidigUttak = ønskerSamtidigUttak;
            return this;
        }

        public UttaksperiodeBuilder medØnskerFlerbarnsdager(Boolean ønskerFlerbarnsdager) {
            this.ønskerFlerbarnsdager = ønskerFlerbarnsdager;
            return this;
        }

        public UttaksperiodeBuilder medØnskerGradering(Boolean ønskerGradering) {
            this.ønskerGradering = ønskerGradering;
            return this;
        }

        public UttaksperiodeBuilder medSamtidigUttakProsent(Double samtidigUttakProsent) {
            this.samtidigUttakProsent = samtidigUttakProsent;
            return this;
        }


        public Uttaksplanperiode build() {
            return new UttaksPeriodeDto(fom,
                tom,
                konto,
                morsAktivitetIPerioden,
                ønskerSamtidigUttak,
                samtidigUttakProsent,
                ønskerFlerbarnsdager,
                ønskerGradering,
                null);
        }
    }

    public static class GradertUttaksperiodeBuilder {
        private final LocalDate fom;
        private final LocalDate tom;
        private final KontoType konto;
        private MorsAktivitet morsAktivitetIPerioden;
        private Boolean ønskerSamtidigUttak;
        private Boolean ønskerFlerbarnsdager;
        private Double samtidigUttakProsent;
        private final Double stillingsprosent;
        private Boolean ønskerGradering;
        private Boolean erArbeidstaker;
        private Boolean erFrilanser;
        private Boolean erSelvstendig;
        private List<String> orgnumre;

        public GradertUttaksperiodeBuilder(KontoType konto, LocalDate fom, LocalDate tom, Double stillingsprosent) {
            this.fom = fom;
            this.tom = tom;
            this.konto = konto;
            this.stillingsprosent = stillingsprosent;
        }

        public GradertUttaksperiodeBuilder medMorsAktivitetIPerioden(MorsAktivitet morsAktivitetIPerioden) {
            this.morsAktivitetIPerioden = morsAktivitetIPerioden;
            return this;
        }

        public GradertUttaksperiodeBuilder medØnskerSamtidigUttak(Boolean ønskerSamtidigUttak) {
            this.ønskerSamtidigUttak = ønskerSamtidigUttak;
            return this;
        }

        public GradertUttaksperiodeBuilder medØnskerFlerbarnsdager(Boolean ønskerFlerbarnsdager) {
            this.ønskerFlerbarnsdager = ønskerFlerbarnsdager;
            return this;
        }

        public GradertUttaksperiodeBuilder medSamtidigUttakProsent(Double samtidigUttakProsent) {
            this.samtidigUttakProsent = samtidigUttakProsent;
            return this;
        }

        public GradertUttaksperiodeBuilder medØnskerGradering(Boolean ønskerGradering) {
            this.ønskerGradering = ønskerGradering;
            return this;
        }

        public GradertUttaksperiodeBuilder medErArbeidstaker(Boolean erArbeidstaker) {
            this.erArbeidstaker = erArbeidstaker;
            return this;
        }

        public GradertUttaksperiodeBuilder medErFrilanser(Boolean erFrilanser) {
            this.erFrilanser = erFrilanser;
            return this;
        }

        public GradertUttaksperiodeBuilder medErSelvstendig(Boolean erSelvstendig) {
            this.erSelvstendig = erSelvstendig;
            return this;
        }

        public GradertUttaksperiodeBuilder medOrgnumre(List<String> orgnumre) {
            this.orgnumre = orgnumre;
            return this;
        }

        public UttaksPeriodeDto build() {
            return new UttaksPeriodeDto(fom,
                tom,
                konto,
                morsAktivitetIPerioden,
                ønskerSamtidigUttak,
                samtidigUttakProsent,
                ønskerFlerbarnsdager,
                ønskerGradering,
                new UttaksPeriodeDto.GraderingDto(stillingsprosent, erArbeidstaker, erFrilanser, erSelvstendig, orgnumre));
        }
    }

    public static class OverføringsperioderBuilder {
        private final LocalDate fom;
        private final LocalDate tom;
        private final Overføringsårsak årsak;
        private final KontoType konto;

        public OverføringsperioderBuilder(KontoType konto, LocalDate fom, LocalDate tom, Overføringsårsak årsak) {
            this.fom = fom;
            this.tom = tom;
            this.årsak = årsak;
            this.konto = konto;
        }

        public Uttaksplanperiode build() {
            return new OverføringsPeriodeDto(fom, tom, årsak, konto);
        }
    }


    public static class OppholdsPeriodeBuilder {
        private final LocalDate fom;
        private final LocalDate tom;
        private final Oppholdsårsak årsak;

        public OppholdsPeriodeBuilder(LocalDate fom, LocalDate tom, Oppholdsårsak årsak) {
            this.fom = fom;
            this.tom = tom;
            this.årsak = årsak;
        }

        public Uttaksplanperiode build() {
            return new OppholdsPeriodeDto(fom, tom, årsak);
        }
    }


    public static class UtsettelsePeriodeBuilder {
        private final LocalDate fom;
        private final LocalDate tom;
        private final UtsettelsesÅrsak årsak;
        private MorsAktivitet morsAktivitetIPerioden;
        private boolean erArbeidstaker;

        public UtsettelsePeriodeBuilder(LocalDate fom, LocalDate tom, UtsettelsesÅrsak årsak) {
            this.fom = fom;
            this.tom = tom;
            this.årsak = årsak;
        }

        public UtsettelsePeriodeBuilder medMorsAktivitetIPerioden(MorsAktivitet morsAktivitetIPerioden) {
            this.morsAktivitetIPerioden = morsAktivitetIPerioden;
            return this;
        }

        public UtsettelsePeriodeBuilder medErArbeidstaker(boolean erArbeidstaker) {
            this.erArbeidstaker = erArbeidstaker;
            return this;
        }

        public Uttaksplanperiode build() {
            return new UtsettelsesPeriodeDto(fom, tom, årsak, morsAktivitetIPerioden, erArbeidstaker);
        }
    }
}
