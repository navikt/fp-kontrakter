package no.nav.foreldrepenger.kontrakter.arena.respons;

import java.math.BigDecimal;
import java.time.LocalDate;


public record MeldekortUtbetalingsgrunnlagMeldekortDto(BigDecimal beløp,
                                                       BigDecimal dagsats,
                                                       LocalDate meldekortFom,
                                                       LocalDate meldekortTom,
                                                       BigDecimal utbetalingsgrad) {

    public MeldekortUtbetalingsgrunnlagMeldekortDto(Builder builder) {
        this(builder.beløp, builder.dagsats, builder.meldekortFom, builder.meldekortTom, builder.utbetalingsgrad);
    }

    public static class Builder {
        private BigDecimal beløp;
        private BigDecimal dagsats;
        private LocalDate meldekortFom;
        private LocalDate meldekortTom;
        private BigDecimal utbetalingsgrad;

        public Builder() {
        }

        public Builder beløp(BigDecimal beløp) {
            this.beløp = beløp;
            return this;
        }

        public Builder dagsats(BigDecimal dagsats) {
            this.dagsats = dagsats;
            return this;
        }

        public Builder meldekortFom(LocalDate meldekortFom) {
            this.meldekortFom = meldekortFom;
            return this;
        }

        public Builder meldekortTom(LocalDate meldekortTom) {
            this.meldekortTom = meldekortTom;
            return this;
        }

        public Builder utbetalingsgrad(BigDecimal utbetalingsgrad) {
            this.utbetalingsgrad = utbetalingsgrad;
            return this;
        }

        public MeldekortUtbetalingsgrunnlagMeldekortDto build() throws IllegalStateException {
            return new MeldekortUtbetalingsgrunnlagMeldekortDto(this);
        }
    }

}
