package no.nav.vedtak.ytelse.v1.anvisning;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.vedtak.ytelse.Desimaltall;
import no.nav.vedtak.ytelse.Periode;

public class Anvisning {

    @NotNull
    @Valid
    @JsonProperty("periode")
    private Periode periode;

    @JsonProperty("beløp")
    private Desimaltall beløp;

    @JsonProperty("dagsats")
    private Desimaltall dagsats;

    @JsonProperty("utbetalingsgrad")
    private Desimaltall utbetalingsgrad;

    public Anvisning() {
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public Desimaltall getBeløp() {
        return beløp;
    }

    public void setBeløp(Desimaltall beløp) {
        this.beløp = beløp;
    }

    public Desimaltall getDagsats() {
        return dagsats;
    }

    public void setDagsats(Desimaltall dagsats) {
        this.dagsats = dagsats;
    }

    public Desimaltall getUtbetalingsgrad() {
        return utbetalingsgrad;
    }

    public void setUtbetalingsgrad(Desimaltall utbetalingsgrad) {
        this.utbetalingsgrad = utbetalingsgrad;
    }
}
