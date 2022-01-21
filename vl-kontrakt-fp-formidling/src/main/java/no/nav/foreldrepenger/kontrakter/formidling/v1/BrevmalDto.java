package no.nav.foreldrepenger.kontrakter.formidling.v1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMalRestriksjon;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.EnumDokumentMalRestriksjon;

public record BrevmalDto(@NotNull @Pattern(regexp = "[A-Z]{6}") String kode,
                         @NotNull String navn,
                         @NotNull DokumentMalRestriksjon restriksjon,
                         @NotNull EnumDokumentMalRestriksjon dokumentMalRestriksjon,
                         boolean tilgjengelig) {

    @Deprecated // Kall full Ctor med enum restriksjon
    public BrevmalDto(String kode,
                      String navn,
                      DokumentMalRestriksjon restriksjon,
                      boolean tilgjengelig) {
        this(kode, navn, restriksjon, EnumDokumentMalRestriksjon.valueOf(restriksjon.getKode()), tilgjengelig);
    }

    @Deprecated // Bruk kode()
    public String getKode() {
        return kode;
    }
    @Deprecated // Bruk navn()
    public String getNavn() {
        return navn;
    }
    @Deprecated // Bruk restriksjon()
    public DokumentMalRestriksjon getRestriksjon() {
        return restriksjon;
    }
    @Deprecated // Bruk tilgjengelig()
    public boolean getTilgjengelig() {
        return tilgjengelig;
    }
}
