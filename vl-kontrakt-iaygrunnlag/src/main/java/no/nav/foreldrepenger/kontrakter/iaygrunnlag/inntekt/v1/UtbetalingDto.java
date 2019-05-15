package no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntekt.v1;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Aktør;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektskildeType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.ALWAYS)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class UtbetalingDto {

    @JsonProperty(value = "arbeidsgiver", required = true)
    @NotNull
    @Valid
    private Aktør arbeidsgiver;

    @JsonProperty(value = "inntektsKilde", required = true)
    @NotNull
    @Valid
    private InntektskildeType kilde;

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

    public InntektskildeType getKilde() {
        return kilde;
    }

    public void setKilde(InntektskildeType kilde) {
        this.kilde = kilde;
    }

    public UtbetalingDto medKilde(InntektskildeType kilde) {
        setKilde(kilde);
        return this;
    }
    
    public UtbetalingDto medKilde(String inntektsKilde) {
        setKilde(new InntektskildeType(inntektsKilde));
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
