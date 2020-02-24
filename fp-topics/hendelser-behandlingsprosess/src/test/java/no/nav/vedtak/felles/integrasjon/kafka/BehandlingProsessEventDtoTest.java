package no.nav.vedtak.felles.integrasjon.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class BehandlingProsessEventDtoTest {

    @Test
    public void testAksjonspunktEventRoundtrip() throws Exception {
        Map<String, String> aksjonspunkter = new HashMap<>();
        aksjonspunkter.put("5080", "OPPR");

        BehandlingProsessEventDto baseDto = BehandlingProsessEventDto.builder()
                .medFagsystem(Fagsystem.FPSAK)
                .medAktørId("123457890123")
                .medSaksnummer("9876543210")
                .medYtelseTypeKode("FP")
                .medBehandlingTypeKode("BT-004")
                .medEventTid(LocalDateTime.now())
                .medOpprettetBehandling(LocalDateTime.now().minusHours(10))
                .medEksternId(UUID.randomUUID())
                .medAksjonspunktKoderMedStatusListe(aksjonspunkter)
                .medBehandlendeEnhet("4803")
                .build();

        TilbakebetalingBehandlingProsessEventDto tilbakebetalingDto = TilbakebetalingBehandlingProsessEventDto.builder()
                .medFagsystem(Fagsystem.FPTILBAKE)
                .medFeilutbetaltBeløp(BigDecimal.valueOf(20000L))
                .medFørsteFeilutbetaling(LocalDate.now().minusMonths(4))
                .medAnsvarligSaksbehandlerIdent("T12345")
                .medHref(new URL("http://tilbakekreving/"))
                .medAktørId("123457890123")
                .medSaksnummer("9876543210")
                .medYtelseTypeKode("FP")
                .medBehandlingTypeKode("BT-004")
                .medEventTid(LocalDateTime.now())
                .medOpprettetBehandling(LocalDateTime.now().minusHours(10))
                .medEksternId(UUID.randomUUID())
                .medAksjonspunktKoderMedStatusListe(aksjonspunkter)
                .medBehandlendeEnhet("4803")
                .build();

        testRoundtrip(tilbakebetalingDto, TilbakebetalingBehandlingProsessEventDto.class);
        testRoundtrip(baseDto, BehandlingProsessEventDto.class);
    }

    private static <T> T testRoundtrip(BehandlingProsessEventDto dto, Class<T> cls) throws Exception {
        String json = serialiserToJson(dto);
        var roundtrippedDto = deserialiser(json, BehandlingProsessEventDto.class);
        assertThat(roundtrippedDto).isInstanceOf(cls);
        return null;
    }

    private static String serialiserToJson(Object objekt) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper.writeValueAsString(objekt);
    }

    private static <T> T deserialiser(String melding, Class<T> klassetype) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        mapper.addMixIn(BehandlingProsessEventDto.class, BehandlingProsessEventMixin.class);
        return mapper.readValue(melding, klassetype);
    }

}
