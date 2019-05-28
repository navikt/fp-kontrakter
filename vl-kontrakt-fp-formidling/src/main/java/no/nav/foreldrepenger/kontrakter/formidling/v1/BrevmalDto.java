package no.nav.foreldrepenger.kontrakter.formidling.v1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMalRestriksjon;

public class BrevmalDto {
    @NotNull
    @Pattern(regexp = "[A-Z]{6}")
    private String kode;
    @NotNull
    private String navn;
    @NotNull
    private DokumentMalRestriksjon restriksjon;
    private boolean tilgjengelig;

    public BrevmalDto() {//For Jackson
    }

    public BrevmalDto(String kode, String navn, DokumentMalRestriksjon restriksjon, boolean tilgjengelig) {
        this.kode = kode;
        this.navn = navn;
        this.restriksjon = restriksjon;
        this.tilgjengelig = tilgjengelig;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public DokumentMalRestriksjon getRestriksjon() {
        return restriksjon;
    }

    public void setRestriksjon(DokumentMalRestriksjon restriksjon) {
        this.restriksjon = restriksjon;
    }

    public boolean getTilgjengelig() {
        return tilgjengelig;
    }

    public void setTilgjengelig(boolean tilgjengelig) {
        this.tilgjengelig = tilgjengelig;
    }
}
