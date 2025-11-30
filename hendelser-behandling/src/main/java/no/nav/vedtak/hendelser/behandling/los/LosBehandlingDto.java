package no.nav.vedtak.hendelser.behandling.los;

import jakarta.validation.constraints.NotNull;
import no.nav.vedtak.hendelser.behandling.Aksjonspunktstatus;
import no.nav.vedtak.hendelser.behandling.AktørId;
import no.nav.vedtak.hendelser.behandling.Behandlingsstatus;
import no.nav.vedtak.hendelser.behandling.Behandlingstype;
import no.nav.vedtak.hendelser.behandling.Behandlingsårsak;
import no.nav.vedtak.hendelser.behandling.Kildesystem;
import no.nav.vedtak.hendelser.behandling.Ytelse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record LosBehandlingDto(@NotNull UUID behandlingUuid,
                               @NotNull Kildesystem kildesystem,
                               @NotNull String saksnummer,
                               @NotNull Ytelse ytelse,
                               @NotNull AktørId aktørId,
                               @NotNull Behandlingstype behandlingstype,
                               @NotNull Behandlingsstatus behandlingsstatus,
                               @NotNull LocalDateTime opprettetTidspunkt,
                               String behandlendeEnhetId,
                               LocalDate behandlingsfrist,
                               String ansvarligSaksbehandlerIdent,
                               List<LosAksjonspunktDto> aksjonspunkt,
                               List<Behandlingsårsak> behandlingsårsaker,
                               boolean faresignaler,
                               boolean refusjonskrav,
                               // Inntil fagsak-merkingen er stabil - konverter til kontrakt-enum senere
                               // Foreløpig: NASJONAL, EØS_BOSATT_NORGE, BOSATT_UTLAND, SAMMENSATT_KONTROLL, DØD, NÆRING, PRAKSIS_UTSETTELSE
                               // Potensielle nye merker: BARE_FAR_RETT, GRUPPE2
                               List<String> saksegenskaper,
                               LosForeldrepengerDto foreldrepengerDto,
                               // Inntil kriteriene er stabil - konverter til kontrakt-enum senere
                               // Foreløpig: SYKDOMSVURDERING, FARESIGNALER, DIREKTE_UTBETALING, REFUSJONSKRAV
                               // Flyttes til saksegenskap: BARE_FAR_RETT
                               List<String> behandlingsegenskaper,
                               LosTilbakeDto tilbakeDto) {


    public record LosAksjonspunktDto(String definisjon, Aksjonspunktstatus status, LocalDateTime fristTid) { }

    public record LosForeldrepengerDto(LocalDate førsteUttakDato) { }

    public record LosTilbakeDto(BigDecimal feilutbetaltBeløp, LocalDate førsteFeilutbetalingDato) { }

}