package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.FagsystemDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.RelatertYtelseTilstandDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.RelatertYtelseTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class YtelseDto {

    @JsonProperty(value="fagsystem", required=true)
    @Valid
    @NotNull
    private FagsystemDto fagsystemDto;
    
    @JsonProperty(value="ytelseType", required=true)
    @Valid
    @NotNull
    private RelatertYtelseTypeDto type;
    
    @JsonProperty(value="saksnummer", required=true)
    @Valid
    @NotNull
    private String saksnummer;
    
    @JsonProperty(value="periode", required=true)
    @Valid
    @NotNull
    private PeriodeDto periode;
    
    @JsonProperty(value="status", required=true)
    @Valid
    @NotNull
    private RelatertYtelseTilstandDto status;
    
    @JsonProperty(value="anvisninger")
    @Valid
    private List<AnvisningDto> anvisninger;
    
    @JsonProperty(value="ytelseGrunnlag")
    @Valid
    private YtelseGrunnlagDto grunnlag;

    protected YtelseDto() {
    }
    

    public YtelseDto(FagsystemDto fagsystemDto, RelatertYtelseTypeDto type, PeriodeDto periode, RelatertYtelseTilstandDto status, String saksnummer) {
        this.fagsystemDto = fagsystemDto;
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

    public YtelseGrunnlagDto getGrunnlag() {
        return grunnlag;
    }

    public void setGrunnlag(YtelseGrunnlagDto grunnlag) {
        this.grunnlag = grunnlag;
    }

    public FagsystemDto getFagsystemDto() {
        return fagsystemDto;
    }

    public RelatertYtelseTypeDto getType() {
        return type;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public RelatertYtelseTilstandDto getStatus() {
        return status;
    }

}
