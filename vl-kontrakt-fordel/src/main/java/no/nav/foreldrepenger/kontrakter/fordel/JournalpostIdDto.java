package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.constraints.Digits;

public class JournalpostIdDto {

    @Digits(integer = 18, fraction = 0)
    private String journalpostId;

    public JournalpostIdDto(String journalpostId) {
        this.journalpostId = journalpostId;
    }

    public JournalpostIdDto() {  // For Jackson
    }

    public String getJournalpostId() {
        return journalpostId;
    }
}
