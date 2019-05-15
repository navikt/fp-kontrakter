package no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class InntektsmeldingerDto {

    @JsonProperty(value = "inntektsmeldinger", required = true)
    @NotNull
    @Valid
    private List<InntektsmeldingDto> inntektsmeldinger;

    @JsonProperty(value = "inntektsmeldingerSomIkkeKommer")
    @Valid
    private List<InntektsmeldingSomIkkeKommerDto> inntektsmeldingerSomIkkeKommer;

    public InntektsmeldingerDto() {
        // default ctor
    }

    public List<InntektsmeldingDto> getInntektsmeldinger() {
        return inntektsmeldinger == null ? Collections.emptyList() : inntektsmeldinger;
    }

    public List<InntektsmeldingSomIkkeKommerDto> getInntektsmeldingerSomIkkeKommer() {
        return inntektsmeldingerSomIkkeKommer == null ? Collections.emptyList() : inntektsmeldingerSomIkkeKommer;
    }

    public void setInntektsmeldinger(List<InntektsmeldingDto> inntektsmeldinger) {
        this.inntektsmeldinger = inntektsmeldinger;
    }

    public InntektsmeldingerDto medInntektsmeldinger(List<InntektsmeldingDto> inntektsmeldinger) {
        setInntektsmeldinger(inntektsmeldinger);
        return this;
    }

    public void setInntektsmeldingerSomIkkeKommer(List<InntektsmeldingSomIkkeKommerDto> inntektsmeldingerSomIkkeKommer) {
        this.inntektsmeldingerSomIkkeKommer = inntektsmeldingerSomIkkeKommer;
    }

    public InntektsmeldingerDto medInntektsmeldingerSomIkkeKommer(List<InntektsmeldingSomIkkeKommerDto> inntektsmeldingerSomIkkeKommer) {
        setInntektsmeldingerSomIkkeKommer(inntektsmeldingerSomIkkeKommer);
        return this;
    }
}
