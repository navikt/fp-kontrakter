package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.Validation;
import no.nav.vedtak.mapper.json.DefaultJsonMapper;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JournalpostMottakDtoTest {

    private static final String SAK = "123456789";
    private static final String JOURNALPOST = "456789123";
    private static final String BTEMA = "ae0126";
    private static final String DOKTYPE = "I000006";

    @Test
    void skal_kunne_hente_ut_payload_når_lengde_er_definiert_riktig() throws Exception {
        var dto = new JournalpostMottakDto(SAK, JOURNALPOST, BTEMA, DOKTYPE, LocalDateTime.now(), "foo");

        assertThat(dto.getPayloadXml()).isPresent().contains("foo");

        String foobar = base64("<foo>ååå<foo/>");
        Optional<String> validert = JournalpostMottakDto.getPayloadValiderLengde(foobar, 14);

        assertThat(validert).isPresent().contains("<foo>ååå<foo/>");

        var json = DefaultJsonMapper.getObjectMapper().writeValueAsString(dto);
        var roundtrip = DefaultJsonMapper.getObjectMapper().readValue(json, JournalpostMottakDto.class);

        assertThat(roundtrip.getJournalpostId()).isEqualTo(JOURNALPOST);
        assertThat(roundtrip.getSaksnummer()).isEqualTo(SAK);
        assertThat(roundtrip.getBehandlingstemaOffisiellKode()).isEqualTo(BTEMA);
        assertThat(roundtrip.getDokumentTypeIdOffisiellKode()).contains(DOKTYPE);
        assertThat(roundtrip.getPayloadXml()).isPresent().contains("foo");

        validateResult(dto);
        validateResult(roundtrip);
    }

    @Test
    void skal_feile_når_payload_lenged_ikke_stemmer() {
        String foobar = base64("foobar");
        Exception thrown = assertThrows(
                IllegalArgumentException.class,
                () -> JournalpostMottakDto.getPayloadValiderLengde(foobar, 4)
        );
        assertThat(thrown.getMessage()).isEqualTo("Input-validering-feil: Avsender oppgav at lengde på innhold var 4, men lengden var egentlig 6");
    }

    @Test
    void skal_feile_når_payload_lengde_ikke_finnes() {
        String foobar = base64("foobar");
        Exception thrown = assertThrows(
                IllegalArgumentException.class,
                () -> JournalpostMottakDto.getPayloadValiderLengde(foobar, null)
        );
        assertThat(thrown.getMessage()).isEqualTo("Input-validering-feil: Avsender sendte payload, men oppgav ikke lengde på innhold");
    }

    @Test
    void skal_være_ok_å_ikke_ha_payload_lengt_når_det_ikke_er_med_payload() throws Exception {
        var dto = new JournalpostMottakDto(SAK, JOURNALPOST, BTEMA, DOKTYPE, LocalDateTime.now(), null);
        assertThat(dto.getPayloadXml()).isNotPresent();

        Optional<String> resultat = JournalpostMottakDto.getPayloadValiderLengde(null, null);
        assertThat(resultat).isNotPresent();

        var json = DefaultJsonMapper.getObjectMapper().writeValueAsString(dto);
        var roundtrip = DefaultJsonMapper.getObjectMapper().readValue(json, JournalpostMottakDto.class);

        assertThat(roundtrip.getJournalpostId()).isEqualTo(JOURNALPOST);
        assertThat(roundtrip.getSaksnummer()).isEqualTo(SAK);
        assertThat(roundtrip.getBehandlingstemaOffisiellKode()).isEqualTo(BTEMA);
        assertThat(roundtrip.getDokumentTypeIdOffisiellKode()).contains(DOKTYPE);
        assertThat(roundtrip.getPayloadXml()).isEmpty();

        validateResult(dto);
        validateResult(roundtrip);
    }

    private String base64(String unencoded) {
        byte[] bytes = unencoded.getBytes(StandardCharsets.UTF_8);
        return Base64.getUrlEncoder().encodeToString(bytes);
    }

    static void validateResult(Object roundTripped) {
        assertThat(roundTripped).isNotNull();
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            var validator = factory.getValidator();
            var violations = validator.validate(roundTripped);
            assertThat(violations).isEmpty();
        }
    }

}