package no.nav.foreldrepenger.kontrakter.formidling.kodeverk;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record Saksnummer(@Size(max = 20) @Pattern(regexp = "^[a-zA-Z0-9_\\-]*$") String saksnummer) { }
