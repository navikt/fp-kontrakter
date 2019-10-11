package no.nav.foreldrepenger.oppgave.event.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import no.nav.foreldrepenger.oppgave.event.OppgaveEvent;
import no.nav.foreldrepenger.oppgave.event.Saksnummer;
import no.nav.foreldrepenger.oppgave.event.Uuid;
import no.nav.foreldrepenger.oppgave.event.v1.attributt.Attributt;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder( {"uuid", "hendelseTid", "aktører", "fagsystem", "saksnummer", "ytelsestype", "behandlingstype", "behandlendeEnhet", "url", "attributter", "saksbehandlereUtenTilgang" } )
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class OppgaveEventV1 extends OppgaveEvent {

    @JsonProperty(required = true)
    private Uuid uuid; //partisjoneres på denne

    @JsonProperty(required = true)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime hendelseTid; //representerer tidspunkt hendelsen oppstod lokalt for produsent

    @JsonProperty(required = true)
    private List<OppgaveAktør> aktører;

    @JsonProperty(required = true)
    private Fagsystem fagsystem;

    @JsonProperty(required = true)
    private Saksnummer saksnummer;

    @JsonProperty(required = true)
    private YtelseType ytelsetype;

    @JsonProperty(required = true)
    private BehandlingType behandlingType;

    @JsonProperty(required = true)
    private String behandlendeEnhet;

    @JsonProperty(required = true)
    private boolean aktiv; //verdi styrer om fplos oppretter/gjenåpner eller lukker oppgave

    @JsonProperty(required = true)
    private String url;

    private List<Attributt> attributter;

    public Uuid getUuid() {
        return uuid;
    }

    public List<OppgaveAktør> getAktører() {
        return aktører;
    }

    public Fagsystem getFagsystem() {
        return fagsystem;
    }

    public Saksnummer getSaksnummer() {
        return saksnummer;
    }

    public YtelseType getYtelsetype() {
        return ytelsetype;
    }

    public BehandlingType getBehandlingType() {
        return behandlingType;
    }

    public LocalDateTime getHendelseTid() {
        return hendelseTid;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public List<Attributt> getAttributter() {
        return attributter;
    }

    public String getBehandlendeEnhet() {
        return behandlendeEnhet;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "OppgaveEventV1{" +
                "uuid='" + uuid + '\'' +
                ", aktører=" + aktører + '\'' +
                ", fagsystem='" + fagsystem + '\'' +
                ", saksnummer='" + saksnummer + '\'' +
                ", ytelsestype='" + ytelsetype + '\'' +
                ", behandlingType='" + behandlingType + '\'' +
                ", hendelseTid=" + hendelseTid +
                ", aktiv=" + aktiv +
                ", attributter=" + attributter +
                ", behandlendeEnhet='" + behandlendeEnhet + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public static final class Builder {

        private OppgaveEventV1 oppgaveEvent = new OppgaveEventV1();

        private Builder() {
        }

        public static OppgaveEventV1.Builder newBuilder() {
            return new OppgaveEventV1.Builder();
        }

        public OppgaveEventV1.Builder withUuid(Uuid uuid) {
            this.oppgaveEvent.uuid = uuid;
            return this;
        }

        public OppgaveEventV1.Builder withAktoerId(List<OppgaveAktør> aktoerId) {
            this.oppgaveEvent.aktører = aktoerId;
            return this;
        }

        public OppgaveEventV1.Builder withFagsystem(Fagsystem fagsystem) {
            this.oppgaveEvent.fagsystem = fagsystem;
            return this;
        }

        public OppgaveEventV1.Builder withFagsystemSaksnummer(Saksnummer fagsystemSaksnummer) {
            this.oppgaveEvent.saksnummer = fagsystemSaksnummer;
            return this;
        }

        public OppgaveEventV1.Builder withYtelsestype(YtelseType ytelsestype) {
            this.oppgaveEvent.ytelsetype = ytelsestype;
            return this;
        }

        public OppgaveEventV1.Builder withBehandlingType(BehandlingType behandlingType) {
            this.oppgaveEvent.behandlingType = behandlingType;
            return this;
        }

        public OppgaveEventV1.Builder withHendelseTid(LocalDateTime hendelseTid) {
            this.oppgaveEvent.hendelseTid = hendelseTid;
            return this;
        }

        public OppgaveEventV1.Builder withAktiv(boolean oppgaveAktiv) {
            this.oppgaveEvent.aktiv = oppgaveAktiv;
            return this;
        }

        public OppgaveEventV1.Builder withAttributter(List<Attributt> attributter) {
            this.oppgaveEvent.attributter = attributter;
            return this;
        }

        public OppgaveEventV1.Builder withBehandlendeEnhet(String behandlendeEnhet) {
            this.oppgaveEvent.behandlendeEnhet = behandlendeEnhet;
            return this;
        }

        public OppgaveEventV1.Builder withUrl(String url) {
            this.oppgaveEvent.url = url;
            return this;
        }

        public OppgaveEventV1 build() {
            OppgaveEventV1 event = new OppgaveEventV1();
            event.behandlendeEnhet = this.oppgaveEvent.behandlendeEnhet;
            event.aktører = this.oppgaveEvent.aktører;
            event.url = this.oppgaveEvent.url;
            event.ytelsetype = this.oppgaveEvent.ytelsetype;
            event.fagsystem = this.oppgaveEvent.fagsystem;
            event.hendelseTid = this.oppgaveEvent.hendelseTid;
            event.behandlingType = this.oppgaveEvent.behandlingType;
            event.uuid = this.oppgaveEvent.uuid;
            event.saksnummer = this.oppgaveEvent.saksnummer;
            event.aktiv = this.oppgaveEvent.aktiv;
            event.attributter = this.oppgaveEvent.attributter;

            Objects.requireNonNull(event.behandlendeEnhet);
            Objects.requireNonNull(event.aktører);
            Objects.requireNonNull(event.ytelsetype);
            Objects.requireNonNull(event.fagsystem);
            Objects.requireNonNull(event.hendelseTid);
            Objects.requireNonNull(event.behandlingType);
            Objects.requireNonNull(event.uuid);
            Objects.requireNonNull(event.saksnummer);

            return event;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OppgaveEventV1 that = (OppgaveEventV1) o;
        return aktiv == that.aktiv &&
                Objects.equals(uuid, that.uuid) &&
                Objects.equals(aktører, that.aktører) &&
                Objects.equals(fagsystem, that.fagsystem) &&
                Objects.equals(saksnummer, that.saksnummer) &&
                Objects.equals(ytelsetype, that.ytelsetype) &&
                Objects.equals(behandlingType, that.behandlingType) &&
                Objects.equals(hendelseTid, that.hendelseTid) &&
                Objects.equals(attributter, that.attributter) &&
                Objects.equals(behandlendeEnhet, that.behandlendeEnhet) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, aktører, fagsystem, saksnummer,
                ytelsetype, behandlingType, hendelseTid, aktiv, attributter, behandlendeEnhet, url);
    }
}
