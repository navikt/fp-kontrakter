package no.nav.vedtak.felles.integrasjon.kafka;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class BehandlingProsessEventDto {

    public enum EventHendelse {
        AKSJONSPUNKT_OPPRETTET,
        AKSJONSPUNKT_UTFØRT,
        AKSJONSPUNKT_TILBAKEFØR,
        AKSJONSPUNKT_AVBRUTT,
        AKSJONSPUNKT_HAR_ENDRET_BEHANDLENDE_ENHET,
        BEHANDLINGSKONTROLL_EVENT
    }

    /**
     * Ekstern id for behandlingen. Id benyttes til oppslag i fagsystem.
     * Benytt samme id for alle aksjonspunktoppdateringer innenfor samme behandling.
     */
    private String id;
    private String fagsystem;
    private Long behandlingId; // fjernes etter overgang til id
    private String saksnummer;
    private String aktørId;

    /**
     * Tidspunkt for hendelse lokalt for fagsystem.
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime eventTid;

    private EventHendelse eventHendelse;

    private String behandlinStatus;
    private String behandlingSteg;
    private String behandlendeEnhet;

    /**
     * Ytelsestype i kodeform. Eksempel: FP
     */
    private String ytelseTypeKode;

    /**
     * Behandlingstype i kodeform. Eksempel: BT-002
     */
    private String behandlingTypeKode;

    /**
     * Tidspunkt behandling ble opprettet
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime opprettetBehandling;

    /**
     * Map av aksjonspunktkode og statuskode.
     */
    private Map<String, String> aksjonspunktKoderMedStatusListe;

    public String getFagsystem() {
        return fagsystem;
    }

    public Long getBehandlingId() {
        return behandlingId;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getEventTid() {
        return eventTid;
    }

    public String getAktørId() {
        return aktørId;
    }

    public EventHendelse getEventHendelse() {
        return eventHendelse;
    }

    public String getBehandlinStatus() {
        return behandlinStatus;
    }

    public String getBehandlingSteg() {
        return behandlingSteg;
    }

    public String getBehandlendeEnhet() {
        return behandlendeEnhet;
    }

    public String getYtelseTypeKode() {
        return ytelseTypeKode;
    }

    public String getBehandlingTypeKode() {
        return behandlingTypeKode;
    }

    public LocalDateTime getOpprettetBehandling() {
        return opprettetBehandling;
    }

    public Map<String, String> getAksjonspunktKoderMedStatusListe() {
        return aksjonspunktKoderMedStatusListe;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private BehandlingProsessEventDto behandlingProsessEventDto;

        private Builder() {
            behandlingProsessEventDto = new BehandlingProsessEventDto();
        }

        public Builder medId(String id) {
            behandlingProsessEventDto.id = id;
            return this;
        }

        public Builder medEventTid(LocalDateTime eventTid) {
            behandlingProsessEventDto.eventTid = eventTid;
            return this;
        }

        public Builder medFagsystem(String fagsystem) {
            behandlingProsessEventDto.fagsystem = fagsystem;
            return this;
        }

        public Builder medBehandlingId(Long behandlingId) {
            behandlingProsessEventDto.behandlingId = behandlingId;
            return this;
        }

        public Builder medSaksnummer(String saksnummer) {
            behandlingProsessEventDto.saksnummer = saksnummer;
            return this;
        }

        public Builder medAktørId(String aktørId) {
            behandlingProsessEventDto.aktørId = aktørId;
            return this;
        }

        public Builder medEventHendelse(EventHendelse eventHendelse) {
            behandlingProsessEventDto.eventHendelse = eventHendelse;
            return this;
        }

        public Builder medBehandlinStatus(String behandlinStatus) {
            behandlingProsessEventDto.behandlinStatus = behandlinStatus;
            return this;
        }

        public Builder medBehandlingSteg(String behandlingSteg) {
            behandlingProsessEventDto.behandlingSteg = behandlingSteg;
            return this;
        }

        public Builder medBehandlendeEnhet(String behandlendeEnhet) {
            behandlingProsessEventDto.behandlendeEnhet = behandlendeEnhet;
            return this;
        }

        public Builder medYtelseTypeKode(String ytelseTypeKode) {
            behandlingProsessEventDto.ytelseTypeKode = ytelseTypeKode;
            return this;
        }

        public Builder medBehandlingTypeKode(String behandlingTypeKode) {
            behandlingProsessEventDto.behandlingTypeKode = behandlingTypeKode;
            return this;
        }

        public Builder medOpprettetBehandling(LocalDateTime opprettetBehandling) {
            behandlingProsessEventDto.opprettetBehandling = opprettetBehandling;
            return this;
        }

        public Builder medAksjonspunktKoderMedStatusListe(Map<String, String> aksjonspunktKoderMedStatusListe) {
            behandlingProsessEventDto.aksjonspunktKoderMedStatusListe = aksjonspunktKoderMedStatusListe;
            return this;
        }

        public BehandlingProsessEventDto build() {
            return behandlingProsessEventDto;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BehandlingProsessEventDto that = (BehandlingProsessEventDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fagsystem, that.fagsystem) &&
                Objects.equals(behandlingId, that.behandlingId) &&
                Objects.equals(saksnummer, that.saksnummer) &&
                Objects.equals(aktørId, that.aktørId) &&
                Objects.equals(eventTid, that.eventTid) &&
                eventHendelse == that.eventHendelse &&
                Objects.equals(behandlinStatus, that.behandlinStatus) &&
                Objects.equals(behandlingSteg, that.behandlingSteg) &&
                Objects.equals(behandlendeEnhet, that.behandlendeEnhet) &&
                Objects.equals(ytelseTypeKode, that.ytelseTypeKode) &&
                Objects.equals(behandlingTypeKode, that.behandlingTypeKode) &&
                Objects.equals(opprettetBehandling, that.opprettetBehandling) &&
                Objects.equals(aksjonspunktKoderMedStatusListe, that.aksjonspunktKoderMedStatusListe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fagsystem, behandlingId, saksnummer, aktørId, eventTid, eventHendelse, behandlinStatus, behandlingSteg, behandlendeEnhet, ytelseTypeKode, behandlingTypeKode, opprettetBehandling, aksjonspunktKoderMedStatusListe);
    }
}
