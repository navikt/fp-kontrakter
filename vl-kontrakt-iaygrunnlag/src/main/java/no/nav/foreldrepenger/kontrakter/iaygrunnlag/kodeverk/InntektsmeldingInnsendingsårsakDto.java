package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(InntektsmeldingInnsendingsårsakDto.KODEVERK)
public class InntektsmeldingInnsendingsårsakDto extends Kodeverk {
    static final String KODEVERK = "INNTEKTSMELDING_INNSENDINGSAARSAK";

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    private String kode;

    public InntektsmeldingInnsendingsårsakDto(String kode) {
        super();
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
