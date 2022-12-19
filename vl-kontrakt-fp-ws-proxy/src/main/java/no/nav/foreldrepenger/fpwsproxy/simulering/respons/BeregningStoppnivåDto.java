package no.nav.foreldrepenger.fpwsproxy.simulering.respons;

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

    private BeregningStoppnivåDto(Builder builder) {
        this(builder.kodeFagomraade,
                builder.stoppNivaaId,
                builder.behandlendeEnhet,
                builder.oppdragsId,
                builder.fagsystemId,
                builder.kid,
                builder.utbetalesTilId,
                builder.utbetalesTilNavn,
                builder.bilagsType,
                builder.forfall,
                builder.feilkonto,
                builder.beregningStoppnivaaDetaljer);
    }

    public static class Builder {
        private String kodeFagomraade;
        private BigInteger stoppNivaaId;
        private String behandlendeEnhet;
        private long oppdragsId;
        private String fagsystemId;
        private String kid;
        private String utbetalesTilId;
        private String utbetalesTilNavn;
        private String bilagsType;
        private String forfall;
        private boolean feilkonto;
        private List<BeregningStoppnivåDetaljerDto> beregningStoppnivaaDetaljer;

        public Builder() {
        }

        public Builder kodeFagomraade(String kodeFagomraade) {
            this.kodeFagomraade = kodeFagomraade;
            return this;
        }

        public Builder stoppNivaaId(BigInteger stoppNivaaId) {
            this.stoppNivaaId = stoppNivaaId;
            return this;
        }

        public Builder behandlendeEnhet(String behandlendeEnhet) {
            this.behandlendeEnhet = behandlendeEnhet;
            return this;
        }

        public Builder oppdragsId(long oppdragsId) {
            this.oppdragsId = oppdragsId;
            return this;
        }

        public Builder fagsystemId(String fagsystemId) {
            this.fagsystemId = fagsystemId;
            return this;
        }

        public Builder kid(String kid) {
            this.kid = kid;
            return this;
        }

        public Builder utbetalesTilId(String utbetalesTilId) {
            this.utbetalesTilId = utbetalesTilId;
            return this;
        }

        public Builder utbetalesTilNavn(String utbetalesTilNavn) {
            this.utbetalesTilNavn = utbetalesTilNavn;
            return this;
        }

        public Builder bilagsType(String bilagsType) {
            this.bilagsType = bilagsType;
            return this;
        }

        public Builder forfall(String forfall) {
            this.forfall = forfall;
            return this;
        }

        public Builder feilkonto(boolean feilkonto) {
            this.feilkonto = feilkonto;
            return this;
        }

        public Builder beregningStoppnivaaDetaljer(List<BeregningStoppnivåDetaljerDto> beregningStoppnivaaDetaljer) {
            this.beregningStoppnivaaDetaljer = beregningStoppnivaaDetaljer;
            return this;
        }

        public BeregningStoppnivåDto build() throws IllegalStateException {
            return new BeregningStoppnivåDto(this);
        }
    }
}
