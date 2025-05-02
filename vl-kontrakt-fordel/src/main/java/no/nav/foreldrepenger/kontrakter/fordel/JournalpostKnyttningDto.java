package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public record JournalpostKnyttningDto(@Valid @NotNull SaksnummerDto saksnummerDto,
                                      @Valid @NotNull JournalpostIdDto journalpostIdDto) {

    public JournalpostKnyttningDto(String saksnummer, String journalpostId) {
        this(new SaksnummerDto(saksnummer), new JournalpostIdDto(journalpostId));
    }

    public JournalpostKnyttningDto {
        Objects.requireNonNull(saksnummerDto, "saksnummer");
        Objects.requireNonNull(journalpostIdDto, "journalpostId");
    }

}
