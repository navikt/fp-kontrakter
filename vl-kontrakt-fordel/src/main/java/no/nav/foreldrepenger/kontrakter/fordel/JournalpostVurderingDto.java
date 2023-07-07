package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class JournalpostVurderingDto {

    @Size(max = 8)
    @Pattern(regexp = "^[a-zA-ZæøåÆØÅ_\\-0-9]*$")
    private String behandlingstemaOffisiellKode;

    private Boolean erFørstegangssøknad;
    private Boolean erInntektsmelding;

    public JournalpostVurderingDto(String behandlingstemaOffisiellKode,
                                   Boolean erFørstegangssøknad,
                                   Boolean erInntektsmelding) {
        this.behandlingstemaOffisiellKode = behandlingstemaOffisiellKode;
        this.erFørstegangssøknad = erFørstegangssøknad;
        this.erInntektsmelding = erInntektsmelding;
    }

    public JournalpostVurderingDto() {  // For Jackson
    }

    public String getBehandlingstemaOffisiellKode() {
        return behandlingstemaOffisiellKode;
    }

    public void setBehandlingstemaOffisiellKode(String behandlingstemaOffisiellKode) {
        this.behandlingstemaOffisiellKode = behandlingstemaOffisiellKode;
    }

    public Boolean getErFørstegangssøknad() {
        return erFørstegangssøknad;
    }

    public void setErFørstegangssøknad(Boolean erFørstegangssøknad) {
        this.erFørstegangssøknad = erFørstegangssøknad;
    }

    public Boolean getErInntektsmelding() {
        return erInntektsmelding;
    }

    public void setErInntektsmelding(Boolean erInntektsmelding) {
        this.erInntektsmelding = erInntektsmelding;
    }
}
