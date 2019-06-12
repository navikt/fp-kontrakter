package no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntekt.v1;

import java.util.List;
import java.util.Objects;

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

    /** Arbeidsgiver for utbetaling. Kan være null . */
    @JsonProperty(value = "arbeidsgiver")
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

    public UtbetalingDto(InntektskildeType kilde) {
        this.kilde = Objects.requireNonNull(kilde, "kilde");
    }

    public UtbetalingDto(String kilde) {
        this(new InntektskildeType(Objects.requireNonNull(kilde, "kilde")));
    }

    public Aktør getUtbetaler() {
        return arbeidsgiver;
    }

    public InntektskildeType getKilde() {
        return kilde;
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

    public void setArbeidsgiver(Aktør arbeidsgiver) {
        this.arbeidsgiver = arbeidsgiver;
    }

    public UtbetalingDto medArbeidsgiver(Aktør arbeidgiver) {
        setArbeidsgiver(arbeidgiver);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        var other = this.getClass().cast(obj);

        return Objects.equals(this.kilde, other.kilde)
            && Objects.equals(arbeidsgiver, other.arbeidsgiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kilde, arbeidsgiver);
    }
}
