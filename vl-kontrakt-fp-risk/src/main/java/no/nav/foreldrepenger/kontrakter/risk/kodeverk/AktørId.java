package no.nav.foreldrepenger.kontrakter.risk.kodeverk;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record AktørId(@NotNull @Pattern(regexp = "^\\d{13}$") String aktørId) {
}
