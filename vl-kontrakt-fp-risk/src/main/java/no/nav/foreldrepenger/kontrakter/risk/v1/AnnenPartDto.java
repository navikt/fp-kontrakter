package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.util.Optional;

import javax.validation.Valid;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.AktørId;

public record AnnenPartDto(@Valid AktørId annenpartAktørId, String utlandskFnr) {

    @Deprecated // Bruk annenpartAktørId()
    public Optional<AktørId> getAnnenPartAktørId() {
        return Optional.ofNullable(annenpartAktørId);
    }
    @Deprecated // Bruk utlandskFnr()
    public Optional<String> getUtlandskFnr() {
        return Optional.ofNullable(utlandskFnr);
    }

}