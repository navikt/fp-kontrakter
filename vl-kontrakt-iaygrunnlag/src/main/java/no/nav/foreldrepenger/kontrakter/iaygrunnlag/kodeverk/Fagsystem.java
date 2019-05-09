package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Fagsystem extends Kodeverk {
    static final String KODEVERK = "FAGSYSTEM";

    /** Eksempel konstant - FPSAK. */
    public static final Fagsystem FPSAK = new Fagsystem("FPSAK");
    
    /** Eksempel konstant - INNTEKT. */
    public static final Fagsystem INNTEKT = new Fagsystem("INNTEKT");
    
    /** Eksempel konstant - INFOTRYGD. */
    public static final Fagsystem INFOTRYGD = new Fagsystem("INFOTRYGD");
    
    /** Eksempel konstant - ARENA. */
    public static final Fagsystem ARENA = new Fagsystem("ARENA");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    @NotNull
    private String kode;
    
    @JsonCreator
    public Fagsystem(@JsonProperty(value = "kode", required = true) String kode) {
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
