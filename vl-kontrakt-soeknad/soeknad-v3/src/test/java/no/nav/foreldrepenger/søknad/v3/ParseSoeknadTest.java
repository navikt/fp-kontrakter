package no.nav.foreldrepenger.søknad.v3;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import javax.xml.bind.JAXBElement;
import org.junit.jupiter.api.Test;

import no.nav.foreldrepenger.søknad.util.JaxbHelper;
import no.nav.vedtak.felles.xml.soeknad.felles.v3.Bruker;
import no.nav.vedtak.felles.xml.soeknad.felles.v3.Foedsel;
import no.nav.vedtak.felles.xml.soeknad.felles.v3.Medlemskap;
import no.nav.vedtak.felles.xml.soeknad.felles.v3.OppholdNorge;
import no.nav.vedtak.felles.xml.soeknad.felles.v3.Periode;
import no.nav.vedtak.felles.xml.soeknad.felles.v3.Rettigheter;
import no.nav.vedtak.felles.xml.soeknad.felles.v3.UkjentForelder;
import no.nav.vedtak.felles.xml.soeknad.foreldrepenger.v3.Dekningsgrad;
import no.nav.vedtak.felles.xml.soeknad.foreldrepenger.v3.Foreldrepenger;
import no.nav.vedtak.felles.xml.soeknad.kodeverk.v3.Brukerroller;
import no.nav.vedtak.felles.xml.soeknad.kodeverk.v3.Dekningsgrader;
import no.nav.vedtak.felles.xml.soeknad.kodeverk.v3.MorsAktivitetsTyper;
import no.nav.vedtak.felles.xml.soeknad.kodeverk.v3.Uttaksperiodetyper;
import no.nav.vedtak.felles.xml.soeknad.uttak.v3.Fordeling;
import no.nav.vedtak.felles.xml.soeknad.uttak.v3.Uttaksperiode;
import no.nav.vedtak.felles.xml.soeknad.v3.ObjectFactory;
import no.nav.vedtak.felles.xml.soeknad.v3.OmYtelse;
import no.nav.vedtak.felles.xml.soeknad.v3.Soeknad;

public class ParseSoeknadTest {

    @Test
    public void skal_parse_soeknad_xml() throws Exception {
        final InputStream resourceAsStream = getClass().getResourceAsStream("/soeknad-v3.xml");
        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (resourceAsStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
        }
        Soeknad søknad = JaxbHelper.unmarshalAndValidateXMLWithStAX(Soeknad.class,
                textBuilder.toString(),
                "xsd/soeknad-v3.xsd", new String[]{
                        "xsd/engangsstoenad/engangsstoenad-v3.xsd",
                        "xsd/foreldrepenger/foreldrepenger-v3.xsd",
                        "xsd/endringssoeknad/endringssoeknad-v3.xsd"},
                SøknadConstants.ADDITIONAL_CLASSES);

        assertThat(søknad).isNotNull();
        assertThat(søknad.getOmYtelse().getAny()).isNotEmpty();
        assertThat(søknad.getOmYtelse().getAny().get(0)).isInstanceOf(JAXBElement.class);
        assertThat(søknad.getOmYtelse().getAny().get(0)).isInstanceOf(JAXBElement.class);
    }

