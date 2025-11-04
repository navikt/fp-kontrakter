package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.felles.typer.Saksnummer;

import java.time.LocalDateTime;
import java.util.Objects;

public record EsSak(@NotNull Saksnummer saksnummer,
                    @NotNull Familiehendelse familiehendelse,
                    boolean sakAvsluttet,
                    EsÅpenBehandling åpenBehandling,
                    boolean gjelderAdopsjon,
                    @NotNull LocalDateTime oppdatertTidspunkt) implements Sak {

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EsSak esSak = (EsSak) o;
        return sakAvsluttet == esSak.sakAvsluttet && gjelderAdopsjon == esSak.gjelderAdopsjon && Objects.equals(saksnummer,
                esSak.saksnummer) && Objects.equals(familiehendelse, esSak.familiehendelse) && Objects.equals(åpenBehandling,
                esSak.åpenBehandling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saksnummer, familiehendelse, sakAvsluttet, åpenBehandling, gjelderAdopsjon);
    }
}
