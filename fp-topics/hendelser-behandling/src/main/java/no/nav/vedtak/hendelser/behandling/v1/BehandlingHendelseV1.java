package no.nav.vedtak.hendelser.behandling.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.vedtak.hendelser.behandling.AktørId;
import no.nav.vedtak.hendelser.behandling.BehandlingHendelse;
import no.nav.vedtak.hendelser.behandling.Behandlingstype;
import no.nav.vedtak.hendelser.behandling.Hendelse;
import no.nav.vedtak.hendelser.behandling.Kildesystem;
import no.nav.vedtak.hendelser.behandling.Ventekategori;
import no.nav.vedtak.hendelser.behandling.Ytelse;

public class BehandlingHendelseV1 extends BehandlingHendelse {

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
     * Behandlingen gjelder bruker
     */
    @NotNull
    @Valid
    @JsonProperty("aktørId")
    private AktørId aktørId;

    /**
     * Behandlingen gjelder saksnummer
     */
    @NotNull
    @Pattern(regexp = "^(-?[1-9]|[a-z0])[a-z0-9_:-]*$", flags = { Pattern.Flag.CASE_INSENSITIVE })
    @JsonProperty("saksnummer")
    private String saksnummer;

    /**
     * Saken gjelder ytelse
     */
    @NotNull
    @JsonProperty("ytelse")
    private Ytelse ytelse;

    /**
     * Behandling av type
     */
    @NotNull
    @JsonProperty("behandlingstype")
    private Behandlingstype behandlingstype;

    /**
     * Eventuell kategori av ventetilstand
     */
    @JsonProperty("ventekategori")
    private Ventekategori ventekategori;

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

    public Ventekategori getVentekategori() {
        return ventekategori;
    }

    public static class Builder {
        private BehandlingHendelseV1 behandlingHendelse;

        public Builder() {
            behandlingHendelse = new BehandlingHendelseV1();
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

        public Builder medVentekategori(Ventekategori ventekategori) {
            behandlingHendelse.ventekategori = ventekategori;
            return this;
        }

        public BehandlingHendelseV1 build() {
            return behandlingHendelse;
        }
    }
}
