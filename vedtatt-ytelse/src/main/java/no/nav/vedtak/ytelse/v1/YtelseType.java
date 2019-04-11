package no.nav.vedtak.ytelse.v1;

import no.nav.vedtak.ytelse.Kodeverk;

public class YtelseType extends Kodeverk {

    public static final YtelseType ENSLIG_FORSØRGER = new YtelseType("ENSLIG_FORSØRGER");
    public static final YtelseType SYKEPENGER = new YtelseType("SYKEPENGER");
    public static final YtelseType SVANGERSKAPSPENGER = new YtelseType("SVANGERSKAPSPENGER");
    public static final YtelseType FORELDREPENGER = new YtelseType("FORELDREPENGER");
    public static final YtelseType ENGANGSSTØNAD = new YtelseType("ENGANGSSTØNAD");
    public static final YtelseType PÅRØRENDESYKDOM = new YtelseType("PÅRØRENDESYKDOM");
    public static final YtelseType ARBEIDSAVKLARINGSPENGER = new YtelseType("ARBEIDSAVKLARINGSPENGER");
    public static final YtelseType DAGPENGER = new YtelseType("DAGPENGER");
    public static final YtelseType UDEFINERT = new YtelseType("-");
    private static final String DISCRIMINATOR = "RELATERT_YTELSE_TYPE";

    private YtelseType(String kode) {
        super(DISCRIMINATOR, kode);
    }

    @Override
    public void setKodeverk(String kodeverk) {
        if (DISCRIMINATOR.equals(kodeverk)) {
            super.setKodeverk(kodeverk);
        }
    }
}
