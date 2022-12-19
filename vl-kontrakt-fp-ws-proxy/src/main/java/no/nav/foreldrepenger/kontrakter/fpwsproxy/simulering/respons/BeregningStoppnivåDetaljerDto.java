package no.nav.foreldrepenger.kontrakter.fpwsproxy.simulering.respons;

import java.math.BigDecimal;
import java.math.BigInteger;

public record BeregningStoppnivåDetaljerDto(String faktiskFom,
                                            String faktiskTom,
                                            String kontoStreng,
                                            String behandlingskode,
                                            BigDecimal belop,
                                            long trekkVedtakId,
                                            String stonadId,
                                            String korrigering,
                                            boolean tilbakeforing,
                                            BigInteger linjeId,
                                            BigDecimal sats,
                                            String typeSats,
                                            BigDecimal antallSats,
                                            String saksbehId,
                                            BigInteger uforeGrad,
                                            String kravhaverId,
                                            String delytelseId,
                                            String bostedsenhet,
                                            String skykldnerId,
                                            String klassekode,
                                            String klasseKodeBeskrivelse,
                                            String typeKlasse,
                                            String typeKlasseBeskrivelse,
                                            String refunderesOrgNr) {

    private BeregningStoppnivåDetaljerDto(Builder builder) {
        this(builder.faktiskFom,
        builder.faktiskTom,
        builder.kontoStreng,
        builder.behandlingskode,
        builder.belop,
        builder.trekkVedtakId,
        builder.stonadId,
        builder.korrigering,
        builder.tilbakeforing,
        builder.linjeId,
        builder.sats,
        builder.typeSats,
        builder.antallSats,
        builder.saksbehId,
        builder.uforeGrad,
        builder.kravhaverId,
        builder.delytelseId,
        builder.bostedsenhet,
        builder.skykldnerId,
        builder.klassekode,
        builder.klasseKodeBeskrivelse,
        builder.typeKlasse,
        builder.typeKlasseBeskrivelse,
        builder.refunderesOrgNr);
    }

    public static class Builder {
        private String faktiskFom;
        private String faktiskTom;
        private String kontoStreng;
        private String behandlingskode;
        private BigDecimal belop;
        private long trekkVedtakId;
        private String stonadId;
        private String korrigering;
        private boolean tilbakeforing;
        private BigInteger linjeId;
        private BigDecimal sats;
        private String typeSats;
        private BigDecimal antallSats;
        private String saksbehId;
        private BigInteger uforeGrad;
        private String kravhaverId;
        private String delytelseId;
        private String bostedsenhet;
        private String skykldnerId;
        private String klassekode;
        private String klasseKodeBeskrivelse;
        private String typeKlasse;
        private String typeKlasseBeskrivelse;
        private String refunderesOrgNr;

        public Builder() {
        }

        public Builder faktiskFom(String faktiskFom) {
            this.faktiskFom = faktiskFom;
            return this;
        }

        public Builder faktiskTom(String faktiskTom) {
            this.faktiskTom = faktiskTom;
            return this;
        }

        public Builder kontoStreng(String kontoStreng) {
            this.kontoStreng = kontoStreng;
            return this;
        }

        public Builder behandlingskode(String behandlingskode) {
            this.behandlingskode = behandlingskode;
            return this;
        }

        public Builder belop(BigDecimal belop) {
            this.belop = belop;
            return this;
        }

        public Builder trekkVedtakId(long trekkVedtakId) {
            this.trekkVedtakId = trekkVedtakId;
            return this;
        }

        public Builder stonadId(String stonadId) {
            this.stonadId = stonadId;
            return this;
        }

        public Builder korrigering(String korrigering) {
            this.korrigering = korrigering;
            return this;
        }

        public Builder tilbakeforing(boolean tilbakeforing) {
            this.tilbakeforing = tilbakeforing;
            return this;
        }

        public Builder linjeId(BigInteger linjeId) {
            this.linjeId = linjeId;
            return this;
        }

        public Builder sats(BigDecimal sats) {
            this.sats = sats;
            return this;
        }

        public Builder typeSats(String typeSats) {
            this.typeSats = typeSats;
            return this;
        }

        public Builder antallSats(BigDecimal antallSats) {
            this.antallSats = antallSats;
            return this;
        }

        public Builder saksbehId(String saksbehId) {
            this.saksbehId = saksbehId;
            return this;
        }

        public Builder uforeGrad(BigInteger uforeGrad) {
            this.uforeGrad = uforeGrad;
            return this;
        }

        public Builder kravhaverId(String kravhaverId) {
            this.kravhaverId = kravhaverId;
            return this;
        }

        public Builder delytelseId(String delytelseId) {
            this.delytelseId = delytelseId;
            return this;
        }

        public Builder bostedsenhet(String bostedsenhet) {
            this.bostedsenhet = bostedsenhet;
            return this;
        }

        public Builder skykldnerId(String skykldnerId) {
            this.skykldnerId = skykldnerId;
            return this;
        }

        public Builder klassekode(String klassekode) {
            this.klassekode = klassekode;
            return this;
        }

        public Builder klasseKodeBeskrivelse(String klasseKodeBeskrivelse) {
            this.klasseKodeBeskrivelse = klasseKodeBeskrivelse;
            return this;
        }

        public Builder typeKlasse(String typeKlasse) {
            this.typeKlasse = typeKlasse;
            return this;
        }

        public Builder typeKlasseBeskrivelse(String typeKlasseBeskrivelse) {
            this.typeKlasseBeskrivelse = typeKlasseBeskrivelse;
            return this;
        }

        public Builder refunderesOrgNr(String refunderesOrgNr) {
            this.refunderesOrgNr = refunderesOrgNr;
            return this;
        }

        public BeregningStoppnivåDetaljerDto build() throws IllegalStateException {
            return new BeregningStoppnivåDetaljerDto(this);
        }
    }
}
