package no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1;

import java.util.List;
import java.util.Objects;

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
public class OppgittFrilansDto {
    
    @JsonProperty(value="harInntektFraFosterhjem")
    private Boolean harInntektFraFosterhjem;
    
    @JsonProperty(value="erNyoppstartet")
    private Boolean erNyoppstartet;
    
    @JsonProperty(value="erNærRelasjon")
    private Boolean erNærRelasjon;
    
    @JsonProperty(value="frilansoppdrag")
    @NotNull
    @Valid
    private List<OppgittFrilansoppdragDto> frilansoppdrag;

    protected OppgittFrilansDto() {
    }
    
    public OppgittFrilansDto(List<OppgittFrilansoppdragDto> frilansoppdrag) {
        Objects.requireNonNull(frilansoppdrag, "frilansoppdrag");
        this.frilansoppdrag = frilansoppdrag;
    }

    public Boolean isHarInntektFraFosterhjem() {
        return harInntektFraFosterhjem;
    }

    public void setHarInntektFraFosterhjem(boolean harInntektFraFosterhjem) {
        this.harInntektFraFosterhjem = harInntektFraFosterhjem;
    }

    public OppgittFrilansDto medHarInntektFraFosterhjem(boolean harInntektFraFosterhjem) {
        setHarInntektFraFosterhjem(harInntektFraFosterhjem);
        return this;
    }

    public Boolean isErNyoppstartet() {
        return erNyoppstartet;
    }

    public void setErNyoppstartet(boolean erNyoppstartet) {
        this.erNyoppstartet = erNyoppstartet;
    }
    
    public OppgittFrilansDto medErNyoppstartet(boolean erNyoppstartet) {
        setErNyoppstartet(erNyoppstartet);
        return this;
    }

    public Boolean isHarNærRelasjon() {
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
}
