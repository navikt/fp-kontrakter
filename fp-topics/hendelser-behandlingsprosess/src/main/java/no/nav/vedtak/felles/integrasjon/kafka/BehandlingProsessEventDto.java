package no.nav.vedtak.felles.integrasjon.kafka;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

public class BehandlingProsessEventDto {
    /**
     * Ekstern id for behandlingen. Id benyttes til oppslag i fagsystem.
     * Benytt samme id for alle oppdateringer av aksjonspunkt/prosess innenfor samme behandling.
     */
    private UUID eksternId;
    private Fagsystem fagsystem;
    private String saksnummer;
    private String aktørId;

    private Long behandlingId; // fjernes etter overgang til eksternId

    /**
     * Tidspunkt for hendelse lokalt for fagsystem.
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime eventTid;
    private EventHendelse eventHendelse;
    private String behandlinStatus; // fjernes etter overgang til behandlingStatus
    private String behandlingStatus;
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

    /**
     * Leke til forekomst i eksternt system
     */
    private String href;

    public BehandlingProsessEventDto() {
    }

    public UUID getEksternId() {
        return eksternId;
    }

    public Long getBehandlingId() {
        return behandlingId;
    }

    public Fagsystem getFagsystem() {
        return fagsystem;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public String getAktørId() {
        return aktørId;
    }

    public LocalDateTime getEventTid() {
        return eventTid;
    }

    public EventHendelse getEventHendelse() {
        return eventHendelse;
    }

    /**
     * @Deprecated Bruk {@link #getBehandlingStatus()}
     * @return
     */
    @Deprecated
    public String getBehandlinStatus() {
        return behandlinStatus;
    }

    public String getBehandlingStatus() {
        return behandlingStatus;
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

    public String getHref() {
        return href;
    }

    protected BehandlingProsessEventDto(Builder<?> builder) {
        this.eksternId = builder.eksternId;
        this.fagsystem = builder.fagsystem;
        this.saksnummer = builder.saksnummer;
        this.aktørId = builder.aktørId;
        this.behandlingId = builder.behandlingId;
        this.eventTid = builder.eventTid;
        this.eventHendelse = builder.eventHendelse;
        this.behandlinStatus = builder.behandlinStatus;
        this.behandlingStatus = builder.behandlingStatus;
        this.behandlingSteg = builder.behandlingSteg;
        this.behandlendeEnhet = builder.behandlendeEnhet;
        this.ytelseTypeKode = builder.ytelseTypeKode;
        this.behandlingTypeKode = builder.behandlingTypeKode;
        this.opprettetBehandling = builder.opprettetBehandling;
        this.aksjonspunktKoderMedStatusListe = builder.aksjonspunktKoderMedStatusListe;
        this.href = builder.href;
    }

    public static abstract class Builder<T extends Builder<T>> {
        private UUID eksternId;
        private Fagsystem fagsystem;
        private String saksnummer;
        private String aktørId;
        private Long behandlingId;
        private LocalDateTime eventTid;
        private EventHendelse eventHendelse;
        private String behandlinStatus;
        private String behandlingStatus;
        private String behandlingSteg;
        private String behandlendeEnhet;
        private String ytelseTypeKode;
        private String behandlingTypeKode;
        private LocalDateTime opprettetBehandling;
        private Map<String, String> aksjonspunktKoderMedStatusListe;
        private String href;

        protected abstract T self();

        public T medEksternId(UUID eksternId) {
            this.eksternId = eksternId;
            return self();
        }

        public T medFagsystem(Fagsystem fagsystem) {
            this.fagsystem = fagsystem;
            return self();
        }

        public T medSaksnummer(String saksnummer) {
            this.saksnummer = saksnummer;
            return self();
        }

        public T medAktørId(String aktørId) {
            this.aktørId = aktørId;
            return self();
        }

        public T medBehandlingId(Long behandlingId) {
            this.behandlingId = behandlingId;
            return self();
        }

        public T medEventTid(LocalDateTime eventTid) {
            this.eventTid = eventTid;
            return self();
        }

        public T medEventHendelse(EventHendelse eventHendelse) {
            this.eventHendelse = eventHendelse;
            return self();
        }

        public T medBehandlinStatus(String behandlinStatus) {
            this.behandlinStatus = behandlinStatus;
            return self();
        }

        public T medBehandlingStatus(String behandlingStatus) {
            this.behandlingStatus = behandlingStatus;
            return self();
        }

        public T medBehandlingSteg(String behandlingSteg) {
            this.behandlingSteg = behandlingSteg;
            return self();
        }

        public T medBehandlendeEnhet(String behandlendeEnhet) {
            this.behandlendeEnhet = behandlendeEnhet;
            return self();
        }

        public T medYtelseTypeKode(String ytelseTypeKode) {
            this.ytelseTypeKode = ytelseTypeKode;
            return self();
        }

        public T medBehandlingTypeKode(String behandlingTypeKode) {
            this.behandlingTypeKode = behandlingTypeKode;
            return self();
        }

        public T medOpprettetBehandling(LocalDateTime opprettetBehandling) {
            this.opprettetBehandling = opprettetBehandling;
            return self();
        }

        public T medAksjonspunktKoderMedStatusListe(Map<String, String> aksjonspunktKoderMedStatusListe) {
            this.aksjonspunktKoderMedStatusListe = aksjonspunktKoderMedStatusListe;
            return self();
        }

        public T medHref(String href) {
            this.href = href;
            return self();
        }

        public BehandlingProsessEventDto build() {
            return new BehandlingProsessEventDto(this);
        }
    }

    private static class BuilderImpl extends Builder<BuilderImpl> {
        @Override
        protected BuilderImpl self() {
            return this;
        }
    }

    public static Builder<?> builder() {
        return new BuilderImpl();
    }
}
