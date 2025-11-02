package no.nav.foreldrepenger.vedtak.v2;

import static no.nav.foreldrepenger.vedtak.v2.VedtakConstants.NAMESPACE;
import static no.nav.foreldrepenger.vedtak.v2.VedtakConstants.XSD_LOCATION;
import static org.assertj.core.api.Assertions.assertThat;

import javax.xml.transform.stream.StreamSource;

import org.junit.jupiter.api.Test;

class VedtakConstantsTest {

    @Test
    void skal_finne_og_hente_ut_namespace_fra_xsd() throws Exception {
        final StreamSource streamSource = new StreamSource(getClass().getClassLoader().getResourceAsStream(XSD_LOCATION));
        assertThat(XmlUtils.retrieveNameSpaceOfXSD(streamSource)).isEqualTo(NAMESPACE);
    }

}