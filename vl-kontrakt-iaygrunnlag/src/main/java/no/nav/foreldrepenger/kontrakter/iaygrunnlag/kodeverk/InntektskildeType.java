package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InntektskildeType extends Kodeverk {
    static final String KODEVERK = "INNTEKTS_KILDE";

    /** Eksempel konstant- INNTEKT_BEREGNING. */
    public static final InntektskildeType INNTEKT_BEREGNING = new InntektskildeType("INNTEKT_BEREGNING");
    public static final InntektskildeType INNTEKT_OPPTJENING = new InntektskildeType("INNTEKT_OPPTJENING");
    public static final InntektskildeType INNTEKT_SAMMENLIGNING = new InntektskildeType("INNTEKT_SAMMENLIGNING");
    public static final InntektskildeType SIGRUN = new InntektskildeType("SIGRUN");
    public static final InntektskildeType VANLIG = new InntektskildeType("VANLIG");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public InntektskildeType(@JsonProperty(value = "kode", required = true) String kode) {
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
