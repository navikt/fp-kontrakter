package no.nav.foreldrepenger.kontrakter.formidling.v3;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMal;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.RevurderingÅrsak;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.Saksnummer;

import java.util.UUID;

/**
 * Brukes for generering av html fra automatisk brev.
 * @param behandlingUuid referanse til behandling det skal sendes brev for.
 * @param dokumentMal dokument mal som skal brukes til å forhåndsvise brevet.
 * @param revurderingÅrsak brukes kun om VARSEL_OM_REVURDERING er valgt.
 */
public record DokumentBestillingHtmlDto(@NotNull @Valid UUID behandlingUuid,
                                        @NotNull @Valid Saksnummer saksnummer,
                                        @NotNull @Valid DokumentMal dokumentMal,
                                        @Valid RevurderingÅrsak revurderingÅrsak) {
}
