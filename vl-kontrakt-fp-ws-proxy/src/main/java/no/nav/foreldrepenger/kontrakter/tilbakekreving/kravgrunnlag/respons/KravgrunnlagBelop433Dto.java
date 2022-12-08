package no.nav.foreldrepenger.kontrakter.tilbakekreving.kravgrunnlag.respons;

import java.math.BigDecimal;
import java.util.Optional;

public record KravgrunnlagBelop433Dto(String klasseKode,
                                      KlasseType klasseType,
                                      BigDecimal opprUtbetBelop,
                                      BigDecimal nyBelop,
                                      BigDecimal tilbakekrevesBelop,
                                      BigDecimal uinnkrevdBelop,
                                      BigDecimal skattProsent,
                                      String resultatKode,
                                      String årsakKode,
                                      String skyldKode) {

    public KravgrunnlagBelop433Dto {
        opprUtbetBelop = Optional.ofNullable(opprUtbetBelop).orElse(BigDecimal.ZERO);
        nyBelop = Optional.ofNullable(nyBelop).orElse(BigDecimal.ZERO);
        tilbakekrevesBelop = Optional.ofNullable(tilbakekrevesBelop).orElse(BigDecimal.ZERO);
        uinnkrevdBelop = Optional.ofNullable(uinnkrevdBelop).orElse(BigDecimal.ZERO);
        skattProsent = Optional.ofNullable(skattProsent).orElse(BigDecimal.ZERO);
    }

    public KravgrunnlagBelop433Dto(Builder builder) {
        this(builder.klasseKode,
            builder.klasseType,
            builder.opprUtbetBelop,
            builder.nyBelop,
            builder.tilbakekrevesBelop,
            builder.uinnkrevdBelop,
            builder.skattProsent,
            builder.resultatKode,
            builder.årsakKode,
            builder.skyldKode);
    }

    public static class Builder {
        private String klasseKode;
        private KlasseType klasseType;
        private BigDecimal opprUtbetBelop;
        private BigDecimal nyBelop;
        private BigDecimal tilbakekrevesBelop;
        private BigDecimal uinnkrevdBelop;
        private BigDecimal skattProsent;
        private String resultatKode;
        private String årsakKode;
        private String skyldKode;

        public Builder() {
        }

        public Builder klasseKode(String klasseKode) {
            this.klasseKode = klasseKode;
            return this;
        }

        public Builder klasseType(KlasseType klasseType) {
            this.klasseType = klasseType;
            return this;
        }

        public Builder opprUtbetBelop(BigDecimal opprUtbetBelop) {
            this.opprUtbetBelop = opprUtbetBelop;
            return this;
        }

        public Builder nyBelop(BigDecimal nyBelop) {
            this.nyBelop = nyBelop;
            return this;
        }

        public Builder tilbakekrevesBelop(BigDecimal tilbakekrevesBelop) {
            this.tilbakekrevesBelop = tilbakekrevesBelop;
            return this;
        }

        public Builder uinnkrevdBelop(BigDecimal uinnkrevdBelop) {
            this.uinnkrevdBelop = uinnkrevdBelop;
            return this;
        }

        public Builder skattProsent(BigDecimal skattProsent) {
            this.skattProsent = skattProsent;
            return this;
        }

        public Builder resultatKode(String resultatKode) {
            this.resultatKode = resultatKode;
            return this;
        }

        public Builder årsakKode(String årsakKode) {
            this.årsakKode = årsakKode;
            return this;
        }

        public Builder skyldKode(String skyldKode) {
            this.skyldKode = skyldKode;
            return this;
        }

        public KravgrunnlagBelop433Dto build() throws IllegalStateException {
            return new KravgrunnlagBelop433Dto(this);
        }
    }
}
