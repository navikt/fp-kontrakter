package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ArbeidskategoriDto extends Kodeverk {
    static final String KODEVERK = "ARBEIDSKATEGORI";

    /** Eksempel konstant - ARBEIDSTAKER. */
    public static final ArbeidskategoriDto ARBEIDSTAKER = new ArbeidskategoriDto("ARBEIDSTAKER");
    /** Eksempel konstant - FRILANSER. */
    public static final ArbeidskategoriDto FRILANSER = new ArbeidskategoriDto("FRILANSER");
    /** Eksempel konstant - DAGPENGER. */
    public static final ArbeidskategoriDto DAGPENGER = new ArbeidskategoriDto("DAGPENGER");
    /** Eksempel konstant - JORDBRUKER. */
    public static final ArbeidskategoriDto JORDBRUKER = new ArbeidskategoriDto("JORDBRUKER");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public ArbeidskategoriDto(@JsonProperty(value = "kode", required = true) String kode) {
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
