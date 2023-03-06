package no.nav.vedtak.hendelser.behandling.los;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import no.nav.vedtak.hendelser.behandling.Aksjonspunktstatus;
import no.nav.vedtak.hendelser.behandling.AktørId;
import no.nav.vedtak.hendelser.behandling.Behandlingsstatus;
import no.nav.vedtak.hendelser.behandling.Behandlingstype;
import no.nav.vedtak.hendelser.behandling.Behandlingsårsak;
import no.nav.vedtak.hendelser.behandling.Kildesystem;
import no.nav.vedtak.hendelser.behandling.Ytelse;

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
                               LosFagsakEgenskaperDto fagsakEgenskaper,
                               LosForeldrepengerDto foreldrepengerDto,
                               LosTilbakeDto tilbakeDto) {


    public record LosAksjonspunktDto(String definisjon, Aksjonspunktstatus status, String begrunnelse, LocalDateTime fristTid) {
    }

    public record LosForeldrepengerDto(LocalDate førsteUttakDato, boolean annenForelderRettEØS, boolean sykdomsvurdering, boolean gradering) {
    }

    public record LosTilbakeDto(BigDecimal feilutbetaltBeløp, LocalDate førsteFeilutbetalingDato) {
    }

}