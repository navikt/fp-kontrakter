package no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.KontoType;
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
                .contains("ønskerSamtidigUttak er satt til true, men mangler samtidigUttakProsent");
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

    private static Validator hentValidator() {
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            return factory.getValidator();
        }
    }
}