package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid;

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
@JsonInclude(value = Include.ALWAYS, content = Include.NON_EMPTY)
public class YrkesaktivitetDto {

    @JsonProperty("arbeidsgiver")
    @Valid
    private ArbeidsgiverDto arbeidsgiver;
    
    @JsonProperty("arbeidsforholdId")
    @Valid
    private ArbeidsforholdRefDto arbeidsforholdId;
    
    @JsonProperty("arbeidType")
    @Valid
    @NotNull
    private ArbeidTypeDto type;
    
    @JsonProperty("ansettelsePerioder")
    @Valid
    private List<PeriodeDto> ansettelsePerioder  = Collections.emptyList();
    
    @JsonProperty("aktivitetsAvtaler")
    @Valid
    private List<AktivitetsAvtaleDto> aktivitetsAvtaler = Collections.emptyList();
    
    @JsonProperty("permisjoner")
    @Valid
    private List<PermisjonDto> permisjoner = Collections.emptyList();

    protected YrkesaktivitetDto() {
        // default ctor
    }

    public ArbeidsgiverDto getArbeidsgiver() {
        return arbeidsgiver;
    }

    public void setArbeidsgiver(ArbeidsgiverDto arbeidsgiver) {
        this.arbeidsgiver = arbeidsgiver;
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

    public void setType(ArbeidTypeDto type) {
        this.type = type;
    }

    public List<PeriodeDto> getAnsettelsesperiode() {
        return ansettelsePerioder;
    }

    public void setAnsettelsesperiode(List<PeriodeDto> ansettelsesperiode) {
        this.ansettelsePerioder = ansettelsesperiode;
    }

    public List<AktivitetsAvtaleDto> getAktivitetsAvtaler() {
        return aktivitetsAvtaler;
    }

    public void setAktivitetsAvtaler(List<AktivitetsAvtaleDto> aktivitetsAvtaler) {
        this.aktivitetsAvtaler = aktivitetsAvtaler;
    }

    public List<PermisjonDto> getPermisjoner() {
        return permisjoner;
    }

    public void setPermisjoner(List<PermisjonDto> permisjoner) {
        this.permisjoner = permisjoner;
    }
}
