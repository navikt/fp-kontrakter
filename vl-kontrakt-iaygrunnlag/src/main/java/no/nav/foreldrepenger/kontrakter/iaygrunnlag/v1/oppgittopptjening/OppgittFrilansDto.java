package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.ALWAYS)
public class OppgittFrilansDto {
    
    @JsonProperty(value="harInntektFraFosterhjem")
    private boolean harInntektFraFosterhjem;
    
    @JsonProperty(value="erNyoppstartet")
    private boolean erNyoppstartet;
    
    @JsonProperty(value="erNærRelasjon")
    private boolean erNærRelasjon;
    
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

    public boolean isErNyoppstartet() {
        return erNyoppstartet;
    }

    public void setErNyoppstartet(boolean erNyoppstartet) {
        this.erNyoppstartet = erNyoppstartet;
    }

    public boolean isHarNærRelasjon() {
        return erNærRelasjon;
    }

    public void setHarNærRelasjon(boolean harNærRelasjon) {
        this.erNærRelasjon = harNærRelasjon;
    }

    public List<OppgittFrilansoppdragDto> getFrilansoppdrag() {
        return frilansoppdrag;
    }

    public void setFrilansoppdrag(List<OppgittFrilansoppdragDto> frilansoppdrag) {
        this.frilansoppdrag = frilansoppdrag;
    }
}
