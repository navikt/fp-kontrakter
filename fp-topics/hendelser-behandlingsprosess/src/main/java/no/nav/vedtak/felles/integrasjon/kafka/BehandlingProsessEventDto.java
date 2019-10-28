package no.nav.vedtak.felles.integrasjon.kafka;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.Map;

public class BehandlingProsessEventDto extends Event {

    public enum EventHendelse {
        AKSJONSPUNKT_OPPRETTET,
        AKSJONSPUNKT_UTFØRT,
        AKSJONSPUNKT_TILBAKEFØR,
        AKSJONSPUNKT_AVBRUTT,
        AKSJONSPUNKT_HAR_ENDRET_BEHANDLENDE_ENHET,
        BEHANDLINGSKONTROLL_EVENT
    }

    private Long behandlingId;
    private EventHendelse eventHendelse; // eventhendelse
    private String behandlinStatus; //Status for behandlingen på tidspunktet ??Er kanskje ikke stabil?? //FJERN
    private String behandlingSteg; //Steget behandlingen er i når eventet intreffer //FJERN
    private LocalDateTime opprettetBehandling;
    private Map<String, String> aksjonspunktKoderMedStatusListe; // Liste over alle aksjonspunktdefinisjonskoder som hører til behandlingen, trolig Liste objekter istedet for Map ({4001,'UTFO'},{4025,'OPPR'},{4035,status})


    public EventHendelse getEventHendelse() {
        return eventHendelse;
    }

    public String getBehandlinStatus() {
        return behandlinStatus;
    }

    public String getBehandlingSteg() {
        return behandlingSteg;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private BehandlingProsessEventDto behandlingProsessEventDto;

        private Builder() {
            behandlingProsessEventDto = new BehandlingProsessEventDto();
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
}
