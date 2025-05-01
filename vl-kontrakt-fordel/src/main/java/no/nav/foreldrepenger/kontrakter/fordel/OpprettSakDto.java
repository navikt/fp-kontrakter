package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record OpprettSakDto(@Digits(integer = 18, fraction = 0) String journalpostId,
                            @NotNull @Size(max = 8) @Pattern(regexp = "^[a-zA-ZæøåÆØÅ_\\-0-9]*$") String behandlingstemaOffisiellKode,
                            @NotNull @Digits(integer = 19, fraction = 0) String aktørId) {


}
