package no.nav.foreldrepenger.kontrakter.formidling.v3;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMal;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.RevurderingÅrsak;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.Saksnummer;

import java.util.UUID;

/**
 * Brukes for forhåndsvisning av brev.
 * @param behandlingUuid referanse til behandling det skal sendes brev for.
 * @param dokumentMal dokument mal som skal brukes til å forhåndsvise brevet.
 * @param tittel Tittel/overskrift i brevet, gjelder fritekst
 * @param fritekst Fritekst innhold i brevet, gjelder fritekst
 * @param revurderingÅrsak brukes kun om VARSEL_OM_REVURDERING er valgt.
 * @param fritekst kun brev som har eller er fritekst, dvs INNHENTE_OPPLYSNINGER og VARSEL_OM_REVURDERING om årsak ANNET er valgt, brødtekst i FRITEKSTBREV eller html i FRITEKSTBREV_HTML
 * @param tittel tittel i FRITEKSTBREV eller FRITEKSTBREV_HTML dokumentet. Kun om FRITEKSTBREV eller FRITEKSTBREV_HTML mal brukes.
 */
public record DokumentForhåndsvisDto(@NotNull @Valid UUID behandlingUuid,
                                     @NotNull @Valid Saksnummer saksnummer,
                                     @NotNull @Valid DokumentMal dokumentMal,
                                     @Valid RevurderingÅrsak revurderingÅrsak,
                                     String tittel,
                                     String fritekst) {

}
