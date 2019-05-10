package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class NaturalytelseTypeDto extends Kodeverk {

    static final String KODEVERK = "NATURAL_YTELSE_TYPE";
    
    /** Eksempel konstant - Bil. */
    public static final NaturalytelseTypeDto BIL = new NaturalytelseTypeDto("BIL");
    
    /** Eksempel konstant - Opsjoner. */
    public static final NaturalytelseTypeDto OPSJONER = new NaturalytelseTypeDto("OPSJONER");
    
    /** Eksempel konstant - Elektronisk kommunikasjon (mobil, bredbånd, etc.). */
    public static final NaturalytelseTypeDto ELEKTRISK_KOMMUNIKASJON = new NaturalytelseTypeDto("ELEKTRISK_KOMMUNIKASJON");
    
    
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public NaturalytelseTypeDto(@JsonProperty(value = "kode", required = true) String kode) {
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
