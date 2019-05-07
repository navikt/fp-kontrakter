package no.nav.vedtak.felles.dokumentbestilling.kodeverk;

public class FagsakYtelseType extends Kodeverk {

    public static final String DISCRIMINATOR = "FAGSAK_YTELSE"; //$NON-NLS-1$

    public static final FagsakYtelseType ENGANGSTØNAD = new FagsakYtelseType("ES"); //$NON-NLS-1$
    public static final FagsakYtelseType FORELDREPENGER = new FagsakYtelseType("FP"); //$NON-NLS-1$
    public static final FagsakYtelseType ENDRING_FORELDREPENGER = new FagsakYtelseType("ENDRING_FP"); //$NON-NLS-1$
    public static final FagsakYtelseType SVANGERSKAPSPENGER = new FagsakYtelseType("SVP"); //$NON-NLS-1$

    private FagsakYtelseType(String kode) {
        super(DISCRIMINATOR, kode);
    }

}
