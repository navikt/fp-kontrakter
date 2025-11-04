package no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

import static no.nav.foreldrepenger.kontrakter.felles.validering.InputValideringRegex.FRITEKST;

public record VedleggDto(UUID uuid,
                         @NotNull DokumentTypeId skjemanummer,
                         @NotNull InnsendingType innsendingsType,
                         @Pattern(regexp = FRITEKST) String beskrivelse,
                         @Valid Dokumenterer dokumenterer) {
    public VedleggDto {
        if (!InnsendingType.LASTET_OPP.equals(innsendingsType)) {
            uuid = UUID.randomUUID(); // UUID er kun definert for opplastede vedlegg, og brukes
        }
    }
}
