package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.constraints.NotNull;

public record SelvstendigNæring(@NotNull String organisasjonsnummer,
                                String navn,
                                @NotNull Virksomhetstype næringstype) {

    public enum Virksomhetstype {
        ANNEN,
        JORDBRUK_SKOGBRUK,
        FISKE,
        DAGMAMMA
    }
}
