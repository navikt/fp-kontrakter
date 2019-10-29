package no.nav.vedtak.felles.integrasjon.kafka;

import java.util.Objects;

public class Event {
    protected String fagsystem;
    protected String saksnummer;
    protected String aktørId;
    protected String behandlendeEnhet;
    /**
     * Ytelsestype i kodeform. Eksempel: FP
     */
    protected String ytelseTypeKode;
    /**
     * Behandlingstype i kodeform. Eksempel: BT-002
     */
    protected String behandlingTypeKode;

    public String getFagsystem() {
        return fagsystem;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public String getAktørId() {
        return aktørId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(fagsystem, event.fagsystem) &&
                Objects.equals(saksnummer, event.saksnummer) &&
                Objects.equals(aktørId, event.aktørId) &&
                Objects.equals(behandlendeEnhet, event.behandlendeEnhet) &&
                Objects.equals(ytelseTypeKode, event.ytelseTypeKode) &&
                Objects.equals(behandlingTypeKode, event.behandlingTypeKode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fagsystem, saksnummer, aktørId, behandlendeEnhet, ytelseTypeKode, behandlingTypeKode);
    }
}
