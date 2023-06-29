package no.nav.vedtak.hendelser.behandling;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import no.nav.vedtak.hendelser.behandling.v1.BehandlingHendelseV1;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "version")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BehandlingHendelseV1.class, name = "1.0"),
})
public abstract class BehandlingHendelse {

    public abstract UUID getHendelseUuid();

    public abstract UUID getBehandlingUuid();

    public abstract Kildesystem getKildesystem();

    public abstract Hendelse getHendelse();
    public abstract LocalDateTime getTidspunkt();

}
