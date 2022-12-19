package no.nav.foreldrepenger.fpwsproxy.tilbakekreving.kravgrunnlag.respons;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public record Kravgrunnlag431Dto(String eksternKravgrunnlagId,
                                 Long vedtakId,
                                 KravStatusKode kravStatusKode,
                                 FagOmrådeKode fagOmrådeKode,
                                 String fagSystemId,
                                 LocalDate vedtakFagSystemDato,
                                 Long omgjortVedtakId,
                                 String gjelderVedtakId,
                                 GjelderType gjelderType,
                                 String utbetalesTilId,
                                 GjelderType utbetGjelderType,
                                 String hjemmelKode,
                                 String beregnesRenter,
                                 String ansvarligEnhet,
                                 String bostedEnhet,
                                 String behandlendeEnhet,
                                 String kontrollFelt,
                                 String saksBehId,
                                 String referanse,
                                 List<KravgrunnlagPeriode432Dto> perioder) {
    public Kravgrunnlag431Dto {
        perioder = Optional.ofNullable(perioder).orElse(Collections.emptyList());
    }

    public Kravgrunnlag431Dto(Builder builder) {
        this(builder.eksternKravgrunnlagId,
        builder.vedtakId,
        builder.kravStatusKode,
        builder.fagOmrådeKode,
        builder.fagSystemId,
        builder.vedtakFagSystemDato,
        builder.omgjortVedtakId,
        builder.gjelderVedtakId,
        builder.gjelderType,
        builder.utbetalesTilId,
        builder.utbetGjelderType,
        builder.hjemmelKode,
        builder.beregnesRenter,
        builder.ansvarligEnhet,
        builder.bostedEnhet,
        builder.behandlendeEnhet,
        builder.kontrollFelt,
        builder.saksBehId,
        builder.referanse,
        builder.perioder);
    }

    public static class Builder {
        private String eksternKravgrunnlagId;
        private Long vedtakId;
        private KravStatusKode kravStatusKode;
        private FagOmrådeKode fagOmrådeKode;
        private String fagSystemId;
        private LocalDate vedtakFagSystemDato;
        private Long omgjortVedtakId;
        private String gjelderVedtakId;
        private GjelderType gjelderType;
        private String utbetalesTilId;
        private GjelderType utbetGjelderType;
        private String hjemmelKode;
        private String beregnesRenter;
        private String ansvarligEnhet;
        private String bostedEnhet;
        private String behandlendeEnhet;
        private String kontrollFelt;
        private String saksBehId;
        private String referanse;
        private List<KravgrunnlagPeriode432Dto> perioder;

        public Builder() {
        }

        public Builder eksternKravgrunnlagId(String eksternKravgrunnlagId) {
            this.eksternKravgrunnlagId = eksternKravgrunnlagId;
            return this;
        }

        public Builder vedtakId(Long vedtakId) {
            this.vedtakId = vedtakId;
            return this;
        }

        public Builder kravStatusKode(KravStatusKode kravStatusKode) {
            this.kravStatusKode = kravStatusKode;
            return this;
        }

        public Builder fagOmrådeKode(FagOmrådeKode fagOmrådeKode) {
            this.fagOmrådeKode = fagOmrådeKode;
            return this;
        }

        public Builder fagSystemId(String fagSystemId) {
            this.fagSystemId = fagSystemId;
            return this;
        }

        public Builder vedtakFagSystemDato(LocalDate vedtakFagSystemDato) {
            this.vedtakFagSystemDato = vedtakFagSystemDato;
            return this;
        }

        public Builder omgjortVedtakId(Long omgjortVedtakId) {
            this.omgjortVedtakId = omgjortVedtakId;
            return this;
        }

        public Builder gjelderVedtakId(String gjelderVedtakId) {
            this.gjelderVedtakId = gjelderVedtakId;
            return this;
        }

        public Builder gjelderType(GjelderType gjelderType) {
            this.gjelderType = gjelderType;
            return this;
        }

        public Builder utbetalesTilId(String utbetalesTilId) {
            this.utbetalesTilId = utbetalesTilId;
            return this;
        }

        public Builder utbetGjelderType(GjelderType utbetGjelderType) {
            this.utbetGjelderType = utbetGjelderType;
            return this;
        }

        public Builder hjemmelKode(String hjemmelKode) {
            this.hjemmelKode = hjemmelKode;
            return this;
        }

        public Builder beregnesRenter(String beregnesRenter) {
            this.beregnesRenter = beregnesRenter;
            return this;
        }

        public Builder ansvarligEnhet(String ansvarligEnhet) {
            this.ansvarligEnhet = ansvarligEnhet;
            return this;
        }

        public Builder bostedEnhet(String bostedEnhet) {
            this.bostedEnhet = bostedEnhet;
            return this;
        }

        public Builder behandlendeEnhet(String behandlendeEnhet) {
            this.behandlendeEnhet = behandlendeEnhet;
            return this;
        }

        public Builder kontrollFelt(String kontrollFelt) {
            this.kontrollFelt = kontrollFelt;
            return this;
        }

        public Builder saksBehId(String saksBehId) {
            this.saksBehId = saksBehId;
            return this;
        }

        public Builder referanse(String referanse) {
            this.referanse = referanse;
            return this;
        }

        public Builder perioder(List<KravgrunnlagPeriode432Dto> perioder) {
            this.perioder = perioder;
            return this;
        }

        public Kravgrunnlag431Dto build() throws IllegalStateException {
            return new Kravgrunnlag431Dto(this);
        }
    }

    @Override
    public String toString() {
        return "Kravgrunnlag431Dto{" +
                "eksternKravgrunnlagId='" + eksternKravgrunnlagId + '\'' +
                ", vedtakId=" + vedtakId +
                ", kravStatusKode=" + kravStatusKode +
                ", fagOmrådeKode=" + fagOmrådeKode +
                ", fagSystemId='" + fagSystemId + '\'' +
                ", vedtakFagSystemDato=" + vedtakFagSystemDato +
                ", omgjortVedtakId=" + omgjortVedtakId +
                ", gjelderVedtakId=***" +
                ", gjelderType=" + gjelderType +
                ", utbetalesTilId=***" +
                ", utbetGjelderType=" + utbetGjelderType +
                ", hjemmelKode='" + hjemmelKode + '\'' +
                ", beregnesRenter='" + beregnesRenter + '\'' +
                ", ansvarligEnhet='" + ansvarligEnhet + '\'' +
                ", bostedEnhet='" + bostedEnhet + '\'' +
                ", behandlendeEnhet='" + behandlendeEnhet + '\'' +
                ", kontrollFelt='" + kontrollFelt + '\'' +
                ", saksBehId='" + saksBehId + '\'' +
                ", referanse=" + referanse +
                ", perioder=" + perioder +
                '}';
    }
}
