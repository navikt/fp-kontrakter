package no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.kravgrunnlag;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import no.nav.foreldrepenger.kontrakter.fpwsproxy.simulering.util.TestJsonMapper;
import no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.kravgrunnlag.request.HentKravgrunnlagDetaljDto;
import no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.kravgrunnlag.request.KodeAksjon;

class HentKravgrunnlagDetaljDtoSeraliseringDeseraliseringTest {
    private static final Logger LOG = LoggerFactory.getLogger(HentKravgrunnlagDetaljDtoSeraliseringDeseraliseringTest.class);
    private static final ObjectMapper mapper = TestJsonMapper.getMapper();

    @Test
    void hentKravgrunnlagDetaljDtoSeraliseringDeseraliseringTest() {
        var hentKravgrunnlagDetaljDto = new HentKravgrunnlagDetaljDto.Builder()
                .kravgrunnlagId(BigInteger.TEN)
                .kodeAksjon(KodeAksjon.FATTE_VEDTAK)
                .saksbehId("Z123456")
                .enhetAnsvarlig("8020")
                .build();
        test(hentKravgrunnlagDetaljDto);
    }

    @Test
    void hentKravgrunnlagDetaljDtoDeseraliseringKonsistensTest() throws JsonProcessingException {
        var hentKravgrunnlagDetaljDto = new HentKravgrunnlagDetaljDto.Builder()
                .kravgrunnlagId(BigInteger.TEN)
                .kodeAksjon(KodeAksjon.FATTE_VEDTAK)
                .saksbehId("Z123456")
                .enhetAnsvarlig("8020")
                .build();
        var seralisertHentKravgrunnlagDetaljDto = """
                {
                  "kodeAksjon" : "8",
                  "kravgrunnlagId" : 10,
                  "saksbehId" : "Z123456",
                  "enhetAnsvarlig" : "8020"
                }
                """;

        var hentKravgrunnlagDetaljDtoDeseralisert = mapper.readValue(seralisertHentKravgrunnlagDetaljDto, HentKravgrunnlagDetaljDto.class);
        assertThat(hentKravgrunnlagDetaljDto).isEqualTo(hentKravgrunnlagDetaljDtoDeseralisert);
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
