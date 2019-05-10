package no.nav.vedtak.ytelse.v1;

import no.nav.vedtak.ytelse.Kodeverk;

public class Fagsystem extends Kodeverk {

    public static final Fagsystem FPSAK = new Fagsystem("FPSAK");
    private static final String DISCRIMINATOR = "FAGSYSTEM";

    public Fagsystem(String kode) {
        super(DISCRIMINATOR, kode);
    }

    @Override
    public void setKodeverk(String kodeverk) {
        if (DISCRIMINATOR.equals(kodeverk)) {
            super.setKodeverk(kodeverk);
        }
    }
}
