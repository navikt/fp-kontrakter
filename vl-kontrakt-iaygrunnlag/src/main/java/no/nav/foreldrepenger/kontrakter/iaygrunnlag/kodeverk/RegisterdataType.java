package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterdataType extends Kodeverk {
    static final String KODEVERK = "REGISTERDATA_TYPE";

    /** Eksempel konstant- ORDINÆRT_ARBEIDSFORHOLD. */
    public static RegisterdataType ARBEIDSFORHOLD = new RegisterdataType("ARBEIDSFORHOLD");

    /** Eksempel konstant- FRILANSER arbeid. */
    public static RegisterdataType LIGNET_NÆRING = new RegisterdataType("LIGNET_NÆRING");
    public static RegisterdataType INNTEKT_PENSJONSGIVENDE = new RegisterdataType("INNTEKT_PENSJONSGIVENDE");
    public static RegisterdataType INNTEKT_BEREGNINGSGRUNNLAG = new RegisterdataType("INNTEKT_BEREGNINGSGRUNNLAG");
    public static RegisterdataType INNTEKT_SAMMENLIGNINGSGRUNNLAG = new RegisterdataType("INNTEKT_SAMMENLIGNINGSGRUNNLAG");

    /** Eksempel konstant- UTENLANDSK_ARBEIDSFORHOLD arbeid. */
    public static RegisterdataType YTELSE = new RegisterdataType("YTELSE");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$", message="Kode '${validatedValue}' matcher ikke tillatt pattern '{regexp}'")
    @Size(min = 5, max = 50)
    @NotNull
    private String kode;

    @JsonCreator
    public RegisterdataType(@JsonProperty(value = "kode", required = true) String kode) {
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
