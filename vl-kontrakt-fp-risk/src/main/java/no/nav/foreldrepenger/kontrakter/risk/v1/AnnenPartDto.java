package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.util.Optional;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.AktørId;

public record AnnenPartDto(@Valid AktørId annenpartAktørId, @Pattern(regexp = "^[\\p{Graph}\\p{Space}\\p{Sc}\\p{L}\\p{M}\\p{N}]+$") String utlandskFnr) {

    @Deprecated // Bruk annenpartAktørId()
    public Optional<AktørId> getAnnenPartAktørId() {
        return Optional.ofNullable(annenpartAktørId);
    }
    @Deprecated // Bruk utlandskFnr()
    public Optional<String> getUtlandskFnr() {
        return Optional.ofNullable(utlandskFnr);
    }

}