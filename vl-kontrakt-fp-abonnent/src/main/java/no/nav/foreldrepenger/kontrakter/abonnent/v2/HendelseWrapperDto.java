package no.nav.foreldrepenger.kontrakter.abonnent.v2;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class HendelseWrapperDto {

    @NotNull @Valid
    private HendelseDto hendelse;

    public HendelseWrapperDto() { // NOSONAR
        // Jackson
    }
    
    public HendelseWrapperDto(@Valid HendelseDto hendelse) {
        this.hendelse = hendelse;
    }
    
    public HendelseDto getHendelse() {
        return hendelse;
    }

    public List<String> getAlleAktørId() {
        return hendelse != null ? hendelse.getAlleAktørId() : Collections.emptyList();
    }
}
