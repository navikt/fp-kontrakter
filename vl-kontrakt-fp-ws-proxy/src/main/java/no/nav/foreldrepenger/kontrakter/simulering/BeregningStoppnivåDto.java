package no.nav.foreldrepenger.kontrakter.simulering;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


public record BeregningStoppnivåDto(String kodeFagomraade,
                                    BigInteger stoppNivaaId,
                                    String behandlendeEnhet,
                                    long oppdragsId,
                                    String fagsystemId,
                                    String kid,
                                    String utbetalesTilId,
                                    String utbetalesTilNavn,
                                    String bilagsType,
                                    String forfall,
                                    boolean feilkonto,
                                    List<BeregningStoppnivåDetaljerDto> beregningStoppnivaaDetaljer) {

    public BeregningStoppnivåDto {
        beregningStoppnivaaDetaljer = Optional.ofNullable(beregningStoppnivaaDetaljer).orElse(List.of());
    }
}
