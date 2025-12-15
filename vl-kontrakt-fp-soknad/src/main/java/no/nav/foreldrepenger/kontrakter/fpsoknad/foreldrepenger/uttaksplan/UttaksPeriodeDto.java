package no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.KontoType;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.MorsAktivitet;

import java.time.LocalDate;
import java.util.List;

import static no.nav.foreldrepenger.kontrakter.felles.validering.InputValideringRegex.FRITEKST;


public record UttaksPeriodeDto(@NotNull LocalDate fom,
                               @NotNull LocalDate tom,
                               @NotNull KontoType konto,
                               MorsAktivitet morsAktivitetIPerioden,
                               Boolean ønskerSamtidigUttak,
                               @Min(0) @Max(100) Double samtidigUttakProsent,
                               Boolean ønskerFlerbarnsdager,
                               Boolean ønskerGradering,
                               @Valid GraderingDto gradering) implements Uttaksplanperiode {

    public record GraderingDto(@NotNull @Min(0) @Max(100) Double stillingsprosent,
                               Boolean erArbeidstaker,
                               Boolean erFrilanser,
                               Boolean erSelvstendig,
                               @Size(max = 15) List<@Pattern(regexp = FRITEKST) @NotNull String> orgnumre) {
    }

    @AssertTrue(message = "ønskerSamtidigUttak er satt, men ikke prosent, eller så er prosent satt og ikke ønskerSamtidigUttak")
    public boolean isSamtidigUttakGyldig() {
        if (!Boolean.TRUE.equals(ønskerSamtidigUttak)) {
            return samtidigUttakProsent == null;
        }
        return samtidigUttakProsent != null;
    }

}
