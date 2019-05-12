package no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeidsforhold.v1;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class ArbeidsforholdInformasjon {

    @JsonProperty(value = "referanser")
    @Valid
    private List<ArbeidsforholdReferanseDto> referanser;

    @JsonProperty(value = "overstyringer")
    @Valid
    private List<ArbeidsforholdOverstyringDto> overstyringer;

    public ArbeidsforholdInformasjon() {
    }

    public List<ArbeidsforholdReferanseDto> getReferanser() {
        return referanser;
    }

    public void setReferanser(List<ArbeidsforholdReferanseDto> referanser) {
        this.referanser = referanser;
    }

    public List<ArbeidsforholdOverstyringDto> getOverstyringer() {
        return overstyringer;
    }

    public void setOverstyringer(List<ArbeidsforholdOverstyringDto> overstyringer) {
        this.overstyringer = overstyringer;
    }
}
