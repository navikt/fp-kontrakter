package no.nav.foreldrepenger.kontrakter.formidling.v3;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMal;

public record DokumentMalDto(@NotNull @Valid DokumentMal kode,
                             @NotNull String navn,
                             boolean tilgjengelig) {
}
