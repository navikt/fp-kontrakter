package no.nav.foreldrepenger.søknad.v2;

import no.nav.vedtak.felles.xml.soeknad.endringssoeknad.v2.Endringssoeknad;
import no.nav.vedtak.felles.xml.soeknad.engangsstoenad.v2.Engangsstønad;
import no.nav.vedtak.felles.xml.soeknad.foreldrepenger.v2.Foreldrepenger;
import no.nav.vedtak.felles.xml.soeknad.foreldrepenger.v2.ObjectFactory;

public final class SøknadConstants {
    public static final String NAMESPACE = "urn:no:nav:vedtak:felles:xml:soeknad:v2";
    public static final String YTELSE_IDENTIFIER = "omYtelse";
    public static final String XSD_LOCATION = "xsd/soeknad-v2.xsd";
    public static final String[] ADDITIONAL_XSD_LOCATION = new String[]{
            "xsd/foreldrepenger/foreldrepenger-v2.xsd",
            "xsd/endringssoeknad/endringssoeknad-v2.xsd",
            "xsd/engangsstoenad/engangsstoenad-v2.xsd"};
    public static final Class<?> JAXB_CLASS = no.nav.vedtak.felles.xml.soeknad.v2.Soeknad.class;
    public static final Class<?>[] ADDITIONAL_CLASSES = {Foreldrepenger.class, Engangsstønad.class, Endringssoeknad.class, ObjectFactory.class, no.nav.vedtak.felles.xml.soeknad.endringssoeknad.v2.ObjectFactory.class, no.nav.vedtak.felles.xml.soeknad.engangsstoenad.v2.ObjectFactory.class};

    private SøknadConstants() {
    }

}
