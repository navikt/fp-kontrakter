package no.nav.historikk.kodeverk;

public class NavBrukerKjønn extends Kodeverk {

    private static final String DISCRIMINATOR = "BRUKER_KJOENN";

    public static final NavBrukerKjønn KVINNE = new NavBrukerKjønn("K");
    public static final NavBrukerKjønn MANN = new NavBrukerKjønn("M");
    public static final NavBrukerKjønn UDEFINERT = new NavBrukerKjønn("-");

    private NavBrukerKjønn(String kode) {
        super(DISCRIMINATOR, kode);
    }

}

