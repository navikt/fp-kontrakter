package no.nav.historikk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Journalpostid refererer til journalpost registret i Joark.
 */
public class JournalpostId implements Serializable {

    private static final String CHARS = "a-z0-9_:-";

    private static final Pattern VALID = Pattern.compile("^(-?[1-9]|[a-z0])[" + CHARS + "]*$", Pattern.CASE_INSENSITIVE);
    private static final Pattern INVALID = Pattern.compile("[^" + CHARS + "]+", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);

    @JsonValue
    @JsonProperty(value = "journalpostId", required = true)
    private String journalpostId;

    @JsonCreator
    public JournalpostId(@JsonProperty(value = "journalpostId", required = true) Long journalpostId) {
        this.journalpostId = Long.toString(journalpostId);
    }

    public String getVerdi() {
        return journalpostId;
    }
}
