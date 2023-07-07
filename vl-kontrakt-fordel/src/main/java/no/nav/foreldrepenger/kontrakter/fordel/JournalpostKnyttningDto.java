package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JournalpostKnyttningDto {
    @Valid
    @JsonProperty
    private SaksnummerDto saksnummerDto;
    @Valid
    @JsonProperty
    private JournalpostIdDto journalpostIdDto;

    public JournalpostKnyttningDto(String saksnummer, String journalpostId) {
        this(new SaksnummerDto(saksnummer), new JournalpostIdDto(journalpostId));
    }

    public JournalpostKnyttningDto(SaksnummerDto saksnummerDto, JournalpostIdDto journalpostIdDto) {
        this.saksnummerDto = saksnummerDto;
        this.journalpostIdDto = journalpostIdDto;
    }

    public JournalpostKnyttningDto() {  // For Jackson
    }

    @JsonIgnore
    public String getSaksnummer() {
        return saksnummerDto.getSaksnummer();
    }

    @JsonIgnore
    public String getJournalpostId() {
        return journalpostIdDto.getJournalpostId();
    }

}
