package no.nav.foreldrepenger.oppgave.event;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class Uuid {

    @JsonValue
    private String uuid;

    @JsonCreator
    public Uuid(String uuid) {
        Objects.requireNonNull(uuid, "uuid");
        this.uuid = uuid;
    }

    public Uuid(UUID uuid) {
        Objects.requireNonNull(uuid, "uuid");
        this.uuid = uuid.toString();
    }

    @Override
    public String toString() {
        return "Uuid{" +
                "uuid='" + uuid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        var other = getClass().cast(obj);

        return Objects.equals(this.uuid, other.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
