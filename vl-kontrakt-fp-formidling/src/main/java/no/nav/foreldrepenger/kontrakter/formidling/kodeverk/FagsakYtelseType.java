package no.nav.foreldrepenger.kontrakter.formidling.kodeverk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FagsakYtelseType extends Kodeverk {

    private static final String DISCRIMINATOR = "FAGSAK_YTELSE"; //$NON-NLS-1$

    public static final FagsakYtelseType ENGANGSTØNAD = new FagsakYtelseType("ES"); //$NON-NLS-1$
    public static final FagsakYtelseType FORELDREPENGER = new FagsakYtelseType("FP"); //$NON-NLS-1$
    public static final FagsakYtelseType SVANGERSKAPSPENGER = new FagsakYtelseType("SVP"); //$NON-NLS-1$

    @JsonCreator
    private FagsakYtelseType(@JsonProperty("kode") String kode) {
        super(DISCRIMINATOR, kode);
    }

}
