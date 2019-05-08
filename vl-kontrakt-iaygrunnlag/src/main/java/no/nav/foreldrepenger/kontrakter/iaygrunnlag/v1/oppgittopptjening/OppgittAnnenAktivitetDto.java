package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.ALWAYS)
public class OppgittAnnenAktivitetDto {
    
    @JsonProperty(value = "periode", required = true)
    @Valid
    @NotNull
    private PeriodeDto periode;
    
    @JsonProperty(value = "arbeidType", required = true)
    @Valid
    @NotNull
    private ArbeidTypeDto arbeidTypeDto;

    public OppgittAnnenAktivitetDto(PeriodeDto periode, ArbeidTypeDto arbeidType) {
        this.periode = periode;
        this.arbeidTypeDto = arbeidType;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public ArbeidTypeDto getArbeidTypeDto() {
        return arbeidTypeDto;
    }
}
