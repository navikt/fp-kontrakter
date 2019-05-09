package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class OppgittFrilansDto {
    
    @JsonProperty(value="harInntektFraFosterhjem")
    private Boolean harInntektFraFosterhjem;
    
    @JsonProperty(value="erNyoppstartet")
    private Boolean erNyoppstartet;
    
    @JsonProperty(value="erNærRelasjon")
    private Boolean erNærRelasjon;
    
    @JsonProperty(value="frilansoppdrag")
    private List<OppgittFrilansoppdragDto> frilansoppdrag;

    public OppgittFrilansDto() {
    }

    public boolean isHarInntektFraFosterhjem() {
        return harInntektFraFosterhjem;
    }

    public void setHarInntektFraFosterhjem(boolean harInntektFraFosterhjem) {
        this.harInntektFraFosterhjem = harInntektFraFosterhjem;
    }

    public OppgittFrilansDto medHarInntektFraFosterhjem(boolean harInntektFraFosterhjem) {
        setHarInntektFraFosterhjem(harInntektFraFosterhjem);
        return this;
    }

    public boolean isErNyoppstartet() {
        return erNyoppstartet;
    }

    public void setErNyoppstartet(boolean erNyoppstartet) {
        this.erNyoppstartet = erNyoppstartet;
    }
    
    public OppgittFrilansDto medErNyoppstartet(boolean erNyoppstartet) {
        setErNyoppstartet(erNyoppstartet);
        return this;
    }

    public boolean isHarNærRelasjon() {
        return erNærRelasjon;
    }

    public void setHarNærRelasjon(boolean harNærRelasjon) {
        this.erNærRelasjon = harNærRelasjon;
    }
    
    public OppgittFrilansDto medHarNærRelasjon(boolean harNærRelasjon) {
        setHarNærRelasjon(harNærRelasjon);
        return this;
    }

    public List<OppgittFrilansoppdragDto> getFrilansoppdrag() {
        return frilansoppdrag;
    }

    public void setFrilansoppdrag(List<OppgittFrilansoppdragDto> frilansoppdrag) {
        this.frilansoppdrag = frilansoppdrag;
    }
    
    public OppgittFrilansDto medFrilansoppdrag(List<OppgittFrilansoppdragDto> frilansoppdrag) {
        setFrilansoppdrag(frilansoppdrag);
        return this;
    }
}
