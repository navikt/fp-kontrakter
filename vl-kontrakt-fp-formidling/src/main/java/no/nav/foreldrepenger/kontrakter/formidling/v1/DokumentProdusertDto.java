package no.nav.foreldrepenger.kontrakter.formidling.v1;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.HistorikkAktør;

public record DokumentProdusertDto(@NotNull UUID behandlingUuid,
                                   @NotNull UUID dokumentbestillingUuid,
                                   @Valid HistorikkAktør historikkAktør,
                                   @NotNull @Pattern(regexp = "[A-Z]{6}") String dokumentMal,
                                   @NotNull @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$") String journalpostId,
                                   @NotNull String dokumentId,
                                   @NotNull LocalDateTime opprettetTidspunkt) {



}
