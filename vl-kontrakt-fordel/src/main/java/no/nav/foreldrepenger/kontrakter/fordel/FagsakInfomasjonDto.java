package no.nav.foreldrepenger.kontrakter.fordel;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FagsakInfomasjonDto {
    @NotNull
    @Digits(integer = 19, fraction = 0)
    private String aktørId;

    @NotNull
    @Size(max = 8)
    @Pattern(regexp = "^[a-zA-Z0-9_-æøåÆØÅ]*$")
    private String behandlingstemaOffisiellKode;

    private Boolean harÅpenSvpBehandlingMedSøknad;

    public FagsakInfomasjonDto(String aktørId, String behandlingstemaOffisiellKode, Boolean harÅpenSvpBehandlingMedSøknad) {
        this.aktørId = aktørId;
        this.behandlingstemaOffisiellKode = behandlingstemaOffisiellKode;
        this.harÅpenSvpBehandlingMedSøknad = harÅpenSvpBehandlingMedSøknad;
    }

    public FagsakInfomasjonDto() { // For Jackson
    }

    public String getAktørId() {
        return aktørId;
    }

    public String getBehandlingstemaOffisiellKode() {
        return behandlingstemaOffisiellKode;
    }

    public Boolean getHarÅpenSvpBehandlingMedSøknad() {
        return harÅpenSvpBehandlingMedSøknad;
    }
}
