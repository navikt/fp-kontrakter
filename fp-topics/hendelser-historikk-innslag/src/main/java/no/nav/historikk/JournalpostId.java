package no.nav.historikk;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Journalpostid refererer til journalpost registret i Joark.
 */
public class JournalpostId implements Serializable {

    @JsonValue
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @JsonProperty(value = "journalpostId", required = true)
    private String journalpostId;

    @JsonCreator
    public JournalpostId(String journalpostId) {
        this.journalpostId = journalpostId;
    }

    public String getVerdi() {
        return journalpostId;
    }
}
