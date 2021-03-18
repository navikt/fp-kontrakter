package no.nav.foreldrepenger.søknad.v3;

import static no.nav.foreldrepenger.søknad.v3.SøknadConstants.NAMESPACE;
import static no.nav.foreldrepenger.søknad.v3.SøknadConstants.XSD_LOCATION;
import static org.assertj.core.api.Assertions.assertThat;

import javax.xml.transform.stream.StreamSource;

import org.junit.jupiter.api.Test;

import no.nav.foreldrepenger.søknad.util.XmlUtils;

public class SøknadConstantsTest {

    @Test
    public void skal_finne_og_hente_ut_namespace_fra_xsd() throws Exception {
        final StreamSource streamSource = new StreamSource(getClass().getClassLoader().getResourceAsStream(XSD_LOCATION));
        assertThat(XmlUtils.retrieveNameSpaceOfXSD(streamSource)).isEqualTo(NAMESPACE);
    }
}
