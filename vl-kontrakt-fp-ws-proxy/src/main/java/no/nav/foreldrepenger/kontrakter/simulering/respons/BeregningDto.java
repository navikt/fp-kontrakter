package no.nav.foreldrepenger.kontrakter.simulering.respons;

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

    private BeregningDto(Builder builder) {
        this(builder.gjelderId,
        builder.gjelderNavn,
        builder.datoBeregnet,
        builder.kodeFaggruppe,
        builder.belop,
        builder.beregningsPeriode);
    }

    public static class Builder {
        private String gjelderId;
        private String gjelderNavn;
        private String datoBeregnet;
        private String kodeFaggruppe;
        private BigDecimal belop;
        private List<BeregningsPeriodeDto> beregningsPeriode;

        public Builder() {
        }

        public Builder gjelderId(String gjelderId) {
            this.gjelderId = gjelderId;
            return this;
        }

        public Builder gjelderNavn(String gjelderNavn) {
            this.gjelderNavn = gjelderNavn;
            return this;
        }

        public Builder datoBeregnet(String datoBeregnet) {
            this.datoBeregnet = datoBeregnet;
            return this;
        }

        public Builder kodeFaggruppe(String kodeFaggruppe) {
            this.kodeFaggruppe = kodeFaggruppe;
            return this;
        }

        public Builder belop(BigDecimal belop) {
            this.belop = belop;
            return this;
        }

        public Builder beregningsPeriode(List<BeregningsPeriodeDto> beregningsPeriode) {
            this.beregningsPeriode = beregningsPeriode;
            return this;
        }

        public BeregningDto build() throws IllegalStateException {
            return new BeregningDto(this);
        }
    }
}
