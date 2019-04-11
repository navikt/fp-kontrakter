package no.nav.vedtak.ytelse.v1;

import no.nav.vedtak.ytelse.Kodeverk;

public class YtelseStatus extends Kodeverk {

    public static final YtelseStatus ÅPEN = new YtelseStatus("ÅPEN");
    public static final YtelseStatus LØPENDE = new YtelseStatus("LØPENDE");
    public static final YtelseStatus AVSLUTTET = new YtelseStatus("AVSLUTTET");
    public static final YtelseStatus IKKE_STARTET = new YtelseStatus("IKKESTARTET");
    public static final YtelseStatus UDEFINERT = new YtelseStatus("-");
    private static final String DISCRIMINATOR = "RELATERT_YTELSE_TILSTAND";

    private YtelseStatus(String kode) {
        super(DISCRIMINATOR, kode);
    }

    @Override
    public void setKodeverk(String kodeverk) {
        if (DISCRIMINATOR.equals(kodeverk)) {
            super.setKodeverk(kodeverk);
        }
    }
}
