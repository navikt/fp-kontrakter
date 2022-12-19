package no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.kravgrunnlag.respons;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public record KravgrunnlagPeriode432Dto(Periode periode,
                                        BigDecimal beløpSkattMnd,
                                        List<KravgrunnlagBelop433Dto> kravgrunnlagBeloper433) {

    public KravgrunnlagPeriode432Dto {
        beløpSkattMnd = Optional.ofNullable(beløpSkattMnd).orElse(BigDecimal.ZERO);
        kravgrunnlagBeloper433 = Optional.ofNullable(kravgrunnlagBeloper433).orElse(Collections.emptyList());
    }

    public KravgrunnlagPeriode432Dto(Builder builder) {
        this(builder.periode,
            builder.beløpSkattMnd,
            builder.kravgrunnlagBeloper433);
    }


    public static class Builder {
        private Periode periode;
        private BigDecimal beløpSkattMnd;
        private List<KravgrunnlagBelop433Dto> kravgrunnlagBeloper433;

        public Builder() {
        }

        public Builder periode(Periode periode) {
            this.periode = periode;
            return this;
        }

        public Builder beløpSkattMnd(BigDecimal beløpSkattMnd) {
            this.beløpSkattMnd = beløpSkattMnd;
            return this;
        }

        public Builder kravgrunnlagBeloper433(List<KravgrunnlagBelop433Dto> kravgrunnlagBeloper433) {
            this.kravgrunnlagBeloper433 = kravgrunnlagBeloper433;
            return this;
        }

        public KravgrunnlagPeriode432Dto build() throws IllegalStateException {
            return new KravgrunnlagPeriode432Dto(this);
        }
    }
}
