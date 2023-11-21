package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SakInfoV2Dto(@NotNull @Valid SaksnummerDto saksnummer,
                           @NotNull @Valid YtelseTypeDto ytelseType,
                           @NotNull LocalDate opprettetDato,
                           @NotNull @Valid FagsakStatusDto status,
                           @Valid FamiliehendelseInfoDto familiehendelseInfoDto,
                           LocalDate førsteUttaksdato) {
    public record FamiliehendelseInfoDto(LocalDate familiehendelseDato,
                                         @Valid FamilieHendelseTypeDto familihendelseType) {
    }

    public enum FagsakStatusDto {
        UNDER_BEHANDLING,
        LØPENDE,
        AVSLUTTET
    }

    public enum FamilieHendelseTypeDto {
        FØDSEL,
        TERMIN,
        ADOPSJON,
        OMSORG
    }
}

