package no.nav.foreldrepenger.kontrakter.formidling.v3;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMal;

public record DokumentMalDto(@NotNull @Valid DokumentMal kode,
                             @NotNull String navn,
                             boolean tilgjengelig) {
}
