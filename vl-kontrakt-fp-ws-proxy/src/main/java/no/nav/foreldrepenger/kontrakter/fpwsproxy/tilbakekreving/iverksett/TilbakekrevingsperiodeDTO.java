package no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.iverksett;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.kravgrunnlag.respons.Periode;

public record TilbakekrevingsperiodeDTO(@Valid @NotNull Periode periode,
                                        @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String renterBeregnes,
                                        @Digits(integer = 8, fraction = 2) BigDecimal belopRenter,
                                        @Valid @NotNull @Size List<@Valid @NotNull TilbakekrevingsbelopDTO> tilbakekrevingsbelop) {

    public TilbakekrevingsperiodeDTO(Builder builder) {
        this(builder.periode, builder.renterBeregnes, builder.belopRenter, builder.tilbakekrevingsbelop);
    }

    public static class Builder {
        private Periode periode;
        private String renterBeregnes;
        private BigDecimal belopRenter;
        private List<TilbakekrevingsbelopDTO> tilbakekrevingsbelop;

        public Builder() {
        }

        public Builder periode(Periode periode) {
            this.periode = periode;
            return this;
        }

        public Builder renterBeregnes(String renterBeregnes) {
            this.renterBeregnes = renterBeregnes;
            return this;
        }

        public Builder belopRenter(BigDecimal belopRenter) {
            this.belopRenter = belopRenter;
            return this;
        }

        public Builder tilbakekrevingsbelop(List<TilbakekrevingsbelopDTO> tilbakekrevingsbelop) {
            this.tilbakekrevingsbelop = tilbakekrevingsbelop;
            return this;
        }

        public TilbakekrevingsperiodeDTO build() throws IllegalStateException {
            return new TilbakekrevingsperiodeDTO(this);
        }
    }
}
