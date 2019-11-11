package no.nav.vedtak.felles.integrasjon.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class BehandlingProsessEventDtoTest {

    @Test
    public void testAksjonspunktEventRoundtrip() throws Exception {
        Map<String, String> aksjonspunkter = new HashMap<>();
        aksjonspunkter.put("5080", "AVBR");

        BehandlingProsessEventDto event = BehandlingProsessEventDto.builder()
                .medAktørId("123457890123")
                .medSaksnummer("9876543210")
                .medYtelseTypeKode("FP")
                .medFagsystem("FPSAK")
                .medBehandlingTypeKode("BT-004")
                .medEventTid(LocalDateTime.now())
                .medOpprettetBehandling(LocalDateTime.now().minusHours(10))
                .medId("47854a89-2f72-451e-95a1-54901133fc1b")
                .medAksjonspunktKoderMedStatusListe(aksjonspunkter)
                .medBehandlendeEnhet("4803")
                .build();

        String json = serialiserToJson(event);
        BehandlingProsessEventDto roundtrippedEvent = deserialiser(json, BehandlingProsessEventDto.class);

        assertThat(event).isEqualTo(roundtrippedEvent);
    }

    private String serialiserToJson(Object objekt) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper.writeValueAsString(objekt);
    }

    public static <T> T deserialiser(String melding, Class<T> klassetype) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        return mapper.readValue(melding, klassetype);
    }
}
