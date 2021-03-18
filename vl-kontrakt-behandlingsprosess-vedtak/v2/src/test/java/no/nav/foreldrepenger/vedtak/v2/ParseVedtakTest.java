package no.nav.foreldrepenger.vedtak.v2;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import no.nav.vedtak.felles.xml.felles.v2.DateOpplysning;
import no.nav.vedtak.felles.xml.felles.v2.KodeverksOpplysning;
import no.nav.vedtak.felles.xml.felles.v2.LongOpplysning;
import no.nav.vedtak.felles.xml.vedtak.beregningsgrunnlag.svp.v2.BeregningsgrunnlagSvangerskapspenger;
import no.nav.vedtak.felles.xml.vedtak.v2.Behandlingsresultat;
import no.nav.vedtak.felles.xml.vedtak.v2.Behandlingstype;
import no.nav.vedtak.felles.xml.vedtak.v2.Beregningsgrunnlag;
import no.nav.vedtak.felles.xml.vedtak.v2.Beregningsresultat;
import no.nav.vedtak.felles.xml.vedtak.v2.TilkjentYtelse;
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

    @Test
    public void skal_marshalle_til_xml() throws Exception {
        LocalDate dato = LocalDate.now();

        Vedtak vedtak = new Vedtak();

        vedtak.setVedtaksdato(dato);
        vedtak.setSoeknadsdato(dato.minusDays(10));
        vedtak.setKlagedato(dato.plusDays(12));

        vedtak.setFagsakAnnenForelderId("AnnenForelderId");
        vedtak.setAnsvarligBeslutterIdent("AnsvarligBeslutterIdent");
        vedtak.setAnsvarligSaksbehandlerIdent("AnsvarligSaksbehandlerIdent");
        vedtak.setBehandlendeEnhet("BehandlendeEnhet");


        no.nav.vedtak.felles.xml.vedtak.v2.Beregningsresultat beregningsresultat = new no.nav.vedtak.felles.xml.vedtak.v2.Beregningsresultat();


        setBeregningsgrunnlag(beregningsresultat);
        TilkjentYtelse tilkjentYtelse = new TilkjentYtelse();

        beregningsresultat.setTilkjentYtelse(tilkjentYtelse);

        Behandlingsresultat behandlingsresultat = new Behandlingsresultat();
        behandlingsresultat.setBehandlingsId("1");
        behandlingsresultat.setBehandlingsresultat(lagKodeverkOpplysning("05","Behandlingsresultat"));
        behandlingsresultat.setBehandlingstype(Behandlingstype.FOERSTEGANGSSOEKNAD);
        behandlingsresultat.setBeregningsresultat(beregningsresultat);

        vedtak.setBehandlingsresultat(behandlingsresultat);

        vedtak.setFagsakId("FagsakId");
        vedtak.setFagsakType(lagKodeverkOpplysning("01","FagsakType"));
        vedtak.setTema(lagKodeverkOpplysning("02","tema"));
        vedtak.setBehandlingsTema(lagKodeverkOpplysning("03","BehandlingsTema"));

        no.nav.vedtak.felles.xml.vedtak.v2.Personopplysninger personopplysninger = new no.nav.vedtak.felles.xml.vedtak.v2.Personopplysninger();

        vedtak.setPersonOpplysninger(personopplysninger);

        vedtak.setVedtaksresultat(lagKodeverkOpplysning("04","Vedtaksresultat"));



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

    public static KodeverksOpplysning lagKodeverkOpplysning(String kode, String  navn) {

        KodeverksOpplysning kodeverksOpplysning = new KodeverksOpplysning();
        kodeverksOpplysning.setKode(kode);
        kodeverksOpplysning.setValue(navn);
        return kodeverksOpplysning;
    }



    public void setBeregningsgrunnlag(Beregningsresultat beregningsresultat) {

        no.nav.vedtak.felles.xml.vedtak.beregningsgrunnlag.svp.v2.ObjectFactory   beregningsgrunnlagObjectFactory =  new no.nav.vedtak.felles.xml.vedtak.beregningsgrunnlag.svp.v2.ObjectFactory();
        BeregningsgrunnlagSvangerskapspenger beregningsgrunnlagSvangerskapspenger = beregningsgrunnlagObjectFactory.createBeregningsgrunnlagSvangerskapspenger();


        //  BeregningsgrunnlagSvangerskapspenger beregningsgrunnlagSvangerskapspenger = new BeregningsgrunnlagSvangerskapspenger();

        LongOpplysning longOpplysning = new LongOpplysning();
        longOpplysning.setValue(1);
        beregningsgrunnlagSvangerskapspenger.setDekningsgrad(longOpplysning);

        beregningsgrunnlagSvangerskapspenger.setSkjaeringstidspunkt(lagDateOpplysning(LocalDate.now()));

        no.nav.vedtak.felles.xml.vedtak.v2.Beregningsgrunnlag beregningsgrunnlag1 = new Beregningsgrunnlag();
        beregningsgrunnlag1.getAny().add(beregningsgrunnlagSvangerskapspenger);
        beregningsresultat.setBeregningsgrunnlag(beregningsgrunnlag1);
    }
    public static DateOpplysning lagDateOpplysning(LocalDate localDate) {

        DateOpplysning dateOpplysning = new DateOpplysning();
        dateOpplysning.setValue(localDate);
        return dateOpplysning;
    }

}
