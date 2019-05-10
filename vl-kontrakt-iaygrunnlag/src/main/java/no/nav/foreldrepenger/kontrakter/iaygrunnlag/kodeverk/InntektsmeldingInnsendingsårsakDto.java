package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(InntektsmeldingInnsendingsårsakDto.KODEVERK)
public class InntektsmeldingInnsendingsårsakDto extends Kodeverk {
    static final String KODEVERK = "INNTEKTSMELDING_INNSENDINGSAARSAK";

    public static final InntektsmeldingInnsendingsårsakDto NY = new InntektsmeldingInnsendingsårsakDto("NY");
    public static final InntektsmeldingInnsendingsårsakDto ENDRING = new InntektsmeldingInnsendingsårsakDto("ENDRING");
    
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public InntektsmeldingInnsendingsårsakDto(@JsonProperty(value = "kode", required = true) String kode) {
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
