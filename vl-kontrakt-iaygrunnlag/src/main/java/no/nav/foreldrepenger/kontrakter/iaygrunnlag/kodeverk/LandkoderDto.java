package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class LandkoderDto extends Kodeverk {

    static final String KODEVERK = "LANDKODER";
    
    /** Eksempel konstant. Norge. */
    public static final LandkoderDto NORGE = new LandkoderDto("NOR");
    public static final LandkoderDto SVERIGE = new LandkoderDto("SWE");
    public static final LandkoderDto DANMARK = new LandkoderDto("DNK");

    /** ISO 3-letter country codes. */
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[A-Z]{3}$")
    @NotNull
    private String kode;

    @JsonCreator
    public LandkoderDto(@JsonProperty(value = "kode", required = true) String kode) {
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
