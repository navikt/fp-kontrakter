package no.nav.foreldrepenger.kontrakter.abonnent.v2.pdl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import no.nav.foreldrepenger.kontrakter.abonnent.v2.AktørIdDto;
import no.nav.foreldrepenger.kontrakter.abonnent.v2.HendelseDto;

public class DødHendelseDto extends HendelseDto {

    public static final String HENDELSE_TYPE = "DØD";
    public static final String AVSENDER = "PDL";

    @NotNull
    @Size(min = 1)
    private List<AktørIdDto> aktørId;

    @Valid
    private LocalDate dødsdato;

    public void setAktørId(List<AktørIdDto> aktørId) {
        this.aktørId = aktørId;
    }

    public List<AktørIdDto> getAktørId() {
        return this.aktørId;
    }

    public void setDødsdato(LocalDate dødsdato) {
        this.dødsdato = dødsdato;
    }

    public LocalDate getDødsdato() {
        return dødsdato;
    }

    @Override
    public String getHendelsetype() {
        return HENDELSE_TYPE;
    }

    @Override
    public String getAvsenderSystem() {
        return AVSENDER;
    }

    @Override
    public List<String> getAlleAktørId() {
        return aktørId.stream().map(AktørIdDto::getAktørId).collect(Collectors.toList());
    }
}
