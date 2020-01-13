package no.nav.vedtak.felles.integrasjon.kafka;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXISTING_PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = EXISTING_PROPERTY, property = "fagsystem", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TilbakebetalingBehandlingProsessEventDto.class, name = "FPTILBAKE"),
        @JsonSubTypes.Type(value = FpsakBehandlingProsessEventDto.class, name = "FPSAK")
})
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public abstract class BehandlingProsessEventDto {
    /**
     * Ekstern id for behandlingen. Id benyttes til oppslag i fagsystem.
     * Benytt samme id for alle oppdateringer av aksjonspunkt/prosess innenfor samme behandling.
     */
    protected UUID eksternId;
    protected Fagsystem fagsystem;
    protected String saksnummer;
    protected String aktørId;

    /**
     * Tidspunkt for hendelse lokalt for fagsystem.
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    protected LocalDateTime eventTid;

    protected EventHendelse eventHendelse;
    protected String behandlingStatus;
    protected String behandlingSteg;
    protected String behandlendeEnhet;

    /**
     * Ytelsestype i kodeform. Eksempel: FP
     */
    protected String ytelseTypeKode;

    /**
     * Behandlingstype i kodeform. Eksempel: BT-002
     */
    protected String behandlingTypeKode;

    /**
     * Tidspunkt behandling ble opprettet
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    protected LocalDateTime opprettetBehandling;

    /**
     * Map av aksjonspunktkode og statuskode.
     */
    protected Map<String, String> aksjonspunktKoderMedStatusListe;

    public UUID getEksternId() {
        return eksternId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BehandlingProsessEventDto that = (BehandlingProsessEventDto) o;
        return Objects.equals(eksternId, that.eksternId) &&
                fagsystem == that.fagsystem &&
                Objects.equals(saksnummer, that.saksnummer) &&
                Objects.equals(aktørId, that.aktørId) &&
                Objects.equals(eventTid, that.eventTid) &&
                eventHendelse == that.eventHendelse &&
                Objects.equals(behandlingStatus, that.behandlingStatus) &&
                Objects.equals(behandlingSteg, that.behandlingSteg) &&
                Objects.equals(behandlendeEnhet, that.behandlendeEnhet) &&
                Objects.equals(ytelseTypeKode, that.ytelseTypeKode) &&
                Objects.equals(behandlingTypeKode, that.behandlingTypeKode) &&
                Objects.equals(opprettetBehandling, that.opprettetBehandling) &&
                Objects.equals(aksjonspunktKoderMedStatusListe, that.aksjonspunktKoderMedStatusListe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eksternId, fagsystem, saksnummer, aktørId, eventTid, eventHendelse,
                behandlingStatus, behandlingSteg, behandlendeEnhet, ytelseTypeKode,
                behandlingTypeKode, opprettetBehandling, aksjonspunktKoderMedStatusListe);
    }
}
