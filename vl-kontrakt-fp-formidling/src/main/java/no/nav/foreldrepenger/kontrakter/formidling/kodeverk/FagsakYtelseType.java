package no.nav.foreldrepenger.kontrakter.formidling.kodeverk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FagsakYtelseType extends Kodeverk {

    private static final String DISCRIMINATOR = "FAGSAK_YTELSE"; //$NON-NLS-1$

    /** Folketrygdloven K4 ytelser. */
    public static final FagsakYtelseType DAGPENGER = new FagsakYtelseType("DAG");//$NON-NLS-1$

    /** Folketrygdloven K8 ytelser. */
    public static final FagsakYtelseType SYKEPENGER = new FagsakYtelseType("SP");//$NON-NLS-1$

    /** Folketrygdloven K9 ytelser. */
    public static final FagsakYtelseType PLEIEPENGER_SYKT_BARN = new FagsakYtelseType("PSB");
    public static final FagsakYtelseType PLEIEPENGER_NÆRSTÅENDE = new FagsakYtelseType("PPN");
    public static final FagsakYtelseType OMSORGSPENGER = new FagsakYtelseType("OMP");
    public static final FagsakYtelseType OPPLÆRINGSPENGER = new FagsakYtelseType("OLP");

    /** Folketrygdloven K11 ytelser. */
    public static final FagsakYtelseType ARBEIDSAVKLARINGSPENGER = new FagsakYtelseType("AAP");//$NON-NLS-1$

    /** Folketrygdloven K14 ytelser. */
    public static final FagsakYtelseType ENGANGSTØNAD = new FagsakYtelseType("ES"); //$NON-NLS-1$
    public static final FagsakYtelseType FORELDREPENGER = new FagsakYtelseType("FP"); //$NON-NLS-1$
    public static final FagsakYtelseType SVANGERSKAPSPENGER = new FagsakYtelseType("SVP"); //$NON-NLS-1$

    /** Folketrygdloven K15 ytelser. */
    public static final FagsakYtelseType ENSLIG_FORSØRGER = new FagsakYtelseType("EF");//$NON-NLS-1$

    @JsonCreator
    public FagsakYtelseType(@JsonProperty("kode") String kode) {
        super(DISCRIMINATOR, kode);
    }

}
