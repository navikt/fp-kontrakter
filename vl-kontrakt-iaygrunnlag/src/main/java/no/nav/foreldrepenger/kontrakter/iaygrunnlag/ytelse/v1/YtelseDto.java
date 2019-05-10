package no.nav.foreldrepenger.kontrakter.iaygrunnlag.ytelse.v1;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.Fagsystem;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseStatus;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class YtelseDto {

    @JsonProperty(value = "fagsystem", required = true)
    @Valid
    @NotNull
    private Fagsystem fagsystem;

    @JsonProperty(value = "ytelseType", required = true)
    @Valid
    @NotNull
    private YtelseType type;

    @JsonProperty(value = "saksnummer", required = true)
    @Valid
    @NotNull
    private String saksnummer;

    @JsonProperty(value = "periode", required = true)
    @Valid
    @NotNull
    private Periode periode;

    @JsonProperty(value = "status", required = true)
    @Valid
    @NotNull
    private YtelseStatus status;

    @JsonProperty(value = "anvisninger")
    @Valid
    private List<AnvisningDto> anvisninger;

    @JsonProperty(value = "ytelseGrunnlag")
    @Valid
    private YtelseGrunnlagDto grunnlag;

    protected YtelseDto() {
    }

    public YtelseDto(Fagsystem fagsystemDto, YtelseType type, Periode periode, YtelseStatus status, String saksnummer) {
        this.fagsystem = fagsystemDto;
        this.type = type;
        this.periode = periode;
        this.status = status;
        this.saksnummer = saksnummer;
    }

    public List<AnvisningDto> getAnvisninger() {
        return anvisninger;
    }

    public void setAnvisninger(List<AnvisningDto> anvisninger) {
        this.anvisninger = anvisninger;
    }

    public YtelseDto medAnvisninger(List<AnvisningDto> anvisninger) {
        this.anvisninger = anvisninger;
        return this;
    }

    public YtelseGrunnlagDto getGrunnlag() {
        return grunnlag;
    }

    public void setGrunnlag(YtelseGrunnlagDto grunnlag) {
        this.grunnlag = grunnlag;
    }

    public YtelseDto medGrunnlag(YtelseGrunnlagDto grunnlag) {
        this.grunnlag = grunnlag;
        return this;
    }

    public Fagsystem getFagsystemDto() {
        return fagsystem;
    }

    public YtelseType getType() {
        return type;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public Periode getPeriode() {
        return periode;
    }

    public YtelseStatus getStatus() {
        return status;
    }

}
