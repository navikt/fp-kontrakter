package no.nav.vedtak.felles.integrasjon.kafka;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class AksjonspunktEvent extends Event {

    /**
     * BehandlingsId for fagsystemet. Id brukes ved oppslag i fagsystem.
     * Benytt samme id for alle aksjonspunktoppdateringer innenfor samme behandling.
     */
    private String id;

    /**
     * Tidspunkt for hendelse lokalt for fagsystem.
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime eventTid;

    /**
     * Tidspunkt behandling ble opprettet
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime behandlingOpprettet;

    /**
     * Map av aksjonspunktkode og statuskode.
     * Eksempel: Map.of("7001", "OPPR")
     */
    private Map<String, String> aksjonspunktOgStatusListe;

    public String getId() {
        return id;
    }

    public LocalDateTime getBehandlingOpprettet() {
        return behandlingOpprettet;
    }

    public Map<String, String> getAksjonspunktOgStatusListe() {
        return aksjonspunktOgStatusListe;
    }

    public LocalDateTime getEventTid() {
        return eventTid;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private AksjonspunktEvent aksjonspunktEvent;

        private Builder() {
            aksjonspunktEvent = new AksjonspunktEvent();
        }

        public Builder withFagsystem(String fagsystem) {
            aksjonspunktEvent.fagsystem = fagsystem;
            return this;
        }

        public Builder withSaksnummer(String saksnummer) {
            aksjonspunktEvent.saksnummer = saksnummer;
            return this;
        }

        public Builder withAktørId(String aktørId) {
            aksjonspunktEvent.aktørId = aktørId;
            return this;
        }

        public Builder withBehandlendeEnhet(String behandlendeEnhet) {
            aksjonspunktEvent.behandlendeEnhet = behandlendeEnhet;
            return this;
        }

        public Builder withYtelseTypeKode(String ytelseTypeKode) {
            aksjonspunktEvent.ytelseTypeKode = ytelseTypeKode;
            return this;
        }

        public Builder withBehandlingTypeKode(String behandlingTypeKode) {
            aksjonspunktEvent.behandlingTypeKode = behandlingTypeKode;
            return this;
        }

        public Builder withId(String id) {
            aksjonspunktEvent.id = id;
            return this;
        }

        public Builder withEventTid(LocalDateTime eventTid) {
            aksjonspunktEvent.eventTid = eventTid;
            return this;
        }

        public Builder withBehandlingOpprettetTid(LocalDateTime behandlingOpprettetTid) {
            aksjonspunktEvent.behandlingOpprettet = behandlingOpprettetTid;
            return this;
        }

        public Builder withAksjonspunktOgStatusListe(Map<String, String> aksjonspunktOgStatusListe) {
            aksjonspunktEvent.aksjonspunktOgStatusListe = aksjonspunktOgStatusListe;
            return this;
        }

        public AksjonspunktEvent build() {
            return aksjonspunktEvent;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AksjonspunktEvent that = (AksjonspunktEvent) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(eventTid, that.eventTid) &&
                Objects.equals(behandlingOpprettet, that.behandlingOpprettet) &&
                Objects.equals(aksjonspunktOgStatusListe, that.aksjonspunktOgStatusListe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, eventTid, behandlingOpprettet, aksjonspunktOgStatusListe);
    }
}
