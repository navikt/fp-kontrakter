package no.nav.vedtak.ytelse.v1;

import no.nav.vedtak.ytelse.Kodeverk;

public class Fagsystem extends Kodeverk {

    public static final Fagsystem FPSAK = new Fagsystem("FPSAK");
    public static final Fagsystem TPS = new Fagsystem("TPS");
    public static final Fagsystem JOARK = new Fagsystem("JOARK");
    public static final Fagsystem INFOTRYGD = new Fagsystem("INFOTRYGD");
    public static final Fagsystem ARENA = new Fagsystem("ARENA");
    public static final Fagsystem INNTEKT = new Fagsystem("INNTEKT");
    public static final Fagsystem MEDL = new Fagsystem("MEDL");
    public static final Fagsystem GOSYS = new Fagsystem("GOSYS");
    public static final Fagsystem ENHETSREGISTERET = new Fagsystem("ENHETSREGISTERET");
    public static final Fagsystem AAREGISTERET = new Fagsystem("AAREGISTERET");
    public static final Fagsystem UDEFINERT = new Fagsystem("-");
    private static final String DISCRIMINATOR = "FAGSYSTEM";

    private Fagsystem(String kode) {
        super(DISCRIMINATOR, kode);
    }

    @Override
    public void setKodeverk(String kodeverk) {
        if (DISCRIMINATOR.equals(kodeverk)) {
            super.setKodeverk(kodeverk);
        }
    }
}
