package no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.nav.foreldrepenger.kontrakter.fpwsproxy.simulering.util.TestJsonMapper;
import no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.kravgrunnlag.request.HentKravgrunnlagDetaljDto;
import no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.kravgrunnlag.request.KodeAksjon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class HentKravgrunnlagDetaljDtoSeraliseringDeseraliseringTest {

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
        try {
            String serialized = serialize(obj);

            Object deserialized = mapper.readValue(serialized, obj.getClass());

            Assertions.assertEquals(obj, deserialized);
        } catch (Exception var4) {
            Assertions.fail(obj.getClass().getSimpleName() + " failed");
        }

    }

    private static String serialize(Object obj) throws JsonProcessingException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }
}
