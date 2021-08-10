package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.util.Optional;

import javax.validation.constraints.Pattern;

public record AnnenPartDto(@Pattern(regexp = "^\\d{13}$") String annenpartAktørId, String utenlandskFnr) {

    public Optional<String> getAnnenPartAktørId() {
        return Optional.ofNullable(annenpartAktørId);
    }

    public Optional<String> getUtenlandskFnr() {
        return Optional.ofNullable(utenlandskFnr);
    }

}