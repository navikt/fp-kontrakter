package no.nav.foreldrepenger.kontrakter.formidling.v3;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.Saksnummer;

import java.util.UUID;

/**
 * Brukes til å kvittere tilbake til bestilleren at brevet ble produsert, journalført og distribuert.
 * @param behandlingUuid - referanse til behandling det ble bestillt brev for.
 * @param dokumentbestillingUuid - en unik bestillings id som ble brukt ved bestilling.
 * @param journalpostId - journalpost id hvor brevet er arkivert.
 * @param dokumentId - dokument id som identifiserer dokumentet i journalposten.
 */
public record DokumentKvitteringDto(@NotNull @Valid UUID behandlingUuid,
                                    @Valid Saksnummer saksnummer,
                                    @NotNull @Valid UUID dokumentbestillingUuid,
                                    @NotNull @Pattern(regexp = "^[\\p{L}\\p{N}_.\\-]+$") String journalpostId,
                                    @NotNull @Digits(integer = 12, fraction = 0) String dokumentId) {

}
