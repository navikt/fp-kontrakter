package no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.iverksett;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record TilbakekrevingVedtakDTO(@NotNull @Digits(integer = 20, fraction = 0) Long vedtakId,
                                      LocalDate datoVedtakFagsystem,
                                      @NotNull @Pattern(regexp = "^[0-9]{4}$") String enhetAnsvarlig, // Eks: 8020
                                      @NotNull @Pattern(regexp = "^[0-9.-]*$") String kontrollfelt, // Eks: 2020-01-16-22.50.59.293946
                                      @NotNull @Pattern(regexp = "^[\\p{L}0-9\\-]*$") String saksbehId, // Eks: srvfptilbake og srvk9-tilbake
                                      List<@Valid TilbakekrevingsperiodeDTO> tilbakekrevingsperiode) {

    public TilbakekrevingVedtakDTO(Builder builder) {
        this(builder.vedtakId,
        builder.datoVedtakFagsystem,
        builder.enhetAnsvarlig,
        builder.kontrollfelt,
        builder.saksbehId,
        builder.tilbakekrevingsperiode);
    }

    public static class Builder {
        private Long vedtakId;
        private LocalDate datoVedtakFagsystem;
        private String enhetAnsvarlig;
        private String kontrollfelt;
        private String saksbehId;
        private List<TilbakekrevingsperiodeDTO> tilbakekrevingsperiode;

        public Builder() {
        }

        public Builder vedtakId(Long vedtakId) {
            this.vedtakId = vedtakId;
            return this;
        }

        public Builder datoVedtakFagsystem(LocalDate datoVedtakFagsystem) {
            this.datoVedtakFagsystem = datoVedtakFagsystem;
            return this;
        }

        public Builder enhetAnsvarlig(String enhetAnsvarlig) {
            this.enhetAnsvarlig = enhetAnsvarlig;
            return this;
        }

        public Builder kontrollfelt(String kontrollfelt) {
            this.kontrollfelt = kontrollfelt;
            return this;
        }

        public Builder saksbehId(String saksbehId) {
            this.saksbehId = saksbehId;
            return this;
        }

        public Builder tilbakekrevingsperiode(List<TilbakekrevingsperiodeDTO> tilbakekrevingsperiode) {
            this.tilbakekrevingsperiode = tilbakekrevingsperiode;
            return this;
        }

        public TilbakekrevingVedtakDTO build() throws IllegalStateException {
            return new TilbakekrevingVedtakDTO(this);
        }
    }
}
