package no.nav.foreldrepenger.kontrakter.fpsoknad.svangerskapspenger;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AvtaltFerieDto(@Valid @NotNull ArbeidsforholdDto arbeidsforhold, @NotNull LocalDate fom, @NotNull LocalDate tom) {

    @AssertTrue(message = "Kan bare legge til avtalt ferie for virksomhet")
    public boolean isArbeidsforholdVirksomhet() {
        return arbeidsforhold instanceof ArbeidsforholdDto.VirksomhetDto || arbeidsforhold instanceof ArbeidsforholdDto.PrivatArbeidsgiverDto;
    }
}
