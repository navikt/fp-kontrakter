package no.nav.vedtak.hendelser.vtp.jsonforavro.leesah;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record LeesahHendelseVTP(@NotNull String hendelseId,
                                @NotNull @NotEmpty List<String> personidenter,
                                String master,
                                Instant opprettet,
                                @NotNull Opplysningstype opplysningstype,
                                @NotNull Endringstype endringstype,
                                String tidligereHendelseId,
                                @NotNull @Valid Hendelsedato hendelsedato)  {


    public static LeesahHendelseVTP opprettetFødsel(List<String> personidenter, LocalDate dato) {
        return standardOpprettet(personidenter, Opplysningstype.FOEDSEL_V1, dato);
    }

    public static LeesahHendelseVTP opprettetDød(List<String> personidenter, LocalDate dato) {
        return standardOpprettet(personidenter, Opplysningstype.DOEDSFALL_V1, dato);
    }

    public static LeesahHendelseVTP opprettetDødfødsel(List<String> personidenter, LocalDate dato) {
        return standardOpprettet(personidenter, Opplysningstype.DOEDFOEDT_BARN_V1, dato);
    }

    public static LeesahHendelseVTP opprettetUtflytting(List<String> personidenter, LocalDate dato) {
        return standardOpprettet(personidenter, Opplysningstype.UTFLYTTING_FRA_NORGE, dato);
    }

    private static LeesahHendelseVTP standardOpprettet(List<String> personidenter, Opplysningstype opplysningstype, LocalDate dato) {
        return new LeesahHendelseVTP(UUID.randomUUID().toString(), personidenter, "FREG",
            Instant.now(), opplysningstype, Endringstype.OPPRETTET, null, new Hendelsedato(dato));
    }

    // Generisk for DoedfoedtBarn/dato, Doedsfall/doedsdato, Foedsel/foedselsdato, UtflyttingFraNorge/utflyttingsdato
    public static record Hendelsedato(@NotNull LocalDate dato) {}

}
