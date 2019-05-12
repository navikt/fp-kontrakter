package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Arbeidskategori extends Kodeverk {
    static final String KODEVERK = "ARBEIDSKATEGORI";

    /** Eksempel konstant - ARBEIDSTAKER. */
    public static final Arbeidskategori ARBEIDSTAKER = new Arbeidskategori("ARBEIDSTAKER");
    /** Eksempel konstant - FRILANSER. */
    public static final Arbeidskategori FRILANSER = new Arbeidskategori("FRILANSER");
    /** Eksempel konstant - DAGPENGER. */
    public static final Arbeidskategori DAGPENGER = new Arbeidskategori("DAGPENGER");
    /** Eksempel konstant - JORDBRUKER. */
    public static final Arbeidskategori JORDBRUKER = new Arbeidskategori("JORDBRUKER");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public Arbeidskategori(@JsonProperty(value = "kode", required = true) String kode) {
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
