package no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.iverksett;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record TilbakekrevingsbelopDTO(@NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String kodeKlasse,
                                      @NotNull @Digits(integer = 8, fraction = 2) BigDecimal belopOpprUtbet,
                                      @NotNull @Digits(integer = 8, fraction = 2) BigDecimal belopNy,
                                      @Digits(integer = 8, fraction = 2) BigDecimal belopTilbakekreves,
                                      @Digits(integer = 8, fraction = 2) BigDecimal belopUinnkrevd,
                                      @Digits(integer = 8, fraction = 2) BigDecimal belopSkatt,
                                      @NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String kodeResultat,
                                      @NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String kodeAarsak,
                                      @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String kodeSkyld) {

    public TilbakekrevingsbelopDTO(Builder builder) {
        this(builder.kodeKlasse,
            builder.belopOpprUtbet,
            builder.belopNy,
            builder.belopTilbakekreves,
            builder.belopUinnkrevd,
            builder.belopSkatt,
            builder.kodeResultat,
            builder.kodeAarsak,
            builder.kodeSkyld);
    }

    public static class Builder {
        private String kodeKlasse;
        private BigDecimal belopOpprUtbet;
        private BigDecimal belopNy;
        private BigDecimal belopTilbakekreves;
        private BigDecimal belopUinnkrevd;
        private BigDecimal belopSkatt;
        private String kodeResultat;
        private String kodeAarsak;
        private String kodeSkyld;

        public Builder() {
        }

        public Builder kodeKlasse(String kodeKlasse) {
            this.kodeKlasse = kodeKlasse;
            return this;
        }

        public Builder belopOpprUtbet(BigDecimal belopOpprUtbet) {
            this.belopOpprUtbet = belopOpprUtbet;
            return this;
        }

        public Builder belopNy(BigDecimal belopNy) {
            this.belopNy = belopNy;
            return this;
        }

        public Builder belopTilbakekreves(BigDecimal belopTilbakekreves) {
            this.belopTilbakekreves = belopTilbakekreves;
            return this;
        }

        public Builder belopUinnkrevd(BigDecimal belopUinnkrevd) {
            this.belopUinnkrevd = belopUinnkrevd;
            return this;
        }

        public Builder belopSkatt(BigDecimal belopSkatt) {
            this.belopSkatt = belopSkatt;
            return this;
        }

        public Builder kodeResultat(String kodeResultat) {
            this.kodeResultat = kodeResultat;
            return this;
        }

        public Builder kodeAarsak(String kodeAarsak) {
            this.kodeAarsak = kodeAarsak;
            return this;
        }

        public Builder kodeSkyld(String kodeSkyld) {
            this.kodeSkyld = kodeSkyld;
            return this;
        }

        public TilbakekrevingsbelopDTO build() throws IllegalStateException {
            return new TilbakekrevingsbelopDTO(this);
        }
    }
}
