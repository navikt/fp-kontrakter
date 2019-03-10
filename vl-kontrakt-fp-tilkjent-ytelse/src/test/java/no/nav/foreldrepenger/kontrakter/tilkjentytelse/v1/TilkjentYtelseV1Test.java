package no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1;

import static no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1.TilkjentYtelseV1.Inntektskategori.ARBEIDSTAKER;
import static no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1.TilkjentYtelseV1.Inntektskategori.FRILANSER;
import static no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1.TilkjentYtelseV1.SatsType.DAGSATS;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import no.nav.foreldrepenger.kontrakter.tilkjentytelse.TilkjentYtelse;

public class TilkjentYtelseV1Test {

    private static ObjectMapper mapper = getObjectMapper();

    @Test
    public void skal_serialisere_riktig() throws JsonProcessingException {
        TilkjentYtelseBehandlingInfoV1 info = new TilkjentYtelseBehandlingInfoV1()
                .setAktørId("90000123")
                .setSaksnummer("2525253")
                .setBehandlingId(100000123)
                .setVedtaksdator(LocalDate.of(2019, 3, 10))
                .setGjelderAdopsjon(false)
                .setAnsvarligSaksbehandler("Z000001")
                .setYtelseType(TilkjentYtelseV1.YtelseType.FORELDREPENGER);
        var andeler1 = new ArrayList<TilkjentYtelseAndelV1>();
        andeler1.add(TilkjentYtelseAndelV1.tilBruker(FRILANSER, 100L, DAGSATS));
        andeler1.add(TilkjentYtelseAndelV1.tilOrgnrArbeidsgiver(ARBEIDSTAKER, 1000L, DAGSATS, "123123123"));
        var andeler2 = new ArrayList<TilkjentYtelseAndelV1>();
        andeler2.add(TilkjentYtelseAndelV1.tilBruker(FRILANSER, 135L, DAGSATS));
        andeler2.add(TilkjentYtelseAndelV1.tilOrgnrArbeidsgiver(ARBEIDSTAKER, 1586L, DAGSATS, "123123123").medFeriepenger(Year.of(2018), 187));

        var perioder = new ArrayList<TilkjentYtelsePeriodeV1>();
        perioder.add(new TilkjentYtelsePeriodeV1(LocalDate.of(2018, 12, 24), LocalDate.of(2019, 2, 28), andeler1));
        perioder.add(new TilkjentYtelsePeriodeV1(LocalDate.of(2019, 3, 1), LocalDate.of(2019, 3, 31), andeler2));
        TilkjentYtelse tilkjentYtelseV1 = new TilkjentYtelseV1(info, perioder)
                .setErOpphør(true)
                .setErOpphørEtterSkjæringstidspunkt(false);

        String resultat = mapper.writeValueAsString(tilkjentYtelseV1);

        //hvis du endrer noe slik at denne testen feiler, har du gjort noe galt! Endringene du ønsker krever at du oppretter en ny versjon av TilkjentYtelse
        assertThat(resultat).isEqualTo("{\"version\":\"1.0\",\"behandingsinfo\":{\"saksnummer\":\"2525253\",\"behandlingId\":100000123,\"ytelseType\":\"FORELDREPENGER\",\"gjelderAdopsjon\":false,\"vedtaksdato\":\"2019-03-10\",\"ansvarligSaksbehandler\":\"Z000001\",\"aktoerId\":\"90000123\"},\"perioder\":[{\"fom\":\"2018-12-24\",\"tom\":\"2019-02-28\",\"andeler\":[{\"utbetalesTilBruker\":true,\"inntektskategori\":\"FRILANSER\",\"satsType\":\"DAGSATS\",\"satsBeloep\":100},{\"utbetalesTilBruker\":false,\"arbeidsgiverOrgNr\":\"123123123\",\"inntektskategori\":\"ARBEIDSTAKER\",\"satsType\":\"DAGSATS\",\"satsBeloep\":1000}]},{\"fom\":\"2019-03-01\",\"tom\":\"2019-03-31\",\"andeler\":[{\"utbetalesTilBruker\":true,\"inntektskategori\":\"FRILANSER\",\"satsType\":\"DAGSATS\",\"satsBeloep\":135},{\"utbetalesTilBruker\":false,\"arbeidsgiverOrgNr\":\"123123123\",\"inntektskategori\":\"ARBEIDSTAKER\",\"satsType\":\"DAGSATS\",\"feriepenger\":{\"opptjeningsaar\":2018,\"beloep\":187},\"satsBeloep\":1586}]}],\"erOpphoer\":true,\"erOpphoerEtterSkjaeringTidspunkt\":false}");
    }

