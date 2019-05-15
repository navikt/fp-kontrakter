package no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.ALWAYS)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class OppgittArbeidsforholdDto {

    @JsonProperty(value = "periode", required = true)
    @Valid
    @NotNull
    private Periode periode;

    @JsonProperty(value = "arbeidType", required = true)
    @Valid
    @NotNull
    private ArbeidType arbeidTypeDto;

    @JsonProperty(value = "erUtenlandskInntekt")
    private Boolean erUtenlandskInntekt;

    @JsonProperty(value = "utenlandskVirksomhet")
    @Valid
    private OppgittUtenlandskVirksomhetDto utenlandskVirksomhet;

    @JsonCreator
    public OppgittArbeidsforholdDto(@JsonProperty(value = "periode", required = true) Periode periode,
                                    @JsonProperty(value = "arbeidType", required = true) ArbeidType arbeidType) {
        Objects.requireNonNull(periode, "periode");
        Objects.requireNonNull(arbeidType, "arbeidType");
        this.periode = periode;
        this.arbeidTypeDto = arbeidType;
    }

    protected OppgittArbeidsforholdDto() {
        // default ctor
    }

    public Periode getPeriode() {
        return periode;
    }

    public Boolean isErUtenlandskInntekt() {
        return erUtenlandskInntekt;
    }

    public void setErUtenlandskInntekt(boolean erUtenlandskInntekt) {
        this.erUtenlandskInntekt = erUtenlandskInntekt;
    }

    public OppgittArbeidsforholdDto medErUtenlandskInntekt(boolean erUtenlandskInntekt) {
        setErUtenlandskInntekt(erUtenlandskInntekt);
        return this;
    }

    public ArbeidType getArbeidTypeDto() {
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
