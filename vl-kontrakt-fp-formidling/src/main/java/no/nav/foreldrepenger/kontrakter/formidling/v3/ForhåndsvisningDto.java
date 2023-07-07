package no.nav.foreldrepenger.kontrakter.formidling.v3;

import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMal;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.RevurderingÅrsak;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.YtelseType;

/**
 * Erstatter den opprinelige DokumentbestillingDto
 * @param behandlingUuid ID til Behandlingen i fpsak det bestilles dokument for
 * @param ytelseType Kode for ytelsetype (ES, FP, SVP)
 * @param dokumentMal Kode for hvilket dokument som er bestilt.
 *                    Se i DokumentMalType.java her  https://github.com/navikt/fp-formidling/ ror gyldige verdier
 * @param tittel Tittel/overskrift i brevet, gjelder fritekst
 * @param fritekst Fritekst innhold i brevet, gjelder fritekst
 * @param arsakskode Revurderingsårsak fra kodeverk
 * @param automatiskVedtaksbrev Er det automatisk brev?
 * @param gjelderVedtak Gjelder det vedtak?
 * @param erOpphevetKlage Er klage opphevet? Kun klage.
 */
public record ForhåndsvisningDto(@NotNull @Valid UUID behandlingUuid,
                                 @NotNull @Valid YtelseType ytelseType,
                                 @Valid DokumentMal dokumentMal,
                                 @Valid RevurderingÅrsak arsakskode,
                                 String tittel,
                                 String fritekst,
                                 boolean automatiskVedtaksbrev,
                                 boolean gjelderVedtak,
                                 boolean erOpphevetKlage) {

}
