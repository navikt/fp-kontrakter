package no.nav.foreldrepenger.oppgave.event.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import no.nav.foreldrepenger.oppgave.event.OppgaveEvent;
import no.nav.foreldrepenger.oppgave.event.Saksnummer;
import no.nav.foreldrepenger.oppgave.event.Uuid;
import no.nav.foreldrepenger.oppgave.event.v1.attributt.BooleanAttributt;
import no.nav.foreldrepenger.oppgave.event.v1.attributt.DatoAttributt;
import no.nav.foreldrepenger.oppgave.event.v1.attributt.HeltallAttributt;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OppgaveEventV1Test {

    @Test
    public void testDeserialingOppgaveEvent() throws IOException, URISyntaxException {
        String json = readFile("oppgaveevent.json");
        OppgaveEvent event = deserialiser(json, OppgaveEvent.class);
        System.out.println(event);
        assertThat(event).isNotNull();
    }

    @Test
    public void testOppgaveEventRoundtrip() throws Exception {
        OppgaveEventV1 event = OppgaveEventV1.Builder.newBuilder()
                .withUuid(new Uuid("idsfuk-dsfkjlfds-dsfkjlfds"))
                .withAktoerId(List.of(new OppgaveAktør("12345", OppgaveAktør.AktørRolle.SØKER)))
                .withBehandlendeEnhet("9834")
                .withBehandlingType(BehandlingType.TILBAKEKREVING)
                .withFagsystem(Fagsystem.TILBAKEKREVING)
                .withFagsystemSaksnummer(new Saksnummer("9834983434"))
                .withAktiv(true)
                .withAttributter(List.of(
                        new HeltallAttributt("Utestående beløp", 8437),
                        new BooleanAttributt("Til beslutter", true),
                        new HeltallAttributt("Foreldet beløp", 12848),
                        new DatoAttributt("Foreldelsesdato", LocalDate.now())))
                .withUrl("https://app.adeo.no/fplos/4932934")
                .withYtelsestype(YtelseType.FORELDREPENGER)
                .withHendelseTid(LocalDateTime.now())
                .build();
        String json = serialiserToJson(event);
        System.out.println(json);
        OppgaveEvent roundtrippedEvent = deserialiser(json, OppgaveEvent.class);
        assertThat(event).isEqualTo(roundtrippedEvent);
    }

    public String readFile(String filename) throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        return Files.readString(path);
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
