package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.AktørId;

public record AnnenPartDto(@Valid AktørId annenpartAktørId, @Pattern(regexp = "^[\\p{Graph}\\p{Space}\\p{Sc}\\p{L}\\p{M}\\p{N}\\p{P}]+$") String utlandskFnr) {

}