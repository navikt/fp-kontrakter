package no.nav.foreldrepenger.kontrakter.formidling.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public record DokumentbestillingV2Dto(@NotNull UUID behandlingUuid,
                                      @NotNull UUID dokumentbestillingUuid,
                                      @NotNull @Valid YtelseType ytelseType,
                                      @NotNull @Pattern(regexp = "[A-Z]{6}") String dokumentMal,
                                      String fritekst,
                                      @Pattern(regexp = "[a-zA-ZæøåÆØÅ :,.\\-0-9]{1,100}") String behandlendeEnhetNavn,
                                      @Pattern(regexp = "[A-ZÆØÅ0-9]{1,100}") String arsakskode) {
}


