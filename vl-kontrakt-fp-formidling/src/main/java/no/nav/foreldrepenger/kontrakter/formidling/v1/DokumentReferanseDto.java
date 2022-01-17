package no.nav.foreldrepenger.kontrakter.formidling.v1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record DokumentReferanseDto(@NotNull String linkTekst,
                                   @NotNull @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$") String journalpostId,
                                   @NotNull String dokumentId) {
}
