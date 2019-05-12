package no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.ALWAYS)
public class OppgittFrilansoppdragDto {
    
    @JsonProperty(value="periode", required = true)
    @NotNull
    @Valid
    private Periode periode;
    
    @JsonProperty(value="oppdragsgiver", required = true)
    @Pattern(regexp = "^[\\p{L}\\p{N}\\.\\- ]+$")
    @NotNull
    private String oppdragsgiver;

    protected OppgittFrilansoppdragDto() {
    }

    public OppgittFrilansoppdragDto(Periode periode, String oppdragsgiver) {
        Objects.requireNonNull(periode, "periode");
        this.periode = periode;
        this.oppdragsgiver = oppdragsgiver;
    }

    public String getOppdragsgiver() {
        return oppdragsgiver;
    }

    public Periode getPeriode() {
        return periode;
    }
}