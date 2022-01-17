package no.nav.foreldrepenger.kontrakter.formidling.v1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.HistorikkAktør;

public record DokumentProdusertDto(@NotNull UUID behandlingUuid,
                                   @NotNull UUID historikkUuid,
                                   @Valid HistorikkAktør historikkAktør,
                                   @NotNull @Valid List<DokumentReferanseDto> dokumenter,
                                   @NotNull LocalDateTime opprettetTidspunkt) {



}
