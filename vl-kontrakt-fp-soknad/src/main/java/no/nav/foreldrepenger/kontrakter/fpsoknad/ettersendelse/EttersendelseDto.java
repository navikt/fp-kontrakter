package no.nav.foreldrepenger.kontrakter.fpsoknad.ettersendelse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import no.nav.foreldrepenger.kontrakter.fpsoknad.Fødselsnummer;
import no.nav.foreldrepenger.kontrakter.fpsoknad.Saksnummer;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.VedleggDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record EttersendelseDto(LocalDateTime mottattdato,
                               @NotNull @Valid Saksnummer saksnummer,
                               @NotNull @Valid Fødselsnummer fnr,
                               @NotNull YtelseType type,
                               @Valid BrukerTekstDto brukerTekst,
                               @Valid @NotNull @Size(max = 40) List<@Valid VedleggDto> vedlegg) {

    public boolean erInnsendingAvUttalelseOmTilbakekreving() {
        return vedlegg().isEmpty() && brukerTekst() != null;
    }

    public EttersendelseDto {
        vedlegg = Optional.ofNullable(vedlegg).map(ArrayList::new).orElse(new ArrayList<>());
    }
}
