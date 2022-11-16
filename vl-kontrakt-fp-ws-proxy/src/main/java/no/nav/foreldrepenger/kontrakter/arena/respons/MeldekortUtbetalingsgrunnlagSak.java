package no.nav.foreldrepenger.kontrakter.arena.respons;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public record MeldekortUtbetalingsgrunnlagSak(Fagsystem kilde,
                                              LocalDate kravMottattDato,
                                              List<MeldekortUtbetalingsgrunnlagMeldekort> meldekortene,
                                              String sakStatus,
                                              String saksnummer,
                                              YtelseStatus tilstand,
                                              YtelseType type,
                                              String vedtakStatus,
                                              Beløp vedtaksDagsats,
                                              LocalDate vedtaksPeriodeFom,
                                              LocalDate vedtaksPeriodeTom,
                                              LocalDate vedtattDato) {

    public MeldekortUtbetalingsgrunnlagSak {
        meldekortene = Optional.ofNullable(meldekortene).orElse(Collections.emptyList());
    }

    public MeldekortUtbetalingsgrunnlagSak(Builder builder) {
        this(builder.kilde,
            builder.kravMottattDato,
            builder.meldekortene,
            builder.sakStatus,
            builder.saksnummer,
            builder.tilstand,
            builder.type,
            builder.vedtakStatus,
            builder.vedtaksDagsats,
            builder.vedtaksPeriodeFom,
            builder.vedtaksPeriodeTom,
            builder.vedtattDato);
    }

    public static class Builder {
        private Fagsystem kilde;
        private LocalDate kravMottattDato;
        private List<MeldekortUtbetalingsgrunnlagMeldekort> meldekortene;
        private String sakStatus;
        private String saksnummer;
        private YtelseStatus tilstand;
        private YtelseType type;
        private String vedtakStatus;
        private Beløp vedtaksDagsats;
        private LocalDate vedtaksPeriodeFom;
        private LocalDate vedtaksPeriodeTom;
        private LocalDate vedtattDato;

        public Builder() {
        }

        public Builder kilde(Fagsystem kilde) {
            this.kilde = kilde;
            return this;
        }

        public Builder kravMottattDato(LocalDate kravMottattDato) {
            this.kravMottattDato = kravMottattDato;
            return this;
        }

        public Builder meldekortene(List<MeldekortUtbetalingsgrunnlagMeldekort> meldekortene) {
            this.meldekortene = meldekortene;
            return this;
        }

        public Builder sakStatus(String sakStatus) {
            this.sakStatus = sakStatus;
            return this;
        }

        public Builder saksnummer(String saksnummer) {
            this.saksnummer = saksnummer;
            return this;
        }

        public Builder tilstand(YtelseStatus tilstand) {
            this.tilstand = tilstand;
            return this;
        }

        public Builder type(YtelseType type) {
            this.type = type;
            return this;
        }

        public Builder vedtakStatus(String vedtakStatus) {
            this.vedtakStatus = vedtakStatus;
            return this;
        }

        public Builder vedtaksDagsats(Beløp vedtaksDagsats) {
            this.vedtaksDagsats = vedtaksDagsats;
            return this;
        }

        public Builder vedtaksPeriodeFom(LocalDate vedtaksPeriodeFom) {
            this.vedtaksPeriodeFom = vedtaksPeriodeFom;
            return this;
        }

        public Builder vedtaksPeriodeTom(LocalDate vedtaksPeriodeTom) {
            this.vedtaksPeriodeTom = vedtaksPeriodeTom;
            return this;
        }

        public Builder vedtattDato(LocalDate vedtattDato) {
            this.vedtattDato = vedtattDato;
            return this;
        }

        public MeldekortUtbetalingsgrunnlagSak build() throws IllegalStateException {
            return new MeldekortUtbetalingsgrunnlagSak(this);
        }
    }
}
