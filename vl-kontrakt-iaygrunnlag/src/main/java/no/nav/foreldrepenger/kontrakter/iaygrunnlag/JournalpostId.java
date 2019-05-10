package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT)
public class JournalpostId {

    @JsonValue
    @NotNull
    @Pattern(regexp = "^[\\p{L}\\p{N}:_.-]+$")
    private String journalpostId;

    @JsonCreator
    public JournalpostId(String journalpostId) {
        Objects.requireNonNull(journalpostId, "journalpostId");
        this.journalpostId = journalpostId;
    }

    public String getId() {
        return journalpostId;
    }

}
