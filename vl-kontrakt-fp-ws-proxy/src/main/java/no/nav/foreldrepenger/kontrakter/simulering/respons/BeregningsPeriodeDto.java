package no.nav.foreldrepenger.kontrakter.simulering.respons;

import java.util.List;
import java.util.Optional;

public record BeregningsPeriodeDto(String periodeFom,
                                   String periodeTom,
                                   List<BeregningStoppnivåDto> beregningStoppnivaa) {

}
