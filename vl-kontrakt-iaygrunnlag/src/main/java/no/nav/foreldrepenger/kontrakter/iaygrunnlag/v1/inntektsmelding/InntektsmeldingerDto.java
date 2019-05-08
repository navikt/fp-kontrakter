package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.inntektsmelding;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.ALWAYS)
public class InntektsmeldingerDto {

    @JsonProperty(value = "inntektsmeldinger")
    @Valid
    private List<InntektsmeldingDto> inntektsmeldinger;

    public InntektsmeldingerDto() {
    }

    public List<InntektsmeldingDto> getInntektsmeldinger() {
        return inntektsmeldinger;
    }

    public void setInntektsmeldinger(List<InntektsmeldingDto> inntektsmeldinger) {
        this.inntektsmeldinger = inntektsmeldinger;
    }
}
