package no.nav.foreldrepenger.kontrakter.abonnent.v2.pdl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import no.nav.foreldrepenger.kontrakter.abonnent.v2.AktørIdDto;
import no.nav.foreldrepenger.kontrakter.abonnent.v2.HendelseDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DødfødselHendelseDto extends HendelseDto {

    public static final String HENDELSE_TYPE = "DØDFØDSEL";
    @NotNull
    @Size(min = 1)
    private List<AktørIdDto> aktørId;

    @Valid
    private LocalDate dødfødselsdato;

    public void setAktørId(List<AktørIdDto> aktørId) {
        this.aktørId = aktørId;
    }

    public List<AktørIdDto> getAktørId() {
        return this.aktørId;
    }

    public void setDødfødselsdato(LocalDate dødfødselsdato) {
        this.dødfødselsdato = dødfødselsdato;
    }

    public LocalDate getDødfødselsdato() {
        return dødfødselsdato;
    }

    @Override
    public String getHendelsetype() {
        return HENDELSE_TYPE;
    }

    @Override
    public List<String> getAlleAktørId() {
        return aktørId.stream().map(AktørIdDto::getAktørId).collect(Collectors.toList());
    }
}
