package no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan;

import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.KontoType;
import no.nav.foreldrepenger.kontrakter.felles.kodeverk.Overføringsårsak;

import java.time.LocalDate;

public record OverføringsPeriodeDto(@NotNull LocalDate fom,
                                    @NotNull LocalDate tom,
                                    @NotNull Overføringsårsak årsak,
                                    @NotNull KontoType konto) implements Uttaksplanperiode {
}
