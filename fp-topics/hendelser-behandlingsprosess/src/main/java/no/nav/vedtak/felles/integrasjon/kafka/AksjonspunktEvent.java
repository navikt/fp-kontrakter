package no.nav.vedtak.felles.integrasjon.kafka;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.Map;

public class AksjonspunktEvent extends Event {

    /**
     * Ekstern behandlingsId for fagsystemet. Send samme id for alle oppdateringer innenfor samme behandling.
     *
     * Id brukes for å lage URL for oppslag i fagsystem.
     *
     * Kafka-topic er partisjonert på id. Producer må sende inn id som en key til Kafka.
     *
     */
    private String id; // husk å sette denne som key

    /**
     * Representerer tidspunktet hendelsen ble opprettet lokalt for fagsystemet
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime lokalEventTid;

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime behandlingOpprettetTid;

    private Map<String, String> aksjonspunktOgStatusListe;

    public String getId() {
        return id;
    }

    public LocalDateTime getBehandlingOpprettetTid() {
        return behandlingOpprettetTid;
    }

    public Map<String, String> getAksjonspunktOgStatusListe() {
        return aksjonspunktOgStatusListe;
    }


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

        public Builder withLocalEventTime(LocalDateTime localEventTime) {
            aksjonspunktEvent.lokalEventTid = localEventTime;
            return this;
        }

        public Builder withBehandlingOpprettetTid(LocalDateTime behandlingOpprettetTid) {
            aksjonspunktEvent.behandlingOpprettetTid = behandlingOpprettetTid;
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
}
