package no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.KontoType;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.Overføringsårsak;
import no.nav.foreldrepenger.kontrakter.fpsoknad.builder.UttakplanPeriodeBuilder;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class UttaksPeriodeDtoInputValideringTest {

    @Test
    void uttaksperiode_ønsker_samtidig_uttak_uten_prosent_skal_føre_til_valideringsfeil() {
        var uttaksperiode = UttakplanPeriodeBuilder
                .uttak(KontoType.FEDREKVOTE, LocalDate.now().minusWeeks(4), LocalDate.now())
                .medØnskerSamtidigUttak(true)
                .medSamtidigUttakProsent(null)
                .build();

        var validator = hentValidator();
        var resultat = validator.validate(uttaksperiode);
        assertThat(resultat).hasSize(1)
                .extracting(ConstraintViolation::getMessage)
                .contains("ønskerSamtidigUttak er satt, men ikke prosent, eller så er prosent satt og ikke ønskerSamtidigUttak");
    }


    @Test
    void uttaksperiode_ønsker_samtidig_uttak_med_prosent_skal_ikke_føre_til_valideringsfeil() {
        var uttaksperiode = UttakplanPeriodeBuilder
                .uttak(KontoType.FEDREKVOTE, LocalDate.now().minusWeeks(4), LocalDate.now())
                .medØnskerSamtidigUttak(true)
                .medSamtidigUttakProsent(20.2)
                .build();

        var validator = hentValidator();
        var resultat = validator.validate(uttaksperiode);
        assertThat(resultat).isEmpty();
    }

    @Test
    void uttaksperiode_ikke_samtidig_uttak_skal_ikke_føre_til_valideringsfeil() {
        var uttaksperiode = UttakplanPeriodeBuilder
                .uttak(KontoType.FEDREKVOTE, LocalDate.now().minusWeeks(4), LocalDate.now())
                .build();

        var validator = hentValidator();
        var resultat = validator.validate(uttaksperiode);
        assertThat(resultat).isEmpty();

    }

    @Test
    void uttaksperiode_tom_før_fom_skal_føre_til_valideringsfeil() {
        var fom = LocalDate.now();
        var tom = fom.minusDays(1);
        var periode = UttakplanPeriodeBuilder.uttak(KontoType.FEDREKVOTE, fom, tom).build();

        var resultat = hentValidator().validate(periode);
        assertThat(resultat).hasSize(1)
                .extracting(ConstraintViolation::getMessage)
                .contains("tom kan ikke være før fom");
    }

    @Test
    void uttaksperiode_fom_lik_tom_skal_ikke_føre_til_valideringsfeil() {
        var dag = LocalDate.now();
        var periode = UttakplanPeriodeBuilder.uttak(KontoType.FEDREKVOTE, dag, dag).build();

        assertThat(hentValidator().validate(periode)).isEmpty();
    }

    @Test
    void overforingsperiode_tom_før_fom_skal_føre_til_valideringsfeil() {
        var fom = LocalDate.now();
        var tom = fom.minusDays(1);
        var periode = UttakplanPeriodeBuilder.overføring(Overføringsårsak.INSTITUSJONSOPPHOLD_ANNEN_FORELDER, KontoType.FEDREKVOTE, fom, tom).build();

        var resultat = hentValidator().validate(periode);
        assertThat(resultat).hasSize(1)
                .extracting(ConstraintViolation::getMessage)
                .contains("tom kan ikke være før fom");
    }

    @Test
    void overforingsperiode_fom_lik_tom_skal_ikke_føre_til_valideringsfeil() {
        var dag = LocalDate.now();
        var periode = UttakplanPeriodeBuilder.overføring(Overføringsårsak.INSTITUSJONSOPPHOLD_ANNEN_FORELDER, KontoType.FEDREKVOTE, dag, dag).build();

        assertThat(hentValidator().validate(periode)).isEmpty();
    }

    @Test
    void oppholdperiode_tom_før_fom_skal_føre_til_valideringsfeil() {
        var fom = LocalDate.now();
        var tom = fom.minusDays(1);
        var periode = UttakplanPeriodeBuilder.opphold(Oppholdsårsak.UTTAK_FELLESP_ANNEN_FORELDER, fom, tom).build();

        var resultat = hentValidator().validate(periode);
        assertThat(resultat).hasSize(1)
                .extracting(ConstraintViolation::getMessage)
                .contains("tom kan ikke være før fom");
    }

    @Test
    void oppholdperiode_fom_lik_tom_skal_ikke_føre_til_valideringsfeil() {
        var dag = LocalDate.now();
        var periode = UttakplanPeriodeBuilder.opphold(Oppholdsårsak.UTTAK_FELLESP_ANNEN_FORELDER, dag, dag).build();

        var resultat = hentValidator().validate(periode);
        assertThat(resultat).isEmpty();
    }

    @Test
    void utsettelseperiode_tom_før_fom_skal_føre_til_valideringsfeil() {
        var fom = LocalDate.now();
        var tom = fom.minusDays(1);
        var periode = UttakplanPeriodeBuilder.utsettelse(UtsettelsesÅrsak.LOVBESTEMT_FERIE, fom, tom).build();

        var resultat = hentValidator().validate(periode);
        assertThat(resultat).hasSize(1)
                .extracting(ConstraintViolation::getMessage)
                .contains("tom kan ikke være før fom");
    }

    @Test
    void utsettelseperiode_fom_lik_tom_skal_ikke_føre_til_valideringsfeil() {
        var dag = LocalDate.now();
        var periode = UttakplanPeriodeBuilder.utsettelse(UtsettelsesÅrsak.LOVBESTEMT_FERIE, dag, dag).build();

        var resultat = hentValidator().validate(periode);
        assertThat(resultat).isEmpty();
    }

    private static Validator hentValidator() {
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            return factory.getValidator();
        }
    }
}