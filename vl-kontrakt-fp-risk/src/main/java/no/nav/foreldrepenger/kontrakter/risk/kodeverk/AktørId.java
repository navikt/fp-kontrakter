package no.nav.foreldrepenger.kontrakter.risk.kodeverk;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AktørId(@NotNull @Pattern(regexp = "^\\d{13}$") String aktørId) {
}
