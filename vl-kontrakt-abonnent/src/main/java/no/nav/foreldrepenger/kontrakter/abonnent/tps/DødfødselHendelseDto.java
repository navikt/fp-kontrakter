package no.nav.foreldrepenger.kontrakter.abonnent.tps;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import no.nav.foreldrepenger.kontrakter.abonnent.HendelseDto;

public class DødfødselHendelseDto extends HendelseDto {

    public static final String HENDELSE_TYPE = "DØDFØDSEL";
    public static final String AVSENDER = "tps";

    @NotNull
    @Size(min = 1)
    private List<String> aktørId;

    @NotNull
    private LocalDate dødfødselsdato;

    public void setAktørId(List<String> aktørId) {
        this.aktørId = aktørId;
    }

    public List<String> getAktørId() {
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
    public String getAvsenderSystem() {
        return AVSENDER;
    }

    @Override
    public List<String> getAlleAktørId() {
        return Collections.unmodifiableList(aktørId);
    }
}
