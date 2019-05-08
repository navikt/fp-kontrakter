package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.Aktør;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArbeidsgiverDto {

    @JsonProperty(value = "arbeidsgiver", required = true, index = 1)
    @NotNull
    @Valid
    private Aktør arbeidsgiver;

    protected ArbeidsgiverDto() {
        // default ctor for deserialisering
    }

    public ArbeidsgiverDto(Aktør arbeidsgiver) {
        this.arbeidsgiver = arbeidsgiver;
    }

    public Aktør getArbeidsgiver() {
        return arbeidsgiver;
    }
}
