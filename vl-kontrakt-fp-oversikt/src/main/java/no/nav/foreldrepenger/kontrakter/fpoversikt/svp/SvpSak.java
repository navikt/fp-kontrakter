package no.nav.foreldrepenger.kontrakter.fpoversikt.svp;

import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.felles.typer.Saksnummer;
import no.nav.foreldrepenger.kontrakter.fpoversikt.Familiehendelse;
import no.nav.foreldrepenger.kontrakter.fpoversikt.Sak;

import java.time.LocalDateTime;

public record SvpSak(@NotNull Saksnummer saksnummer,
                     @NotNull Familiehendelse familiehendelse,
                     @NotNull boolean sakAvsluttet,
                     SvpÅpenBehandling åpenBehandling,
                     Vedtak gjeldendeVedtak,
                     @NotNull LocalDateTime oppdatertTidspunkt) implements Sak {
}
