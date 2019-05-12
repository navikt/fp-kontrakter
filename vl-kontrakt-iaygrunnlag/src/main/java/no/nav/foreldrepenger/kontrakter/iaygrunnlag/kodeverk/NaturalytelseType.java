package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class NaturalytelseType extends Kodeverk {

    static final String KODEVERK = "NATURAL_YTELSE_TYPE";
    
    /** Eksempel konstant - Bil. */
    public static final NaturalytelseType BIL = new NaturalytelseType("BIL");
    
    /** Eksempel konstant - Opsjoner. */
    public static final NaturalytelseType OPSJONER = new NaturalytelseType("OPSJONER");
    
    /** Eksempel konstant - Elektronisk kommunikasjon (mobil, bredbånd, etc.). */
    public static final NaturalytelseType ELEKTRISK_KOMMUNIKASJON = new NaturalytelseType("ELEKTRISK_KOMMUNIKASJON");
    
    
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public NaturalytelseType(@JsonProperty(value = "kode", required = true) String kode) {
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
