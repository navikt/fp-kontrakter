package no.nav.foreldrepenger.oppgave.event;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import no.nav.foreldrepenger.oppgave.event.v1.OppgaveEventV1;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "version")
@JsonSubTypes({
        @JsonSubTypes.Type(value = OppgaveEventV1.class, name = "1"),
})
public abstract class OppgaveEvent {
}
