package no.nav.foreldrepenger.kontrakter.simulering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Fagområde {
    /** engangsstønad **/
    REFUTG,
    /** foreldrepenger **/
    FP,
    /** foreldrepenger til arbeidsgiver **/
    FPREF,
    /** sykepenger **/
    SP,
    /** sykepenger til arbeidsgiver **/
    SPREF,
    /** svangerskapspenger **/
    SVP,
    /** svangerskapspenger til arbeidsgiver **/
    SVPREF,
    /** pleiepenger sykt barn **/
    PB,
    /** pleiepenger sykt barn til arbeidsgiver **/
    PBREF,
    /** pleiepenger nærstående **/
    PN,
    /** pleiepenger nærstående til arbeidsgiver **/
    PNREF,
    /** omsorgspenger **/
    OM,
    /** omsorgspenger til arbeidsgiver **/
    OMREF,
    /** opplæringspenger **/
    OPP,
    /** opplæringspenger til arbeidsgiver **/
    OPPREF,
    /** pleiepenger_v1 **/
    OOP,
    /** pleiepenger_v1 til arbeidsgiver **/
    OOPREF,
    ;

    private static final Logger LOG = LoggerFactory.getLogger(Fagområde.class);

    public static Fagområde fraKode(String kode) {
        try {
            return Fagområde.valueOf(kode);
        } catch (IllegalArgumentException ex) {
            LOG.warn("Finner ikke FagOmrådeKode for {}", kode);
            throw ex;
        }
    }

    public static Fagområde utledFra(YtelseType ytelseType) {
        return switch (ytelseType) {
            case FP -> Fagområde.FP;
            case SVP -> Fagområde.SVP;
            case ES -> Fagområde.REFUTG;
            default -> throw new IllegalArgumentException("Utvikler-feil: Mangler mapping mellom ytelsetype og FagOmrådeKode for bruker. Ytelsetype=" + ytelseType);
        };
    }
}
