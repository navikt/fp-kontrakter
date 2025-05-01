package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record JournalpostVurderingDto(@Size(max = 8) @Pattern(regexp = "^[a-zA-ZæøåÆØÅ_\\-0-9]*$") String behandlingstemaOffisiellKode,
                                      Boolean erFørstegangssøknad, Boolean erInntektsmelding) {
}
