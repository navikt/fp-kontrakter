package no.nav.foreldrepenger.kontrakter.fpsoknad.svangerskapspenger;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BarnSvpDto(@NotNull LocalDate termindato, LocalDate fødselsdato) {
}
