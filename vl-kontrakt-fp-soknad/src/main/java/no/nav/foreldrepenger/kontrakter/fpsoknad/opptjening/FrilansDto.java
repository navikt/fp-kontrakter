package no.nav.foreldrepenger.kontrakter.fpsoknad.opptjening;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FrilansDto(boolean jobberFremdelesSomFrilans, @NotNull LocalDate oppstart) {
}
