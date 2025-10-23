package no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ÅpenPeriodeDto(@NotNull LocalDate fom, LocalDate tom) {
}
