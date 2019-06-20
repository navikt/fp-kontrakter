package no.nav.foreldrepenger.vedtak.v2;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import no.nav.vedtak.felles.xml.vedtak.v2.Vedtak;


public class ParseVedtakTest {

    @Test
    public void skal_unmarshale_og_marshale_vedtak() throws Exception {
       final InputStream resourceAsStream = getClass().getResourceAsStream("/vedtak_svp_innvilget-v2.xml");
        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (resourceAsStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
        }

        assertThat(textBuilder).isNotNull();

        Vedtak vedtak = JaxbHelper.unmarshalAndValidateXMLWithStAX(Vedtak.class,
                textBuilder.toString(),
                "xsd/vedtak-v2.xsd", new String[]{
                        "xsd/beregningsgrunnlag/beregningsgrunnlag-svp-v2.xsd",
                        "xsd/oppdrag/oppdrag-dvh-fp-v2.xsd",
                        "xsd/personopplysninger/personopplysninger-svp-v2.xsd",
                        "xsd/uttak/uttak-svp-v2.xsd",
                        "xsd/vilkaarsgrunnlag/vilkaarsgrunnlag-svp-v2.xsd",
                        "xsd/ytelse/ytelse-svp-v2.xsd"},
                VedtakConstants.ADDITIONAL_CLASSES);

        assertThat(vedtak).isNotNull();
        assertThat(vedtak.getPersonOpplysninger().getAny()).isNotEmpty();

        String xml = JaxbHelper.marshalAndValidateJaxb(VedtakConstants.JAXB_CLASS,vedtak,
                "xsd/vedtak-v2.xsd", new String[]{
                        "xsd/beregningsgrunnlag/beregningsgrunnlag-svp-v2.xsd",
                        "xsd/oppdrag/oppdrag-dvh-fp-v2.xsd",
                        "xsd/personopplysninger/personopplysninger-svp-v2.xsd",
                        "xsd/uttak/uttak-svp-v2.xsd",
                        "xsd/vilkaarsgrunnlag/vilkaarsgrunnlag-svp-v2.xsd",
                        "xsd/ytelse/ytelse-svp-v2.xsd"},
                VedtakConstants.ADDITIONAL_CLASSES);

        assertThat(xml).isNotBlank();

    }


}
