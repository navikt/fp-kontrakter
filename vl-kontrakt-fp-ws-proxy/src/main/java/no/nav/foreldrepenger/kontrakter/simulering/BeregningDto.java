package no.nav.foreldrepenger.kontrakter.simulering;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public record BeregningDto(String gjelderId,
                           String gjelderNavn,
                           String datoBeregnet,
                           String kodeFaggruppe,
                           BigDecimal belop,
                           List<BeregningsPeriodeDto> beregningsPeriode) {

    public BeregningDto {
        beregningsPeriode = Optional.ofNullable(beregningsPeriode).orElse(List.of());
    }
}
