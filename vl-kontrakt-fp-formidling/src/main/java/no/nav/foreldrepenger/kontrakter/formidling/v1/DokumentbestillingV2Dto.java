package no.nav.foreldrepenger.kontrakter.formidling.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.HistorikkAktør;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.YtelseType;

/*
 * Til bruk for bestilling fra backend.
 * Vurder å fjerne behandlendeenhetnavn når vi ikke lenger sender brev for Klageinstansen
 *
 * Det er mulig å utvide denne med flere elementer slik at den kan brukes ifm forhåndsvisning fra frontend
 * - frontend bør generere uiid for bestilling
 * - vedtaksbrev: frontend sender pr konvensjon AUTOMATISK eller ingenting -> bruk boolean og se opp mot gjelderVedtak
 */
public record DokumentbestillingV2Dto(@NotNull UUID behandlingUuid,
                                      @NotNull UUID dokumentbestillingUuid,
                                      @NotNull @Valid YtelseType ytelseType,
                                      @NotNull @Valid HistorikkAktør historikkAktør,
                                      @NotNull @Pattern(regexp = "[A-Z]{6}") String dokumentMal,
                                      String fritekst,
                                      @Pattern(regexp = "[A-ZÆØÅ0-9]{1,100}") String behandlendeEnhetNavn,
                                      @Pattern(regexp = "[A-ZÆØÅ0-9]{1,100}") String arsakskode) {
}


