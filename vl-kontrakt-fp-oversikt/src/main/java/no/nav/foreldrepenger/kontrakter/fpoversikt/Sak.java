package no.nav.foreldrepenger.kontrakter.fpoversikt;

import no.nav.foreldrepenger.kontrakter.felles.typer.Saksnummer;

import java.time.LocalDateTime;

public interface Sak {

    Saksnummer saksnummer();

    Familiehendelse familiehendelse();

    boolean sakAvsluttet();

    LocalDateTime oppdatertTidspunkt();

}
