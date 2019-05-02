package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse;

import java.util.List;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.FagsystemDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.RelatertYtelseTilstandDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.RelatertYtelseTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class YtelseDto {

    private FagsystemDto fagsystemDto;
    private RelatertYtelseTypeDto type;
    private String saksnummer;
    private PeriodeDto periode;
    private RelatertYtelseTilstandDto status;
    private List<AnvisningDto> anvisninger;
    private YtelseGrunnlagDto grunnlag;

    public YtelseDto() {
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

    public void setFagsystemDto(FagsystemDto fagsystemDto) {
        this.fagsystemDto = fagsystemDto;
    }

    public RelatertYtelseTypeDto getType() {
        return type;
    }

    public void setType(RelatertYtelseTypeDto type) {
        this.type = type;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public void setSaksnummer(String saksnummer) {
        this.saksnummer = saksnummer;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public RelatertYtelseTilstandDto getStatus() {
        return status;
    }

    public void setStatus(RelatertYtelseTilstandDto status) {
        this.status = status;
    }
}
