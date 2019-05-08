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
@JsonInclude(value = Include.NON_ABSENT, content = Include.ALWAYS)
public class OppgittArbeidsforholdDto {
    
    @JsonProperty(value = "periode", required = true)
    @Valid
    @NotNull
    private PeriodeDto periode;
    
    @JsonProperty(value = "arbeidType", required = true)
    @Valid
    @NotNull
    private ArbeidTypeDto arbeidTypeDto;
    
    @JsonProperty(value = "erUtenlandskInntekt")
    private boolean erUtenlandskInntekt;

    @JsonProperty(value = "utenlandskVirksomhet")
    @Valid
    private OppgittUtenlandskVirksomhetDto utenlandskVirksomhet;

    protected OppgittArbeidsforholdDto(PeriodeDto periode, ArbeidTypeDto arbeidType) {
        this.periode = periode;
        this.arbeidTypeDto = arbeidType;
    }
    
    public OppgittArbeidsforholdDto() {
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public boolean isErUtenlandskInntekt() {
        return erUtenlandskInntekt;
    }

    public void setErUtenlandskInntekt(boolean erUtenlandskInntekt) {
        this.erUtenlandskInntekt = erUtenlandskInntekt;
    }

    public ArbeidTypeDto getArbeidTypeDto() {
        return arbeidTypeDto;
    }

    public OppgittUtenlandskVirksomhetDto getUtenlandskVirksomhet() {
        return utenlandskVirksomhet;
    }

    public void setUtenlandskVirksomhet(OppgittUtenlandskVirksomhetDto utenlandskVirksomhet) {
        this.utenlandskVirksomhet = utenlandskVirksomhet;
    }
    
    public OppgittArbeidsforholdDto medErUtenlandskInntekt(boolean erUtenlandskInntekt) {
        this.erUtenlandskInntekt = erUtenlandskInntekt;
        return this;
    }
    
    public OppgittArbeidsforholdDto medUtenlandskVirksomhet(OppgittUtenlandskVirksomhetDto utenlandskVirksomhet) {
        this.utenlandskVirksomhet = utenlandskVirksomhet;
        return this;
    }
}
