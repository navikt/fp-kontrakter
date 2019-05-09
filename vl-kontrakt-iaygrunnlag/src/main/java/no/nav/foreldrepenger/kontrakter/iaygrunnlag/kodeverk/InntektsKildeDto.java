package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InntektsKildeDto extends Kodeverk {
    static final String KODEVERK = "INNTEKTS_KILDE";

    /** Eksempel konstant- INNTEKT_BEREGNING. */
    public static final InntektsKildeDto INNTEKT_BEREGNING = new InntektsKildeDto("INNTEKT_BEREGNING");
    public static final InntektsKildeDto INNTEKT_OPPTJENING = new InntektsKildeDto("INNTEKT_OPPTJENING");
    public static final InntektsKildeDto INNTEKT_SAMMENLIGNING = new InntektsKildeDto("INNTEKT_SAMMENLIGNING");
    public static final InntektsKildeDto SIGRUN = new InntektsKildeDto("SIGRUN");
    public static final InntektsKildeDto VANLIG = new InntektsKildeDto("VANLIG");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public InntektsKildeDto(@JsonProperty(value = "kode", required = true) String kode) {
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
