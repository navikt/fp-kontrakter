package no.nav.foreldrepenger.kontrakter.formidling.v1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMalRestriksjon;

public record BrevmalDto(@NotNull @Pattern(regexp = "[A-Z]{6}") String kode,
                         @NotNull String navn,
                         @NotNull DokumentMalRestriksjon restriksjon,
                         boolean tilgjengelig) {
    public String getKode() {
        return kode;
    }

    public String getNavn() {
        return navn;
    }

    public DokumentMalRestriksjon getRestriksjon() {
        return restriksjon;
    }

    public boolean getTilgjengelig() {
        return tilgjengelig;
    }
}
