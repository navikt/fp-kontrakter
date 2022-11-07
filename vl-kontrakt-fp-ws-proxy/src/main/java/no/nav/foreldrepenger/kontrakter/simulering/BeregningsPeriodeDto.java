package no.nav.foreldrepenger.kontrakter.simulering;

import java.util.List;
import java.util.Optional;

public record BeregningsPeriodeDto(String periodeFom,
                                   String periodeTom,
                                   List<BeregningStoppnivåDto> beregningStoppnivaa) {

    public BeregningsPeriodeDto {
        beregningStoppnivaa = Optional.ofNullable(beregningStoppnivaa).orElse(List.of());
    }
}
