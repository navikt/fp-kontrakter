package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Aktør;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektsKildeDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.ALWAYS)
public class UtbetalingDto {

    @JsonProperty(value = "arbeidsgiver", required = true)
    @NotNull
    @Valid
    private Aktør arbeidsgiver;

    @JsonProperty(value = "inntektsKilde", required = true)
    @NotNull
    @Valid
    private InntektsKildeDto kilde;

    @JsonProperty(value = "utbetalingsPoster", required = true)
    @NotNull
    @Valid
    private List<UtbetalingsPostDto> poster;

    protected UtbetalingDto() {
        // default ctor
    }

    public UtbetalingDto(Aktør arbeidsgiver) {
        this.arbeidsgiver = arbeidsgiver;
    }

    public Aktør getUtbetaler() {
        return arbeidsgiver;
    }

    public InntektsKildeDto getKilde() {
        return kilde;
    }

    public void setKilde(InntektsKildeDto kilde) {
        this.kilde = kilde;
    }

    public UtbetalingDto medKilde(InntektsKildeDto kilde) {
        setKilde(kilde);
        return this;
    }
    
    public UtbetalingDto medKilde(String inntektsKilde) {
        setKilde(new InntektsKildeDto(inntektsKilde));
        return this;
    }

    public List<UtbetalingsPostDto> getPoster() {
        return poster;
    }

    public void setPoster(List<UtbetalingsPostDto> poster) {
        this.poster = poster;
    }

    public UtbetalingDto medPoster(List<UtbetalingsPostDto> poster) {
        setPoster(poster);
        return this;
    }
}
