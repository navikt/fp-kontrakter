package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ArbeidTypeDto extends Kodeverk {
    static final String KODEVERK = "ARBEID_TYPE";

    /** Eksempel konstant- ORDINÆRT_ARBEIDSFORHOLD. */
    public static ArbeidTypeDto ORDINÆRT_ARBEIDSFORHOLD = new ArbeidTypeDto("ORDINÆRT_ARBEIDSFORHOLD");
    
    /** Eksempel konstant- FRILANSER arbeid. */
    public static ArbeidTypeDto FRILANSER = new ArbeidTypeDto("FRILANSER");
    
    /** Eksempel konstant- UTENLANDSK_ARBEIDSFORHOLD arbeid. */
    public static ArbeidTypeDto UTENLANDSK_ARBEIDSFORHOLD = new ArbeidTypeDto("UTENLANDSK_ARBEIDSFORHOLD");
    
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public ArbeidTypeDto(@JsonProperty(value = "kode", required = true) String kode) {
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
