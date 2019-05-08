package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.arbeidsforhold;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class ArbeidsforholdDto {

    @JsonProperty(value = "arbeidsgiver", required = true)
    @Valid
    @NotNull
    private ArbeidsgiverDto arbeidsgiver;

    @JsonProperty(value = "arbeidType", required = true)
    @Valid
    @NotNull
    private ArbeidTypeDto type;

    @JsonProperty("arbeidsforholdId")
    @Valid
    private ArbeidsforholdRefDto arbeidsforholdId;

    @JsonProperty("ansettelsePerioder")
    @Valid
    private List<PeriodeDto> ansettelsesperiode = Collections.emptyList();

    protected ArbeidsforholdDto() {
    }

    public ArbeidsforholdDto(ArbeidsgiverDto arbeidsgiver, ArbeidTypeDto type) {
        this.arbeidsgiver = arbeidsgiver;
        this.type = type;
    }

    public ArbeidsgiverDto getArbeidsgiver() {
        return arbeidsgiver;
    }

    public ArbeidsforholdRefDto getArbeidsforholdId() {
        return arbeidsforholdId;
    }

    public void setArbeidsforholdId(ArbeidsforholdRefDto arbeidsforholdId) {
        this.arbeidsforholdId = arbeidsforholdId;
    }

    public ArbeidTypeDto getType() {
        return type;
    }

    public List<PeriodeDto> getAnsettelsesperiode() {
        return ansettelsesperiode;
    }

    public void setAnsettelsesperiode(List<PeriodeDto> ansettelsesperiode) {
        this.ansettelsesperiode = ansettelsesperiode;
    }
}