    @Test
    public void skal_serialisere_og_deserialisere_med_feriepenger() throws IOException, ParseException {
        TilkjentYtelseBehandlingInfoV1 info = new TilkjentYtelseBehandlingInfoV1()
                .setAktørId("90000123")
                .setSaksnummer("2525253")
                .setBehandlingId(100000123)
                .setVedtaksdator(LocalDate.of(2019, 3, 10))
                .setGjelderAdopsjon(false)
                .setAnsvarligSaksbehandler("Z000001")
                .setYtelseType(TilkjentYtelseV1.YtelseType.FORELDREPENGER);
        var andeler = new ArrayList<TilkjentYtelseAndelV1>();
        andeler.add(TilkjentYtelseAndelV1.tilBruker(FRILANSER, 100L, DAGSATS).medFeriepenger(Year.of(2018), 12));

        var perioder = new ArrayList<TilkjentYtelsePeriodeV1>();
        perioder.add(new TilkjentYtelsePeriodeV1(LocalDate.of(2018, 12, 24), LocalDate.of(2019, 2, 28), andeler));
        TilkjentYtelse tilkjentYtelseV1 = new TilkjentYtelseV1(info, perioder)
                .setEndringsdato(LocalDate.of(2018, 12, 27));

        String json = mapper.writeValueAsString(tilkjentYtelseV1);
        TilkjentYtelse resultat = mapper.readValue(json, TilkjentYtelse.class);
        assertThat(resultat).isInstanceOf(TilkjentYtelseV1.class);

        TilkjentYtelseV1 ty = (TilkjentYtelseV1) resultat;
        ty.kryssvalider();

        assertThat(ty.getEndringsdato()).isEqualTo(LocalDate.of(2018, 12, 27));
        TilkjentYtelseAndelV1 andel = ty.getPerioder().iterator().next().getAndeler().iterator().next();
        Optional<TilkjentYtelseFeriepengerV1> feriepenger = andel.getFeriepenger();
        assertThat(feriepenger).isPresent();
        assertThat(feriepenger.get().getBeløp()).isEqualTo(12);
        assertThat(feriepenger.get().getOpptjeningsår()).isEqualTo(2018);
    }

