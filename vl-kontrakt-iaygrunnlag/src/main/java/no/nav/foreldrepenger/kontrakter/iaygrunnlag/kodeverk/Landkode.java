package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Landkode extends Kodeverk {

    static final String KODEVERK = "LANDKODER";

    /** Eksempel konstant. Norge. */
    public static final Landkode NORGE = new Landkode("NOR");
    public static final Landkode SVERIGE = new Landkode("SWE");
    public static final Landkode DANMARK = new Landkode("DNK");

    /** ISO 3-letter country codes. */
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[A-Z]{3}$", message="Kode Landkode '${validatedValue}' matcher ikke tillatt pattern (ISO 3-letter country code)")
    @Size(min = 3, max = 3)
    @NotNull
    private String kode;

    @JsonCreator
    public Landkode(@JsonProperty(value = "kode", required = true) String kode) {
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
