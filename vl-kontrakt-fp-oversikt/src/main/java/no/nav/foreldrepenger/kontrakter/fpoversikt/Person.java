package no.nav.foreldrepenger.kontrakter.fpoversikt;


import no.nav.foreldrepenger.kontrakter.felles.typer.AktørId;
import no.nav.foreldrepenger.kontrakter.felles.typer.Fødselsnummer;

public record Person(Fødselsnummer fnr, AktørId aktørId) {
}
