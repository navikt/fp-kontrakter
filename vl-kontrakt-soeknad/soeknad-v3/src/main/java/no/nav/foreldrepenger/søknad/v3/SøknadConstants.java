package no.nav.foreldrepenger.søknad.v3;

import no.nav.vedtak.felles.xml.soeknad.endringssoeknad.v3.Endringssoeknad;
import no.nav.vedtak.felles.xml.soeknad.engangsstoenad.v3.Engangsstønad;
import no.nav.vedtak.felles.xml.soeknad.foreldrepenger.v3.Foreldrepenger;
import no.nav.vedtak.felles.xml.soeknad.foreldrepenger.v3.ObjectFactory;

public final class SøknadConstants {
    public static final String NAMESPACE = "urn:no:nav:vedtak:felles:xml:soeknad:v3";
    public static final String YTELSE_IDENTIFIER = "omYtelse";
    public static final String XSD_LOCATION = "xsd/soeknad-v3.xsd";
    public static final String[] ADDITIONAL_XSD_LOCATION = new String[]{
            "xsd/foreldrepenger/foreldrepenger-v3.xsd",
            "xsd/endringssoeknad/endringssoeknad-v3.xsd",
            "xsd/engangsstoenad/engangsstoenad-v3.xsd"};
    public static final Class<?> JAXB_CLASS = no.nav.vedtak.felles.xml.soeknad.v3.Soeknad.class;
    public static final Class<?>[] ADDITIONAL_CLASSES = {Foreldrepenger.class, Engangsstønad.class, Endringssoeknad.class, ObjectFactory.class, no.nav.vedtak.felles.xml.soeknad.endringssoeknad.v3.ObjectFactory.class, no.nav.vedtak.felles.xml.soeknad.engangsstoenad.v3.ObjectFactory.class};

    private SøknadConstants() {
    }

}
