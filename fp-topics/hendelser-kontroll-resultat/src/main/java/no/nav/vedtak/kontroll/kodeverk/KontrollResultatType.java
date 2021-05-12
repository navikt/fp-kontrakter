package no.nav.vedtak.kontroll.kodeverk;

public enum KontrollResultatType {
    HØY("HOY"),
    IKKE_HØY("IKKE_HOY"),
    IKKE_KLASSIFISERT("IKKE_KLASSIFISERT");

    private final String kontrollName;

    private KontrollResultatType(String kontrollName) {
        this.kontrollName = kontrollName;
    }

    public String toString() {
        return this.kontrollName;
    }
}
