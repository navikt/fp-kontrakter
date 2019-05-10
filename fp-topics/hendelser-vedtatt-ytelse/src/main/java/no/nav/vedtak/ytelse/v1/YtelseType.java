package no.nav.vedtak.ytelse.v1;

import no.nav.vedtak.ytelse.Kodeverk;

public class YtelseType extends Kodeverk {

    public static final YtelseType ENSLIG_FORSØRGER = new YtelseType("EF");
    public static final YtelseType SYKEPENGER = new YtelseType("SP");
    public static final YtelseType SVANGERSKAPSPENGER = new YtelseType("SVP");
    public static final YtelseType FORELDREPENGER = new YtelseType("FP");
    public static final YtelseType ENGANGSSTØNAD = new YtelseType("ES");
    public static final YtelseType PÅRØRENDESYKDOM = new YtelseType("PS");
    public static final YtelseType ARBEIDSAVKLARINGSPENGER = new YtelseType("AAP");
    public static final YtelseType DAGPENGER = new YtelseType("DAG");
    public static final YtelseType UDEFINERT = new YtelseType("-");
    private static final String DISCRIMINATOR = "FAGSAK_YTELSE_TYPE";

    public YtelseType(String kode) {
        super(DISCRIMINATOR, kode);
    }

    @Override
    public void setKodeverk(String kodeverk) {
        if (DISCRIMINATOR.equals(kodeverk)) {
            super.setKodeverk(kodeverk);
        }
    }
}
