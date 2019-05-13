package no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.ALWAYS)
public class OppgittAnnenAktivitetDto {

    @JsonProperty(value = "periode", required = true)
    @Valid
    @NotNull
    private Periode periode;

    @JsonProperty(value = "arbeidType", required = true)
    @Valid
    @NotNull
    private ArbeidType arbeidTypeDto;

    @JsonCreator
    public OppgittAnnenAktivitetDto(@JsonProperty(value = "periode", required = true) @Valid @NotNull Periode periode,
                                    @JsonProperty(value = "arbeidType", required = true) @Valid @NotNull ArbeidType arbeidType) {
        Objects.requireNonNull(periode, "periode");
        Objects.requireNonNull(arbeidType, "arbeidType");
        this.periode = periode;
        this.arbeidTypeDto = arbeidType;
    }

    public Periode getPeriode() {
        return periode;
    }

    public ArbeidType getArbeidTypeDto() {
        return arbeidTypeDto;
    }
}
