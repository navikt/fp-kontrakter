package no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1;

import java.time.Year;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TilkjentYtelseFeriepengerV1 {

    @JsonProperty("opptjeningsaar")
    private int opptjeningsår;

    @JsonProperty("beloep")
    private long beløp;

    TilkjentYtelseFeriepengerV1() {
        //for jackson
    }

    public TilkjentYtelseFeriepengerV1(Year år, long beløp) {
        this.opptjeningsår = år.getValue();
        this.beløp = beløp;
    }

    public int getOpptjeningsår() {
        return opptjeningsår;
    }

    public long getBeløp() {
        return beløp;
    }

    void setOpptjeningsår(int opptjeningsår) {
        this.opptjeningsår = opptjeningsår;
    }

    void setBeløp(long beløp) {
        this.beløp = beløp;
    }
}
