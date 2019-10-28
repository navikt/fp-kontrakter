package no.nav.vedtak.felles.integrasjon.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class BehandlingProsessEventDtoTest {

    @Test
    public void testAksjonspunktEventRoundtrip() throws Exception {
        BehandlingProsessEventDto event = BehandlingProsessEventDto.builder()
                .medAktørId("23498098290344")
                .medSaksnummer("3498934903")
                .medYtelseTypeKode("FP")
                .medFagsystem("FPSAK")
                .medBehandlingTypeKode("BT-004")
                .medEventTid(LocalDateTime.now())
                .medOpprettetBehandling(LocalDateTime.now().minusHours(58))
                .medId("47854a89-2f72-451e-95a1-54901133fc1b")
                .medAksjonspunktKoderMedStatusListe(Map.of("5080", "AVBR"))
                .medBehandlendeEnhet("4803")
                .build();

        String json = serialiserToJson(event);
        System.out.println(json);
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
