package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.Periode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.ALWAYS)
public class OppgittArbeidsforholdDto {

    @JsonProperty(value = "periode", required = true)
    @Valid
    @NotNull
    private Periode periode;

    @JsonProperty(value = "arbeidType", required = true)
    @Valid
    @NotNull
    private ArbeidTypeDto arbeidTypeDto;

    @JsonProperty(value = "erUtenlandskInntekt")
    private Boolean erUtenlandskInntekt;

    @JsonProperty(value = "utenlandskVirksomhet")
    @Valid
    private OppgittUtenlandskVirksomhetDto utenlandskVirksomhet;

    protected OppgittArbeidsforholdDto(Periode periode, ArbeidTypeDto arbeidType) {
        Objects.requireNonNull(periode, "periode");
        Objects.requireNonNull(arbeidType, "arbeidType");
        this.periode = periode;
        this.arbeidTypeDto = arbeidType;
    }

    public OppgittArbeidsforholdDto() {
    }

    public Periode getPeriode() {
        return periode;
    }

    public boolean isErUtenlandskInntekt() {
        return erUtenlandskInntekt;
    }

    public void setErUtenlandskInntekt(boolean erUtenlandskInntekt) {
        this.erUtenlandskInntekt = erUtenlandskInntekt;
    }

    public OppgittArbeidsforholdDto medErUtenlandskInntekt(boolean erUtenlandskInntekt) {
        setErUtenlandskInntekt(erUtenlandskInntekt);
        return this;
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

    public OppgittArbeidsforholdDto medUtenlandskVirksomhet(OppgittUtenlandskVirksomhetDto utenlandskVirksomhet) {
        this.utenlandskVirksomhet = utenlandskVirksomhet;
        return this;
    }
}
