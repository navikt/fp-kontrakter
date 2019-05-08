package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.inntektsmelding;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.UtsettelseÅrsakDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.ALWAYS)
public class UtsettelsePeriodeDto {
    
    @JsonProperty(value = "periode", required = true)
    @Valid
    @NotNull
    private PeriodeDto periode;
    
    @JsonProperty(value = "utsettelseÅrsak")
    @Valid
    private UtsettelseÅrsakDto utsettelseÅrsakDto;

    public UtsettelsePeriodeDto() {
    }
    
    public UtsettelsePeriodeDto(PeriodeDto periode) {
        this.periode = periode;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public UtsettelseÅrsakDto getUtsettelseÅrsakDto() {
        return utsettelseÅrsakDto;
    }

    public void setUtsettelseÅrsakDto(UtsettelseÅrsakDto utsettelseÅrsakDto) {
        this.utsettelseÅrsakDto = utsettelseÅrsakDto;
    }
    
    public UtsettelsePeriodeDto medUtsettelseÅrsak(UtsettelseÅrsakDto utsettelseÅrsakDto) {
        this.utsettelseÅrsakDto = utsettelseÅrsakDto;
        return this;
    }
}
