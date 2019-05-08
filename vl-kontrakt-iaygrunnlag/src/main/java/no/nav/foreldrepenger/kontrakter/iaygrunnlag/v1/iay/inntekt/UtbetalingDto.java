package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektsKildeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.ALWAYS)
public class UtbetalingDto {

    @JsonProperty("arbeidsgiver")
    @Valid
    private ArbeidsgiverDto utbetaler;
    
    @JsonProperty("inntektsKilde")
    @Valid
    private InntektsKildeDto kilde;
    
    @JsonProperty("utbetalingsPoster")
    @Valid
    private List<UtbetalingsPostDto> poster;

    protected UtbetalingDto() {
        // default ctor
    }
    
    public UtbetalingDto(ArbeidsgiverDto utbetaler) {
        this.utbetaler = utbetaler;
    }

    public ArbeidsgiverDto getUtbetaler() {
        return utbetaler;
    }

    public void setUtbetaler(ArbeidsgiverDto utbetaler) {
        this.utbetaler = utbetaler;
    }

    public InntektsKildeDto getKilde() {
        return kilde;
    }

    public void setKilde(InntektsKildeDto kilde) {
        this.kilde = kilde;
    }

    public List<UtbetalingsPostDto> getPoster() {
        return poster;
    }

    public void setPoster(List<UtbetalingsPostDto> poster) {
        this.poster = poster;
    }
}
