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
 * @param saksnummer saksnummeret til fagsaken.
 * @param dokumentMal dokument mal som skal brukes til å generere brevet.
 * @param revurderingÅrsak valgfri årsak til revurdering, brukes for brevmaler som krever det (f.eks. VARSEL_OM_REVURDERING).
 * @param fritekst (VARSEL_OM_REVURDERING).
 */
public record DokumentBestillingHtmlDto(@NotNull @Valid UUID behandlingUuid,
                                        @NotNull @Valid Saksnummer saksnummer,
                                        @NotNull @Valid DokumentMal dokumentMal,
                                        @Valid RevurderingÅrsak revurderingÅrsak,
                                        String fritekst) {
}