    @Test
    public void skal_deserialisere() throws IOException, ParseException {
        TilkjentYtelse resultat = mapper.readValue("{\"version\":\"1.0\",\"behandingsinfo\":{\"saksnummer\":\"2525253\",\"behandlingId\":100000123,\"ytelseType\":\"FORELDREPENGER\",\"gjelderAdopsjon\":false,\"vedtaksdato\":\"2019-03-10\",\"ansvarligSaksbehandler\":\"Z000001\",\"aktoerId\":\"90000123\"},\"perioder\":[{\"fom\":\"2018-12-24\",\"tom\":\"2019-02-28\",\"andeler\":[{\"utbetalesTilBruker\":true,\"inntektskategori\":\"FRILANSER\",\"satsType\":\"DAGSATS\",\"satsBeloep\":100},{\"utbetalesTilBruker\":false,\"arbeidsgiverOrgNr\":\"123123123\",\"inntektskategori\":\"ARBEIDSTAKER\",\"satsType\":\"DAGSATS\",\"satsBeloep\":1000}]},{\"fom\":\"2019-03-01\",\"tom\":\"2019-03-31\",\"andeler\":[{\"utbetalesTilBruker\":true,\"inntektskategori\":\"FRILANSER\",\"satsType\":\"DAGSATS\",\"satsBeloep\":135},{\"utbetalesTilBruker\":false,\"arbeidsgiverOrgNr\":\"123123123\",\"inntektskategori\":\"ARBEIDSTAKER\",\"satsType\":\"DAGSATS\",\"feriepenger\":{\"opptjeningsaar\":2018,\"beloep\":187},\"satsBeloep\":1586}]}],\"erOpphoer\":true,\"erOpphoerEtterSkjaeringTidspunkt\":false}", TilkjentYtelse.class);

        assertThat(resultat).isInstanceOf(TilkjentYtelseV1.class);

        TilkjentYtelseV1 ty = (TilkjentYtelseV1) resultat;
        ty.kryssvalider();
        TilkjentYtelseBehandlingInfoV1 info = ty.getBehandingsinfo();
        assertThat(info.getAktørId()).isEqualTo("90000123");
        assertThat(info.getSaksnummer()).isEqualTo("2525253");
        assertThat(info.getBehandlingId()).isEqualTo(100000123);
        assertThat(info.getVedtaksdato()).isEqualTo(LocalDate.of(2019, 3, 10));
        assertThat(info.isGjelderAdopsjon()).isFalse();
        assertThat(info.getAnsvarligSaksbehandler()).isEqualTo("Z000001");
        assertThat(info.getYtelseType()).isEqualTo(TilkjentYtelseV1.YtelseType.FORELDREPENGER);

        assertThat(ty.getPerioder()).hasSize(2);
        TilkjentYtelsePeriodeV1 periode = ty.getPerioder().iterator().next();
        assertThat(periode.getAndeler()).hasSize(2);
        assertThat(periode.getFom()).isEqualTo(LocalDate.of(2018, 12, 24));
        assertThat(periode.getTom()).isEqualTo(LocalDate.of(2019, 2, 28));
        Iterator<TilkjentYtelseAndelV1> andeler = periode.getAndeler().iterator();
        TilkjentYtelseAndelV1 andel1 = andeler.next();
        assertThat(andel1.getUtbetalesTilBruker()).isTrue();
        assertThat(andel1.getInntektskategori()).isEqualTo(TilkjentYtelseV1.Inntektskategori.FRILANSER);
        assertThat(andel1.getSatsBeløp()).isEqualTo(100);
        assertThat(andel1.getSatsType()).isEqualTo(TilkjentYtelseV1.SatsType.DAGSATS);
        assertThat(andel1.getArbeidsgiverOrgNr()).isNull();
        assertThat(andel1.getArbeidsgiverAktørId()).isNull();
        TilkjentYtelseAndelV1 andel2 = andeler.next();
        assertThat(andel2.getUtbetalesTilBruker()).isFalse();
        assertThat(andel2.getInntektskategori()).isEqualTo(TilkjentYtelseV1.Inntektskategori.ARBEIDSTAKER);
        assertThat(andel2.getSatsBeløp()).isEqualTo(1000);
        assertThat(andel2.getSatsType()).isEqualTo(TilkjentYtelseV1.SatsType.DAGSATS);
        assertThat(andel2.getArbeidsgiverOrgNr()).isEqualTo("123123123");
        assertThat(andel2.getArbeidsgiverAktørId()).isNull();
    }

    @Test(expected = InvalidTypeIdException.class)
    public void skal_ikke_deserialisere_ukjent_versjon() throws IOException {
        mapper.readValue("{\"version\":\"1000.0\",\"behandingsinfo\":{\"aktoerId\":90000123,\"saksnummer\":\"2525253\",\"behandlingId\":100000123,\"ytelseType\":\"FORELDREPENGER\",\"gjelderAdopsjon\":false,\"vedtaksdato\":\"2019-03-10\",\"ansvarligSaksbehandler\":\"Z000001\",\"ansvarligBeslutter\":\"Z222222\"},\"perioder\":[{\"fom\":\"2018-12-24\",\"tom\":\"2019-02-28\",\"andeler\":[{\"inntektskategori\":\"FRILANSER\",\"satsBeløp\":100,\"satsType\":\"DAGSATS\"},{\"arbeidsgiverOrgNr\":\"123123123\",\"inntektskategori\":\"ARBEIDSTAKER\",\"satsBeløp\":1000,\"satsType\":\"DAGSATS\"}]},{\"fom\":\"2019-03-01\",\"tom\":\"2019-03-31\",\"andeler\":[{\"inntektskategori\":\"FRILANSER\",\"satsBeløp\":135,\"satsType\":\"DAGSATS\"},{\"arbeidsgiverOrgNr\":\"123123123\",\"inntektskategori\":\"ARBEIDSTAKER\",\"satsBeløp\":1586,\"satsType\":\"DAGSATS\"}]}]}", TilkjentYtelse.class);

    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

}