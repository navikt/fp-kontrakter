package no.nav.foreldrepenger.oppgave.event.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class OppgaveAktør {
    private final String aktørId;
    private final AktørRolle rolle;

    @JsonCreator
    public OppgaveAktør(@JsonProperty("aktørId") String aktørId,
                        @JsonProperty("rolle") AktørRolle rolle) {
        this.aktørId = aktørId;
        this.rolle = rolle;
    }

    public String getAktørId() {
        return aktørId;
    }

    public AktørRolle getRolle() {
        return rolle;
    }

    @Override
    public String toString() {
        return "OppgaveAktør{" +
                "aktørId=" + aktørId +
                ", rolle=" + rolle +
                '}';
    }

    public enum AktørRolle {
        SØKER, ANNEN_AKTØR
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OppgaveAktør that = (OppgaveAktør) o;
        return Objects.equals(aktørId, that.aktørId) &&
                rolle == that.rolle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aktørId, rolle);
    }
}