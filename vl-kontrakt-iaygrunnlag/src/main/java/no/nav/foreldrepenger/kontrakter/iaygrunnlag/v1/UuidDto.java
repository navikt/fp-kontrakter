package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class UuidDto {

    @JsonValue
    @NotNull
    @Pattern(regexp = "\\b[0-9a-f]{8}\\b-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-\\b[0-9a-f]{12}\\b")
    private String uuid;

    protected UuidDto() {
        // default ctor
    }
    
    public UuidDto(String uuid) {
        Objects.requireNonNull(uuid, "uuid");
        this.uuid = uuid;
    }

    public UuidDto(UUID uuid) {
        Objects.requireNonNull(uuid, "uuid");
        this.uuid = uuid.toString();
    }

    public String getReferanse() {
        return uuid;
    }

}
