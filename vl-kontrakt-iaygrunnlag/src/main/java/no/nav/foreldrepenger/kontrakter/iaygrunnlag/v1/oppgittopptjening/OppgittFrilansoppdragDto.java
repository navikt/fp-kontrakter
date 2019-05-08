package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.ALWAYS)
public class OppgittFrilansoppdragDto {
    
    @JsonProperty(value="periode", required = true)
    @NotNull
    @Valid
    private PeriodeDto periode;
    
    @JsonProperty(value="oppdragsgiver")
    @Pattern(regexp = "^[\\p{L}\\p{N}.- ]+$")
    private String oppdragsgiver;

    protected OppgittFrilansoppdragDto() {
    }

    public OppgittFrilansoppdragDto(PeriodeDto periode, String oppdragsgiver) {
        this.periode = periode;
        this.oppdragsgiver = oppdragsgiver;
    }

    public String getOppdragsgiver() {
        return oppdragsgiver;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }
}
