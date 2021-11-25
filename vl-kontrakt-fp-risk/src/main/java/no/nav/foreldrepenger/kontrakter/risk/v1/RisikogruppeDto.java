package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.util.List;

public record RisikogruppeDto(List<String> faresignaler) {

    public List<String> faresignalerNonNull() {
        return faresignaler != null ? faresignaler : List.of();
    }
}
