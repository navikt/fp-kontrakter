package no.nav.foreldrepenger.kontrakter.formidling.v3;

import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.DokumentMal;

/**
 * Brukes til å kvittere tilbake til bestilleren at brevet ble produsert, journalført og distribuert.
 * @param behandlingUuid - referanse til behandling det ble bestillt brev for.
 * @param dokumentbestillingUuid - en unik bestillings id som ble brukt ved bestilling.
 * @param dokumentMal - dokument mal som ble brukt i bestillingen.
 * @param journalpostId - journalpost id hvor brevet er arkivert.
 * @param dokumentId - dokument id som identifiserer dokumentet i journalposten.
 */
public record DokumentKvitteringDto(@NotNull @Valid UUID behandlingUuid,
                                    @NotNull @Valid UUID dokumentbestillingUuid,
                                    @NotNull @Valid DokumentMal dokumentMal,
                                    @NotNull @Pattern(regexp = "^[\\p{L}\\p{N}_.\\-]+$") String journalpostId,
                                    @NotNull @Digits(integer = 12, fraction = 0) String dokumentId) {

}
