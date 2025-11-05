package no.nav.foreldrepenger.kontrakter.fpsoknad.ettersendelse;

import no.nav.foreldrepenger.kontrakter.felles.typer.Saksnummer;

public record TilbakebetalingUttalelseDto(YtelseType type, Saksnummer saksnummer, String dialogId, BrukerTekstDto brukerTekst) {
}
