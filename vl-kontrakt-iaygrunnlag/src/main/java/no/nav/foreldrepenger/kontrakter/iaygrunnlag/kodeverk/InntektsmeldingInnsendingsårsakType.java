package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(InntektsmeldingInnsendingsårsakType.KODEVERK)
public class InntektsmeldingInnsendingsårsakType extends Kodeverk {
    static final String KODEVERK = "INNTEKTSMELDING_INNSENDINGSAARSAK";

    public static final InntektsmeldingInnsendingsårsakType NY = new InntektsmeldingInnsendingsårsakType("NY");
    public static final InntektsmeldingInnsendingsårsakType ENDRING = new InntektsmeldingInnsendingsårsakType("ENDRING");
    
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$", message="Kode '${validatedValue}' matcher ikke tillatt pattern '{regexp}'")
    @Size(min = 2, max = 50)
    @NotNull
    private String kode;

    @JsonCreator
    public InntektsmeldingInnsendingsårsakType(@JsonProperty(value = "kode", required = true) String kode) {
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
