package no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.iverksett;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record TilbakekrevingsbelopDTO(@NotNull @Pattern(regexp = "^[\\p{L}0-9_-]*$") String kodeKlasse, // Eks: FPADATORD, KL_KODE_FEIL_KORTTID, FPSND-OP, SPSND100D1DAGPFI
                                      @NotNull @Digits(integer = 8, fraction = 2) BigDecimal belopOpprUtbet,
                                      @NotNull @Digits(integer = 8, fraction = 2) BigDecimal belopNy,
                                      @Digits(integer = 8, fraction = 2) BigDecimal belopTilbakekreves,
                                      @Digits(integer = 8, fraction = 2) BigDecimal belopUinnkrevd,
                                      @Digits(integer = 8, fraction = 2) BigDecimal belopSkatt,
                                      KodeResultat kodeResultat,
                                      KodeÅrsak kodeAarsak,
                                      KodeSkyld kodeSkyld) {

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
        private KodeResultat kodeResultat;
        private KodeÅrsak kodeAarsak;
        private KodeSkyld kodeSkyld;

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

        public Builder kodeResultat(KodeResultat kodeResultat) {
            this.kodeResultat = kodeResultat;
            return this;
        }

        public Builder kodeAarsak(KodeÅrsak kodeAarsak) {
            this.kodeAarsak = kodeAarsak;
            return this;
        }

        public Builder kodeSkyld(KodeSkyld kodeSkyld) {
            this.kodeSkyld = kodeSkyld;
            return this;
        }

        public TilbakekrevingsbelopDTO build() throws IllegalStateException {
            return new TilbakekrevingsbelopDTO(this);
        }
    }
}
