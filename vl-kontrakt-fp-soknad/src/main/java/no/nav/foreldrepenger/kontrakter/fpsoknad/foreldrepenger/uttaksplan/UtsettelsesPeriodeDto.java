package no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UtsettelsesPeriodeDto(@NotNull LocalDate fom,
                                    @NotNull LocalDate tom,
                                    @NotNull UtsettelsesÅrsak årsak,
                                    MorsAktivitet morsAktivitetIPerioden,
                                    boolean erArbeidstaker) implements Uttaksplanperiode {
}
