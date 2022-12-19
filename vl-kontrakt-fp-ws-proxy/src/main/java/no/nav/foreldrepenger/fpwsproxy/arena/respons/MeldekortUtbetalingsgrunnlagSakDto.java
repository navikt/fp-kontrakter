package no.nav.foreldrepenger.fpwsproxy.arena.respons;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public record MeldekortUtbetalingsgrunnlagSakDto(FagsystemDto kilde,
                                                 LocalDate kravMottattDato,
                                                 List<MeldekortUtbetalingsgrunnlagMeldekortDto> meldekortene,
                                                 String sakStatus,
                                                 String saksnummer,
                                                 YtelseStatusDto tilstand,
                                                 YtelseTypeDto type,
                                                 String vedtakStatus,
                                                 BeløpDto vedtaksDagsats,
                                                 LocalDate vedtaksPeriodeFom,
                                                 LocalDate vedtaksPeriodeTom,
                                                 LocalDate vedtattDato) {

    public MeldekortUtbetalingsgrunnlagSakDto {
        meldekortene = Optional.ofNullable(meldekortene).orElse(Collections.emptyList());
    }

    public MeldekortUtbetalingsgrunnlagSakDto(Builder builder) {
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
        private FagsystemDto kilde;
        private LocalDate kravMottattDato;
        private List<MeldekortUtbetalingsgrunnlagMeldekortDto> meldekortene;
        private String sakStatus;
        private String saksnummer;
        private YtelseStatusDto tilstand;
        private YtelseTypeDto type;
        private String vedtakStatus;
        private BeløpDto vedtaksDagsats;
        private LocalDate vedtaksPeriodeFom;
        private LocalDate vedtaksPeriodeTom;
        private LocalDate vedtattDato;

        public Builder() {
        }

        public Builder kilde(FagsystemDto kilde) {
            this.kilde = kilde;
            return this;
        }

        public Builder kravMottattDato(LocalDate kravMottattDato) {
            this.kravMottattDato = kravMottattDato;
            return this;
        }

        public Builder meldekortene(List<MeldekortUtbetalingsgrunnlagMeldekortDto> meldekortene) {
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

        public Builder tilstand(YtelseStatusDto tilstand) {
            this.tilstand = tilstand;
            return this;
        }

        public Builder type(YtelseTypeDto type) {
            this.type = type;
            return this;
        }

        public Builder vedtakStatus(String vedtakStatus) {
            this.vedtakStatus = vedtakStatus;
            return this;
        }

        public Builder vedtaksDagsats(BeløpDto vedtaksDagsats) {
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

        public MeldekortUtbetalingsgrunnlagSakDto build() throws IllegalStateException {
            return new MeldekortUtbetalingsgrunnlagSakDto(this);
        }
    }
}
