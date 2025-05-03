package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public record JournalpostIdDto(@NotNull @Digits(integer = 18, fraction = 0) String journalpostId) {

    public JournalpostIdDto {
        Objects.requireNonNull(journalpostId, "journalpostId");
    }

}
