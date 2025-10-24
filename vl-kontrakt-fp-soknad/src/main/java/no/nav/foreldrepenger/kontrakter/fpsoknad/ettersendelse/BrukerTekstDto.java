package no.nav.foreldrepenger.kontrakter.fpsoknad.ettersendelse;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.DokumentTypeId;

import static no.nav.foreldrepenger.kontrakter.fpsoknad.validering.InputValideringRegex.FRITEKST;

public record BrukerTekstDto(@NotNull DokumentTypeId dokumentType, @NotNull @Pattern(regexp = FRITEKST) String tekst) {
}
