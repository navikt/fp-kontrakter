package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.FaresignalVurdering;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.RisikoklasseType;

public record RisikovurderingResultatDto(@NotNull RisikoklasseType risikoklasse,
                                         @Valid RisikogruppeDto medlemskapFaresignaler,
                                         @Valid RisikogruppeDto opptjeningFaresignaler,
                                         @Valid FaresignalVurdering faresignalvurdering) {

    public static RisikovurderingResultatDto ikkeKlassifisert() {
        return new RisikovurderingResultatDto(RisikoklasseType.IKKE_KLASSIFISERT, null, null, null);
    }

    public List<String> medlemskapFaresignalerNonNull() {
        return medlemskapFaresignaler != null ? medlemskapFaresignaler.faresignalerNonNull() : List.of();
    }

    public List<String> opptjeningFaresignalerNonNull() {
        return opptjeningFaresignaler != null ? opptjeningFaresignaler.faresignalerNonNull() : List.of();
    }
}
