package no.nav.foreldrepenger.integrasjon.økonomistøtte.grensesnittavstemming;

import static no.nav.foreldrepenger.integrasjon.økonomistøtte.grensesnittavstemming.GrensesnittavstemmingSkjemaConstants.NAMESPACE;
import static no.nav.foreldrepenger.integrasjon.økonomistøtte.grensesnittavstemming.GrensesnittavstemmingSkjemaConstants.XSD_LOCATION;
import static org.assertj.core.api.Assertions.assertThat;

import javax.xml.transform.stream.StreamSource;

import org.junit.jupiter.api.Test;

class GrensesnittavstemmingSkjemaConstantsTest {

    @Test
    void skal_finne_og_hente_ut_namespace_fra_xsd() throws Exception {
        final StreamSource streamSource = new StreamSource(getClass().getClassLoader().getResourceAsStream(XSD_LOCATION));
        assertThat(XmlUtils.retrieveNameSpaceOfXSD(streamSource)).isEqualTo(NAMESPACE);
    }
}