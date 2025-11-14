package no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import no.nav.foreldrepenger.kontrakter.fpsoknad.svangerskapspenger.ArbeidsforholdDto;

import java.util.List;

public record Dokumenterer(@NotNull DokumentererType type,
                           @Valid ArbeidsforholdDto arbeidsforhold,
                           @Size(max = 200) List<@Valid @NotNull ÅpenPeriodeDto> perioder) {
        public enum DokumentererType {
            BARN,
            OPPTJENING,
            UTTAK,
            TILRETTELEGGING,
        }
    }