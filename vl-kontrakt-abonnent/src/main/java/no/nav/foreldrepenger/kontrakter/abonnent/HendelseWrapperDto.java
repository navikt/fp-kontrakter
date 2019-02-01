package no.nav.foreldrepenger.kontrakter.abonnent;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class HendelseWrapperDto {

    @NotNull @Valid
    private HendelseDto hendelse;

    public HendelseWrapperDto() {
        // for jackson
    }
    
    public HendelseWrapperDto(@Valid HendelseDto hendelse) {
        this.hendelse = hendelse;
    }
    
    /**
     * @deprecated bruk ctor i stedet
     */
    @Deprecated
    public static HendelseWrapperDto lagDto(@Valid HendelseDto hendelse) {
        HendelseWrapperDto dto = new HendelseWrapperDto();
        dto.hendelse = hendelse;
        return dto;
    }

    public HendelseDto getHendelse() {
        return hendelse;
    }

}
