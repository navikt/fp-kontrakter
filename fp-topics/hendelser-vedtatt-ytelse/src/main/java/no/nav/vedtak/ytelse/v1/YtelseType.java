package no.nav.vedtak.ytelse.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.vedtak.ytelse.Kodeverk;

public class YtelseType extends Kodeverk {

    /** Folketrygdloven K4 ytelser. */
    public static final YtelseType DAGPENGER = new YtelseType("DAG");//$NON-NLS-1$

    /** Folketrygdloven K8 ytelser. */
    public static final YtelseType SYKEPENGER = new YtelseType("SP");//$NON-NLS-1$

    /** Folketrygdloven K9 ytelser. */
    public static final YtelseType PLEIEPENGER_SYKT_BARN = new YtelseType("PSB");
    public static final YtelseType PLEIEPENGER_NÆRSTÅENDE = new YtelseType("PPN");
    public static final YtelseType OMSORGSPENGER = new YtelseType("OMP");
    public static final YtelseType OPPLÆRINGSPENGER = new YtelseType("OLP");

    /** Folketrygdloven K11 ytelser. */
    public static final YtelseType ARBEIDSAVKLARINGSPENGER = new YtelseType("AAP");//$NON-NLS-1$

    /** Folketrygdloven K14 ytelser. */
    public static final YtelseType ENGANGSTØNAD = new YtelseType("ES"); //$NON-NLS-1$
    public static final YtelseType FORELDREPENGER = new YtelseType("FP"); //$NON-NLS-1$
    public static final YtelseType SVANGERSKAPSPENGER = new YtelseType("SVP"); //$NON-NLS-1$

    /** Folketrygdloven K15 ytelser. */
    public static final YtelseType ENSLIG_FORSØRGER = new YtelseType("EF");//$NON-NLS-1$

    private static final String DISCRIMINATOR = "FAGSAK_YTELSE_TYPE";

    @JsonCreator
    public YtelseType(@JsonProperty(value = "kode", required = true) String kode) {
        super(DISCRIMINATOR, kode);
    }

    @Override
    public void setKodeverk(String kodeverk) {
        if (DISCRIMINATOR.equals(kodeverk)) {
            super.setKodeverk(kodeverk);
        }
    }
}
