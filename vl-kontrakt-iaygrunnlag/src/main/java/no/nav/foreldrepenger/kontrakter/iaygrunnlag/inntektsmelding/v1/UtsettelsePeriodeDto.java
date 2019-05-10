package no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.UtsettelseÅrsakDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.ALWAYS)
public class UtsettelsePeriodeDto {

    @JsonProperty(value = "periode", required = true)
    @Valid
    @NotNull
    private Periode periode;

    @JsonProperty(value = "utsettelseÅrsak")
    @Valid
    private UtsettelseÅrsakDto utsettelseÅrsak;

    protected UtsettelsePeriodeDto() {
    }

    public UtsettelsePeriodeDto(Periode periode) {
        this(periode, null);
    }

    public UtsettelsePeriodeDto(Periode periode, UtsettelseÅrsakDto utsettelseÅrsak) {
        Objects.requireNonNull(periode, "periode");
        this.periode = periode;
        this.utsettelseÅrsak = utsettelseÅrsak;
    }

    public Periode getPeriode() {
        return periode;
    }

    public UtsettelseÅrsakDto getUtsettelseÅrsakDto() {
        return utsettelseÅrsak;
    }

    public void setUtsettelseÅrsakDto(UtsettelseÅrsakDto utsettelseÅrsakDto) {
        this.utsettelseÅrsak = utsettelseÅrsakDto;
    }

    public UtsettelsePeriodeDto medUtsettelseÅrsak(UtsettelseÅrsakDto utsettelseÅrsakDto) {
        this.utsettelseÅrsak = utsettelseÅrsakDto;
        return this;
    }
}
