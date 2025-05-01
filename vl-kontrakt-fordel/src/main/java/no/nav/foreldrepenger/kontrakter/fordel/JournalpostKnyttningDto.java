package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public record JournalpostKnyttningDto(@Valid @NotNull SaksnummerDto saksnummer,
                                      @Valid @NotNull JournalpostIdDto journalpostId) {

    public JournalpostKnyttningDto(String saksnummer, String journalpostId) {
        this(new SaksnummerDto(saksnummer), new JournalpostIdDto(journalpostId));
    }

    public JournalpostKnyttningDto {
        Objects.requireNonNull(saksnummer, "saksnummer");
        Objects.requireNonNull(journalpostId, "journalpostId");
    }

}
