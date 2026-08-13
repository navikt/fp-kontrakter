package no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving;

import no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.kravgrunnlag.request.HentKravgrunnlagDetaljDto;
import no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.kravgrunnlag.request.KodeAksjon;
import no.nav.vedtak.mapper.json.DefaultJsonMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class HentKravgrunnlagDetaljDtoSeraliseringDeseraliseringTest {

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
    void hentKravgrunnlagDetaljDtoDeseraliseringKonsistensTest() {
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

        var hentKravgrunnlagDetaljDtoDeseralisert = DefaultJsonMapper.fromJson(seralisertHentKravgrunnlagDetaljDto, HentKravgrunnlagDetaljDto.class);
        assertThat(hentKravgrunnlagDetaljDto).isEqualTo(hentKravgrunnlagDetaljDtoDeseralisert);
    }




    protected static void test(Object obj) {
        try {
            String serialized = serialize(obj);

            Object deserialized = DefaultJsonMapper.fromJson(serialized, obj.getClass());

            Assertions.assertEquals(obj, deserialized);
        } catch (Exception var4) {
            Assertions.fail(obj.getClass().getSimpleName() + " failed");
        }

    }

    private static String serialize(Object obj) {
        return DefaultJsonMapper.toJson(obj);
    }
}
