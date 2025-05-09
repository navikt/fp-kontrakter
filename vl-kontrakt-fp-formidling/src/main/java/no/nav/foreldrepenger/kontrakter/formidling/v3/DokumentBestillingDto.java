package no.nav.foreldrepenger.kontrakter.formidling.v3;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMal;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.RevurderingÅrsak;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.Saksnummer;

import java.util.UUID;

/**
 * Til bruk for bestilling av brev.
 * @param behandlingUuid referanse til behandling det skal sendes brev for.
 * @param dokumentbestillingUuid en unik bestillings id.
 * @param dokumentMal dokument mal som skal brukes til å produsere brev.
 * @param revurderingÅrsak brukes kun om VARSEL_OM_REVURDERING er valgt.
 * @param fritekst kun brev som ikke er vedtak og har fritekst, dvs INNHENTE_OPPLYSNINGER og VARSEL_OM_REVURDERING om årsak ANNET er valgt
 * @param journalførSom kun om dokumentMal FRITEKSTBREV og FRITEKSTBREV_HTML sendes - forklarer hva det opprinnelige automatiske brevet burde være.
 *                     Dette brukes i journalføring til å utlede riktig brev tittel som vises til bruker og saksbehandlere
 *                     f.eks i innsyn og gosys.
 */
public record DokumentBestillingDto(@NotNull @Valid UUID behandlingUuid,
                                    @NotNull @Valid Saksnummer saksnummer,
                                    @NotNull @Valid UUID dokumentbestillingUuid,
                                    @NotNull @Valid DokumentMal dokumentMal,
                                    @Valid RevurderingÅrsak revurderingÅrsak,
                                    String fritekst,
                                    @Valid DokumentMal journalførSom) {
}


