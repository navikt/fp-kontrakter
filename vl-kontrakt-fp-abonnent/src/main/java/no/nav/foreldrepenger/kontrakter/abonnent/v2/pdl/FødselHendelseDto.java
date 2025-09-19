package no.nav.foreldrepenger.kontrakter.abonnent.v2.pdl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import no.nav.foreldrepenger.kontrakter.abonnent.v2.AktørIdDto;
import no.nav.foreldrepenger.kontrakter.abonnent.v2.HendelseDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FødselHendelseDto extends HendelseDto {

    public static final String HENDELSE_TYPE = "FØDSEL";

    @NotNull
    @Size(min = 1)
    private List<AktørIdDto> aktørIdForeldre;

    @Valid
    private LocalDate fødselsdato;

    public void setAktørIdForeldre(List<AktørIdDto> aktørIdForeldre) {
        this.aktørIdForeldre = aktørIdForeldre;
    }

    public List<AktørIdDto> getAktørIdForeldre() {
        return this.aktørIdForeldre;
    }

    public void setFødselsdato(LocalDate fødselsdato) {
        this.fødselsdato = fødselsdato;
    }

    public LocalDate getFødselsdato() {
        return fødselsdato;
    }

    @Override
    public String getHendelsetype() {
        return HENDELSE_TYPE;
    }

    @Override
    public List<String> getAlleAktørId() {
        return aktørIdForeldre.stream().map(AktørIdDto::getAktørId).collect(Collectors.toList());
    }
}
