package no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.annenpart;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import no.nav.foreldrepenger.kontrakter.felles.typer.Fødselsnummer;

import static no.nav.foreldrepenger.kontrakter.felles.validering.InputValideringRegex.FRITEKST;

public record NorskForelderDto(@NotNull @Valid Fødselsnummer fnr,
                               @NotNull @Pattern(regexp = FRITEKST) String fornavn,
                               @NotNull @Pattern(regexp = FRITEKST) String etternavn,
                               @NotNull @Valid Rettigheter rettigheter) implements AnnenForelderDto {
}
