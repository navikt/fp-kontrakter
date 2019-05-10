package no.nav.vedtak.ytelse.v1;

import no.nav.vedtak.ytelse.Kodeverk;

public class YtelseStatus extends Kodeverk {

    public static final YtelseStatus OPPRETTET = new YtelseStatus("OPPR");
    public static final YtelseStatus UNDER_BEHANDLING = new YtelseStatus("UBEH");
    public static final YtelseStatus LØPENDE = new YtelseStatus("LOP");
    public static final YtelseStatus AVSLUTTET = new YtelseStatus("AVSLU");
    private static final String DISCRIMINATOR = "YTELSE_STATUS";

    public YtelseStatus(String kode) {
        super(DISCRIMINATOR, kode);
    }

    @Override
    public void setKodeverk(String kodeverk) {
        if (DISCRIMINATOR.equals(kodeverk)) {
            super.setKodeverk(kodeverk);
        }
    }
}
