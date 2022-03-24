package no.nav.foreldrepenger.kontrakter.formidling.v3;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMal;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.RevurderingÅrsak;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.YtelseType;

/*
 * Til bruk for bestilling fra backend.
 * Vurder å fjerne behandlendeenhetnavn når vi ikke lenger sender brev for Klageinstansen. Evt hent fra Behandling ...
 *
 * Det er mulig å utvide denne med flere elementer slik at den kan brukes ifm forhåndsvisning fra frontend
 * - legg på ekstra Ctor for format som brukes ved normal bestilling fra fpsak
 * - frontend bør generere uuid for bestilling
 * - frontend bruker modernisert bestilling - 4 felt fom automatiskVedtaksbrev
 */
public record DokumentBestillingDto(@NotNull @Valid UUID behandlingUuid,
                                    @NotNull @Valid UUID dokumentbestillingUuid,
                                    @NotNull @Valid YtelseType ytelseType,
                                    @NotNull @Valid DokumentMal dokumentMal,
                                    String fritekst,
                                    @Pattern(regexp = "[a-zA-ZæøåÆØÅ :,.\\-0-9]{1,100}") String behandlendeEnhetNavn,
                                    @Valid RevurderingÅrsak arsakskode) {
}


