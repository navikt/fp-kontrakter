package no.nav.foreldrepenger.kontrakter.tilbakekreving.kravgrunnlag.request;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public record HentKravgrunnlagDetaljDto(Long behandlingsId,
                                        @NotNull KodeAksjon kodeAksjon,
                                        @NotNull BigInteger kravgrunnlagId,
                                        @NotNull @Pattern(regexp = "^[a-zA-Z0-9_\\-]*$") String saksbehId,
                                        @NotNull @Pattern(regexp = "^[a-zA-Z0-9_\\-]*$") String enhetAnsvarlig) {

    public HentKravgrunnlagDetaljDto(Builder builder) {
        this(builder.behandlingsId,
             builder.kodeAksjon,
             builder.kravgrunnlagId,
             builder.saksbehId,
             builder.enhetAnsvarlig);
    }

    public static class Builder {
        private Long behandlingsId;
        private KodeAksjon kodeAksjon;
        private BigInteger kravgrunnlagId;
        private String saksbehId;
        private String enhetAnsvarlig;

        public Builder() {
        }

        public Builder behandlingsId(Long behandlingsId) {
            this.behandlingsId = behandlingsId;
            return this;
        }

        public Builder kodeAksjon(KodeAksjon kodeAksjon) {
            this.kodeAksjon = kodeAksjon;
            return this;
        }

        public Builder kravgrunnlagId(BigInteger kravgrunnlagId) {
            this.kravgrunnlagId = kravgrunnlagId;
            return this;
        }

        public Builder saksbehId(String saksbehId) {
            this.saksbehId = saksbehId;
            return this;
        }

        public Builder enhetAnsvarlig(String enhetAnsvarlig) {
            this.enhetAnsvarlig = enhetAnsvarlig;
            return this;
        }

        public HentKravgrunnlagDetaljDto build() throws IllegalStateException {
            return new HentKravgrunnlagDetaljDto(this);
        }
    }
}
