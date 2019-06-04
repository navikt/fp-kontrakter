package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class VirksomhetType extends Kodeverk {

    static final String KODEVERK = "VIRKSOMHET_TYPE";
    
    /** Eksempel konstant, Annen næringsvirksomhet. */
    public static final VirksomhetType ANNEN = new VirksomhetType("ANNEN");
    
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @Size(min = 3, max = 50)
    @NotNull
    private String kode;

    @JsonCreator
    public VirksomhetType(@JsonProperty(value = "kode", required = true) String kode) {
        Objects.requireNonNull(kode, "kode");
        this.kode = kode;
    }

    @Override
    public String getKode() {
        return kode;
    }

    @Override
    public String getKodeverk() {
        return KODEVERK;
    }
}

