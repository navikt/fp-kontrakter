package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class YtelseType extends Kodeverk {
    static final String KODEVERK = "YTELSE_TYPE";

    /** Eksempel konstant - foreldrepenger. */
    public static final YtelseType FORELDREPENGER = new YtelseType("FP");

    /** Eksempel konstant - engangsstønad. */
    public static final YtelseType ENGANGSSTØNAD = new YtelseType("ES");

    /** Eksempel konstant - svangerskapspenger. */
    public static final YtelseType SVANGERSKAPSPENGER = new YtelseType("SVP");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public YtelseType(@JsonProperty(value = "kode", required = true) String kode) {
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