    @Test
    public void skal_marshalle_til_xml() throws Exception {
        LocalDate dato = LocalDate.now();

        Soeknad søknad = new Soeknad();
        søknad.setMottattDato(dato);


        Bruker bruker = new Bruker();
        bruker.setAktoerId("12345678901");
        Brukerroller brukerroller = new Brukerroller();
        brukerroller.setKode("MOR");
        bruker.setSoeknadsrolle(brukerroller);
        søknad.setSoeker(bruker);
        søknad.setSoeker(bruker);

        Foreldrepenger foreldrepenger = new Foreldrepenger();
        foreldrepenger.setAnnenForelder(new UkjentForelder());
        Dekningsgrader dekningsgrader = new Dekningsgrader();
        dekningsgrader.setKode("100");
        Dekningsgrad dekningsgrad = new Dekningsgrad();
        dekningsgrad.setDekningsgrad(dekningsgrader);
        foreldrepenger.setDekningsgrad(dekningsgrad);

        MorsAktivitetsTyper mat = new MorsAktivitetsTyper();
        mat.setKode("-");
        mat.setKodeverk("MORS_AKTIVITET");

        Uttaksperiodetyper utyp = new Uttaksperiodetyper();
        utyp.setKode("MØDREKVOTE");
        utyp.setKodeverk("UTTAK_PERIODE");

        Uttaksperiode uttaksperiode = new Uttaksperiode();
        uttaksperiode.setOenskerSamtidigUttak(false);
        uttaksperiode.setMorsAktivitetIPerioden(mat);
        uttaksperiode.setType(utyp);
        uttaksperiode.setFom(dato.minusDays(10));
        uttaksperiode.setTom(dato.plusDays(10));

        Fordeling fordeling = new Fordeling();
        fordeling.setAnnenForelderErInformert(true);
        fordeling.getPerioder().add(uttaksperiode);
        foreldrepenger.setFordeling(fordeling);


        Rettigheter rettigheter = new Rettigheter();
        rettigheter.setHarAleneomsorgForBarnet(false);
        rettigheter.setHarAnnenForelderRett(true);
        rettigheter.setHarOmsorgForBarnetIPeriodene(true);
        rettigheter.setHarMorUforetrygd(false);
        foreldrepenger.setRettigheter(rettigheter);

        Foedsel relasjonTilBarnet = new Foedsel();
        relasjonTilBarnet.setAntallBarn(1);
        relasjonTilBarnet.setFoedselsdato(dato.minusDays(10));
        foreldrepenger.setRelasjonTilBarnet(relasjonTilBarnet);

        Medlemskap medlemskap = new Medlemskap();
        medlemskap.setBoddINorgeSiste12Mnd(true);
        medlemskap.setBorINorgeNeste12Mnd(true);
        medlemskap.setINorgeVedFoedselstidspunkt(true);
        Periode periode = new Periode();
        periode.setFom(dato.minusYears(1));
        periode.setTom(dato.plusYears(1));
        OppholdNorge oppholdNorge = new OppholdNorge();
        oppholdNorge.setPeriode(periode);
        medlemskap.getOppholdNorge().add(oppholdNorge);
        foreldrepenger.setMedlemskap(medlemskap);

        OmYtelse omYtelse = new ObjectFactory().createOmYtelse();
        omYtelse.getAny().add(new no.nav.vedtak.felles.xml.soeknad.foreldrepenger.v3.ObjectFactory().createForeldrepenger(foreldrepenger));

        søknad.setOmYtelse(omYtelse);

        String xml = JaxbHelper.marshalAndValidateJaxb(SøknadConstants.JAXB_CLASS,
                new no.nav.vedtak.felles.xml.soeknad.v3.ObjectFactory().createSoeknad(søknad),
                "xsd/soeknad-v3.xsd", new String[]{"xsd/uttak/uttak-v3.xsd",
                        "xsd/foreldrepenger/foreldrepenger-v3.xsd",
                        "xsd/endringssoeknad/endringssoeknad-v3.xsd",
                        "xsd/engangsstoenad/engangsstoenad-v3.xsd"},
                SøknadConstants.ADDITIONAL_CLASSES);

        assertThat(xml).isNotBlank();

        Soeknad søknad2 = JaxbHelper.unmarshalAndValidateXMLWithStAX(Soeknad.class,
                xml,
                "xsd/soeknad-v3.xsd", new String[]{
                        "xsd/engangsstoenad/engangsstoenad-v3.xsd",
                        "xsd/foreldrepenger/foreldrepenger-v3.xsd",
                        "xsd/endringssoeknad/endringssoeknad-v3.xsd"},
                SøknadConstants.ADDITIONAL_CLASSES);

        assertThat(søknad).isEqualToComparingFieldByFieldRecursively(søknad2);
    }
}
