package no.nav.vedtak.hendelser.behandling.v1;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.vedtak.hendelser.behandling.AktørId;
import no.nav.vedtak.hendelser.behandling.BehandlingHendelse;
import no.nav.vedtak.hendelser.behandling.Behandlingstype;
import no.nav.vedtak.hendelser.behandling.Hendelse;
import no.nav.vedtak.hendelser.behandling.Kildesystem;
import no.nav.vedtak.hendelser.behandling.Ytelse;

public class BehandlingHendelseV1 extends BehandlingHendelse {

    /**
     * Behandling som er endret
     */
    @NotNull
    @Valid
    @JsonProperty("hendelseUuid")
    private UUID hendelseUuid;

    /**
     * Behandling som er endret
     */
    @NotNull
    @Valid
    @JsonProperty("behandlingUuid")
    private UUID behandlingUuid;

    /**
     * Kilde for hendelse
     */
    @NotNull
    @Valid
    @JsonProperty("kildesystem")
    private Kildesystem kildesystem;

    /**
     * Hendelse / endringstype
     */
    @NotNull
    @Valid
    @JsonProperty("hendelse")
    private Hendelse hendelse;

    /**
     * Tidspunkt for hendelse
     */
    @JsonProperty("tidspunkt")
    private LocalDateTime tidspunkt;

    /**
     * Behandlingen gjelder bruker
     */
    @Valid
    @JsonProperty("aktørId")
    private AktørId aktørId;

    /**
     * Behandlingen gjelder saksnummer
     */
    @JsonProperty("saksnummer")
    private String saksnummer;

    /**
     * Saken gjelder ytelse
     */
    @JsonProperty("ytelse")
    private Ytelse ytelse;

    /**
     * Behandling av type
     */
    @JsonProperty("behandlingstype")
    private Behandlingstype behandlingstype;

    @Override
    public UUID getHendelseUuid() {
        return hendelseUuid;
    }

    @Override
    public UUID getBehandlingUuid() {
        return behandlingUuid;
    }

    @Override
    public Kildesystem getKildesystem() {
        return kildesystem;
    }

    @Override
    public Hendelse getHendelse() {
        return hendelse;
    }

    @Override
    public LocalDateTime getTidspunkt() {
        return tidspunkt;
    }

    public AktørId getAktørId() {
        return aktørId;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public Ytelse getYtelse() {
        return ytelse;
    }

    public Behandlingstype getBehandlingstype() {
        return behandlingstype;
    }

    public static class Builder {
        private BehandlingHendelseV1 behandlingHendelse;

        public Builder() {
            behandlingHendelse = new BehandlingHendelseV1();
        }

        public Builder medHendelseUuid(UUID hendelseUuid) {
            behandlingHendelse.hendelseUuid = hendelseUuid;
            return this;
        }

        public Builder medBehandlingUuid(UUID behandlingUuid) {
            behandlingHendelse.behandlingUuid = behandlingUuid;
            return this;
        }

        public Builder medKildesystem(Kildesystem kildesystem) {
            behandlingHendelse.kildesystem = kildesystem;
            return this;
        }

        public Builder medHendelse(Hendelse hendelse) {
            behandlingHendelse.hendelse = hendelse;
            return this;
        }

        public Builder medTidspunkt(LocalDateTime tidspunkt) {
            behandlingHendelse.tidspunkt = tidspunkt;
            return this;
        }

        public Builder medAktørId(String aktørId) {
            behandlingHendelse.aktørId = new AktørId(aktørId);
            return this;
        }

        public Builder medSaksnummer(String saksnummer) {
            behandlingHendelse.saksnummer = saksnummer;
            return this;
        }

        public Builder medYtelse(Ytelse ytelse) {
            behandlingHendelse.ytelse = ytelse;
            return this;
        }

        public Builder medBehandlingstype(Behandlingstype behandlingstype) {
            behandlingHendelse.behandlingstype = behandlingstype;
            return this;
        }

        public BehandlingHendelseV1 build() {
            return behandlingHendelse;
        }
    }
}
