package no.nav.foreldrepenger.kontrakter.simulering.respons;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import no.nav.foreldrepenger.kontrakter.simulering.util.TestJsonMapper;

class BeregningDtoSeraliseringDeseraliseringTest {
    private static final Logger LOG = LoggerFactory.getLogger(BeregningDtoSeraliseringDeseraliseringTest.class);
    private static ObjectMapper mapper = TestJsonMapper.getMapper();

    @Test
    void beregningDtoSeraliseringDeseraliseringRoundTripTest() {
        test(lagBeregningDto());
    }

    @Test
    void beregningDtoDeseraliseringKonsistensTest() throws JsonProcessingException {
        var beregningDto = lagBeregningDto();
        var seralisertBeregningDto = """
                {
                  "gjelderId" : "123456789",
                  "gjelderNavn" : "Navn",
                  "datoBeregnet" : "2018-10-10",
                  "kodeFaggruppe" : "DUMMY",
                  "beregningsPeriode" : [ {
                    "periodeFom" : "dato",
                    "periodeTom" : "dato",
                    "beregningStoppnivaa" : [ {
                      "kodeFagomraade" : "FP",
                      "stoppNivaaId" : 2563,
                      "behandlendeEnhet" : "8052",
                      "oppdragsId" : 1234,
                      "fagsystemId" : "1",
                      "kid" : "123456789",
                      "utbetalesTilId" : "12345678910",
                      "utbetalesTilNavn" : "Nav Navesens",
                      "bilagsType" : "U",
                      "forfall" : "2020-09-12",
                      "feilkonto" : false,
                      "beregningStoppnivaaDetaljer" : [ {
                        "faktiskFom" : "2018-09-01",
                        "faktiskTom" : "2019-09-31",
                        "kontoStreng" : "12414123",
                        "behandlingskode" : "2",
                        "belop" : 52231.51,
                        "trekkVedtakId" : 0,
                        "stonadId" : "2018-12-12",
                        "tilbakeforing" : false,
                        "linjeId" : 23,
                        "typeSats" : "DAG",
                        "delytelseId" : "8123",
                        "bostedsenhet" : "8021"
                      } ]
                    }, {
                      "kodeFagomraade" : "FP",
                      "stoppNivaaId" : 2563,
                      "behandlendeEnhet" : "8052",
                      "oppdragsId" : 1234,
                      "fagsystemId" : "1",
                      "kid" : "123456789",
                      "utbetalesTilId" : "12345678910",
                      "utbetalesTilNavn" : "Nav Navesens",
                      "bilagsType" : "U",
                      "forfall" : "2020-09-12",
                      "feilkonto" : false,
                      "beregningStoppnivaaDetaljer" : [ {
                        "faktiskFom" : "2018-09-01",
                        "faktiskTom" : "2019-09-31",
                        "kontoStreng" : "12414123",
                        "behandlingskode" : "2",
                        "belop" : 52231.51,
                        "trekkVedtakId" : 0,
                        "stonadId" : "2018-12-12",
                        "tilbakeforing" : false,
                        "linjeId" : 23,
                        "typeSats" : "DAG",
                        "delytelseId" : "8123",
                        "bostedsenhet" : "8021"
                      } ]
                    } ]
                  } ]
                }
                """;
        BeregningDto beregningDto1 = mapper.readValue(seralisertBeregningDto, BeregningDto.class);
        assertThat(beregningDto).isEqualTo(beregningDto1);
    }

    private static BeregningDto lagBeregningDto() {
        var beregningStoppnivåDetalj = new BeregningStoppnivåDetaljerDto.Builder()
                .faktiskFom("2018-09-01")
                .faktiskTom("2019-09-31")
                .kontoStreng("12414123")
                .behandlingskode("2")
                .belop(BigDecimal.valueOf(52_231.51))
                .trekkVedtakId(0L)
                .stonadId("2018-12-12")
                .tilbakeforing(false)
                .linjeId(BigInteger.valueOf(23))
                .typeSats("DAG")
                .delytelseId("8123")
                .bostedsenhet("8021")
                .build();
        var beregningStoppnivåDto = new BeregningStoppnivåDto.Builder()
                .kodeFagomraade("FP")
                .stoppNivaaId(BigInteger.valueOf(2563))
                .behandlendeEnhet("8052")
                .oppdragsId(1234L)
                .fagsystemId("1")
                .kid("123456789")
                .utbetalesTilId("12345678910")
                .utbetalesTilNavn("Nav Navesens")
                .bilagsType("U")
                .forfall("2020-09-12")
                .feilkonto(false)
                .beregningStoppnivaaDetaljer(List.of(beregningStoppnivåDetalj))
                .build();
        var beregningDto = new BeregningDto.Builder()
                .gjelderId("123456789")
                .gjelderNavn("Navn")
                .datoBeregnet("2018-10-10")
                .kodeFaggruppe("DUMMY")
                .beregningsPeriode(List.of(new BeregningsPeriodeDto("dato", "dato", List.of(beregningStoppnivåDto, beregningStoppnivåDto))))
                .build();
        return beregningDto;
    }


    protected static void test(Object obj) {
        test(obj, true);
    }

    protected static void test(Object obj, boolean log) {
        try {
            if (log) {
                LOG.info("{}", obj);
            }

            String serialized = serialize(obj);
            if (log) {
                LOG.info("Serialized as {}", serialized);
            }

            Object deserialized = mapper.readValue(serialized, obj.getClass());
            if (log) {
                LOG.info("{}", deserialized);
            }

            Assertions.assertEquals(obj, deserialized);
        } catch (Exception var4) {
            LOG.error("Oops", var4);
            Assertions.fail(obj.getClass().getSimpleName() + " failed");
        }

    }

    private static String serialize(Object obj) throws JsonProcessingException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }
}
