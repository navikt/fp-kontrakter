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


public class AksjonspunktEventTest {

    @Test
    public void testAksjonspunktEventRoundtrip() throws Exception {
        AksjonspunktEvent event = AksjonspunktEvent.builder()
                .withAktørId("23498098290344")
                .withSaksnummer("3498934903")
                .withYtelseTypeKode("FP")
                .withFagsystem("FPSAK")
                .withBehandlingTypeKode("BT-004")
                .withEventTid(LocalDateTime.now())
                .withBehandlingOpprettetTid(LocalDateTime.now().minusHours(58))
                .withId("47854a89-2f72-451e-95a1-54901133fc1b")
                .withAksjonspunktOgStatusListe(Map.of("5080", "AVBR"))
                .withBehandlendeEnhet("4803")
                .build();

        String json = serialiserToJson(event);
        System.out.println(json);
        AksjonspunktEvent roundtrippedEvent = deserialiser(json, AksjonspunktEvent.class);
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
