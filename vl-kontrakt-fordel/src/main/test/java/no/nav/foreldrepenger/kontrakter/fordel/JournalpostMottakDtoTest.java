package no.nav.foreldrepenger.kontrakter.fordel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JournalpostMottakDtoTest {


    @Test
    public void skal_kunne_hente_ut_payload_når_lengde_er_definiert_riktig() {
        var dto = new TestJournalpostMottakDto(null, null, null, null, LocalDateTime.now(), "foo");

        assertThat(dto.getPayloadXml()).isPresent();
        assertThat(dto.getPayloadXml().get()).isEqualTo("foo");

        String foobar = base64("<foo>ååå<foo/>");
        Optional<String> validert = TestJournalpostMottakDto.getPayloadValiderLengde(foobar, 14);

        assertThat(validert.isPresent()).isTrue();
        assertThat(validert.get()).isEqualTo("<foo>ååå<foo/>");
    }

    @Test
    public void skal_feile_når_payload_lenged_ikke_stemmer() {
        String foobar = base64("foobar");
        Exception thrown = assertThrows(
                IllegalArgumentException.class,
                () -> TestJournalpostMottakDto.getPayloadValiderLengde(foobar, 4)
        );
        assertThat(thrown.getMessage()).isEqualTo("Avsender oppgav at lengde på innhold var 4, men lengden var egentlig 6");
    }

    @Test
    public void skal_feile_når_payload_lengde_ikke_finnes() {
        String foobar = base64("foobar");
        TestJournalpostMottakDto.getPayloadValiderLengde(foobar, null);
        Exception thrown = assertThrows(
                IllegalArgumentException.class,
                () -> TestJournalpostMottakDto.getPayloadValiderLengde(foobar, null)
        );
        assertThat(thrown.getMessage()).isEqualTo("Avsender sendte payload, men oppgav ikke lengde på innhold");
    }

    @Test
    public void skal_være_ok_å_ikke_ha_payload_lengt_når_det_ikke_er_med_payload() {
        var dto = new TestJournalpostMottakDto(null, null, null, null, LocalDateTime.now(), null);
        assertThat(dto.getPayloadXml()).isNotPresent();

        Optional<String> resultat = TestJournalpostMottakDto.getPayloadValiderLengde(null, null);
        assertThat(resultat).isNotPresent();
    }

    private String base64(String unencoded) {
        byte[] bytes = unencoded.getBytes(Charset.forName("UTF-8"));
        return Base64.getUrlEncoder().encodeToString(bytes);
    }

    private static class TestJournalpostMottakDto extends JournalpostMottakDto {
        public TestJournalpostMottakDto() {
            super();
        }

        public TestJournalpostMottakDto(String saksnummer, String journalpostId, String behandlingstemaOffisiellKode,
                                        String dokumentTypeIdOffisiellKode,
                                        LocalDateTime forsendelseMottattTidspunkt, String payloadXml) {
            super(saksnummer, journalpostId, behandlingstemaOffisiellKode, dokumentTypeIdOffisiellKode, forsendelseMottattTidspunkt, payloadXml);
        }

        @JsonIgnore
        public Optional<String> getPayloadXml() {
            return getPayloadValiderLengde(base64EncodedPayloadXml, payloadLength);
        }

        static Optional<String> getPayloadValiderLengde(String base64EncodedPayload, Integer deklarertLengde) {
            if (base64EncodedPayload == null) {
                return Optional.empty();
            }
            if (deklarertLengde == null) {
                throw new IllegalArgumentException("Input-validering-feil: Avsender sendte payload, men oppgav ikke lengde på innhold");
            }
            byte[] bytes = Base64.getUrlDecoder().decode(base64EncodedPayload);
            String streng = new String(bytes, Charset.forName("UTF-8"));
            if (streng.length() != deklarertLengde) {
                throw new IllegalArgumentException(String.format("Input-validering-feil: Avsender oppgav at lengde på innhold var %s, men lengden var egentlig %s",
                        deklarertLengde, streng.length()));
            }
            return Optional.of(streng);
        }

    }
}