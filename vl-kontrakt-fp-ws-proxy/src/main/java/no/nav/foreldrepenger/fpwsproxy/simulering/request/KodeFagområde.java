package no.nav.foreldrepenger.fpwsproxy.simulering.request;

public enum KodeFagområde {
    REFUTG, //engangsstønad
    FP, //foreldrepenger til bruker
    FPREF, //foreldrepenger til arbeidsgiver
    SVP, //svangerskapspenger til bruker
    SVPREF, //svangerskapspenger til arbeidsgiver
    ;

    public boolean gjelderEngangsstønad() {
        return REFUTG.equals(this);
    }

    public boolean gjelderForeldrepenger() {
        return FP.equals(this) || FPREF.equals(this);
    }

    public boolean gjelderRefusjonTilArbeidsgiver() {
        return FPREF.equals(this) || SVPREF.equals(this);
    }
}
