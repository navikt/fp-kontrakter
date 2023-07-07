package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class FagsakInfomasjonDto {
    @NotNull
    @Digits(integer = 19, fraction = 0)
    private String aktørId;

    @NotNull
    @Size(max = 8)
    @Pattern(regexp = "^[a-zA-Z0-9_-æøåÆØÅ]*$")
    private String behandlingstemaOffisiellKode;

    public FagsakInfomasjonDto(String aktørId, String behandlingstemaOffisiellKode) {
        this.aktørId = aktørId;
        this.behandlingstemaOffisiellKode = behandlingstemaOffisiellKode;
    }

    public FagsakInfomasjonDto() { // For Jackson
    }

    public String getAktørId() {
        return aktørId;
    }

    public String getBehandlingstemaOffisiellKode() {
        return behandlingstemaOffisiellKode;
    }

}
