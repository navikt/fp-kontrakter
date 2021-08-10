package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.util.List;

import javax.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.RisikogruppeType;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.RisikoklasseType;

public record RisikogruppeDto(@NotNull RisikogruppeType risikogruppe, List<String> faresignaler) {

    public List<String> faresignalerNonNull() {
        return faresignaler != null ? faresignaler : List.of();
    }
}
