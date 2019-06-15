package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ArbeidsforholdHandlingType extends Kodeverk {
    static final String KODEVERK = "ARBEIDSFORHOLD_HANDLING_TYPE";
    
    /** Eksempel konstant - nytt arbeidsforhold. */
    public static final ArbeidsforholdHandlingType NYTT_ARBEIDSFORHOLD = new ArbeidsforholdHandlingType("NYTT_ARBEIDSFORHOLD"); //$NON-NLS-1$
    
    /** Eksempel konstant - ikke vent på inntektsmelding. */
    public static final ArbeidsforholdHandlingType BRUK_UTEN_INNTEKTSMELDING = new ArbeidsforholdHandlingType("BRUK_UTEN_INNTEKTSMELDING"); //$NON-NLS-1$
    
    /** Eksempel konstant - ikke bruk dette. */
    public static final ArbeidsforholdHandlingType IKKE_BRUK = new ArbeidsforholdHandlingType("IKKE_BRUK"); //$NON-NLS-1$

    /** Eksempel konstant - bruk dette. */
    public static final ArbeidsforholdHandlingType BRUK = new ArbeidsforholdHandlingType("BRUK"); //$NON-NLS-1$
    
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @Size(min = 4, max = 50)
    @NotNull
    private String kode;

    @JsonCreator
    public ArbeidsforholdHandlingType(@JsonProperty(value = "kode", required = true)  String kode) {
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
