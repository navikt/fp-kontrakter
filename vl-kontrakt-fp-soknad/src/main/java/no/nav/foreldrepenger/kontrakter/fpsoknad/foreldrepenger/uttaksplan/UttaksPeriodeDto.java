package no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

import static no.nav.foreldrepenger.kontrakter.fpsoknad.validering.InputValideringRegex.FRITEKST;

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
                               @Valid @Size(max = 15) List<@Pattern(regexp = FRITEKST) @NotNull String> orgnumre) {
    }
}
