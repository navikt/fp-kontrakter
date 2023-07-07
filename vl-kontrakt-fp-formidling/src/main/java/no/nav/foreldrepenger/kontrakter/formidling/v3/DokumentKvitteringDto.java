package no.nav.foreldrepenger.kontrakter.formidling.v3;

import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMal;

public record DokumentKvitteringDto(@NotNull @Valid UUID behandlingUuid,
                                    @NotNull @Valid UUID dokumentbestillingUuid,
                                    @NotNull @Valid DokumentMal dokumentMal,
                                    @NotNull @Pattern(regexp = "^[\\p{L}\\p{N}_.\\-]+$") String journalpostId,
                                    @NotNull @Digits(integer = 12, fraction = 0) String dokumentId) {

}
