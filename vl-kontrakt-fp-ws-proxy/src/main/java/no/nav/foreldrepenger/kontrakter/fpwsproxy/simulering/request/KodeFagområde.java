package no.nav.foreldrepenger.kontrakter.fpwsproxy.simulering.request;

public enum KodeFagområde {
    REFUTG, //engangsstønad
    FP, //foreldrepenger til bruker
    FPREF, //foreldrepenger til arbeidsgiver
    SVP, //svangerskapspenger til bruker
    SVPREF, //svangerskapspenger til arbeidsgiver

    PB, // For pleiepenger sykt barn, bruker
    PBREF, // For pleiepenger sykt barn, arbeidsgiver

    PN, // For pleiepenger i livets sluttfase (tidligere kalt pleiepenger nærstående), bruker
    PNREF, // For pleiepenger i livets sluttfase (tidligere kalt pleiepenger nærstående), arbeidsgiver

    OM, // For omsorgspenger, bruker
    OMREF, // For omsorgspenger, arbeidsgiver

    OPP, // For opplæringspenger, bruker
    OPPREF, // For opplæringspenger, arbeidsgiver

    FRISINN, //Koronakompensasjon Frilansere og Selvstendig næringsdrivende;

    ;

    public boolean gjelderEngangsstønad() {
        return REFUTG.equals(this);
    }

    public boolean gjelderForeldrepenger() {
        return FP.equals(this) || FPREF.equals(this);
    }

    public boolean gjelderRefusjonTilArbeidsgiver() {
        return FPREF.equals(this) || SVPREF.equals(this) || PBREF.equals(this) || PNREF.equals(this) || OMREF.equals(this) || OPPREF.equals(this);
    }
}
