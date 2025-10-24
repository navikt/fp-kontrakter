package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.Validation;
import no.nav.vedtak.mapper.json.DefaultJsonMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class FordelDtoTest {

    private static final String AKTØR = "1234567890123";
    private static final String SAK = "123456789";
    private static final String JOURNALPOST = "456789123";
    private static final String BTEMA = "ae0126";
    private static final String DOKTYPE = "I000006";

    @Test
    void test_roundtrip_vurderfagsystyem() throws Exception {
        var dto = new VurderFagsystemDto(JOURNALPOST, true, AKTØR, BTEMA);
        dto.setBarnTermindato(LocalDate.now().plusWeeks(6));
        dto.setDokumentTypeIdOffisiellKode(DOKTYPE);
        dto.setForsendelseMottatt(LocalDate.now());
        dto.setForsendelseMottattTidspunkt(LocalDateTime.now());

        var json = DefaultJsonMapper.getObjectMapper().writeValueAsString(dto);
        var roundtrip = DefaultJsonMapper.getObjectMapper().readValue(json, VurderFagsystemDto.class);

        assertThat(roundtrip.getJournalpostId()).contains(JOURNALPOST);
        assertThat(roundtrip.getAktørId()).contains(AKTØR);
        assertThat(roundtrip.getBehandlingstemaOffisiellKode()).contains(BTEMA);
        assertThat(roundtrip.getDokumentTypeIdOffisiellKode()).contains(DOKTYPE);
        assertThat(roundtrip.getBarnTermindato()).contains(LocalDate.now().plusWeeks(6));

        validateResult(dto);
        validateResult(roundtrip);
    }

    @Test
    void test_roundtrip_opprettsak() throws Exception {
        var dto = new OpprettSakDto(JOURNALPOST, BTEMA, AKTØR);

        var json = DefaultJsonMapper.getObjectMapper().writeValueAsString(dto);
        var roundtrip = DefaultJsonMapper.getObjectMapper().readValue(json, OpprettSakDto.class);

        assertThat(roundtrip.journalpostId()).contains(JOURNALPOST);
        assertThat(roundtrip.aktørId()).isEqualTo(AKTØR);
        assertThat(roundtrip.behandlingstemaOffisiellKode()).contains(BTEMA);

        validateResult(dto);
        validateResult(roundtrip);
    }

    @Test
    void test_roundtrip_opprettsakV2() throws Exception {
        var dto = new OpprettSakV2Dto(JOURNALPOST, YtelseTypeDto.FORELDREPENGER, AKTØR);

        var json = DefaultJsonMapper.getObjectMapper().writeValueAsString(dto);
        var roundtrip = DefaultJsonMapper.getObjectMapper().readValue(json, OpprettSakV2Dto.class);

        assertThat(roundtrip.journalpostId()).isEqualTo(JOURNALPOST);
        assertThat(roundtrip.aktørId()).isEqualTo(AKTØR);
        assertThat(roundtrip.ytelseType()).isEqualTo(YtelseTypeDto.FORELDREPENGER);

        validateResult(dto);
        validateResult(roundtrip);
    }

    @Test
    void test_roundtrip_saksnummer() throws Exception {
        var dto = new SaksnummerDto(SAK);

        var json = DefaultJsonMapper.getObjectMapper().writeValueAsString(dto);
        var roundtrip = DefaultJsonMapper.getObjectMapper().readValue(json, SaksnummerDto.class);

        assertThat(roundtrip.saksnummer()).isEqualTo(SAK);

        validateResult(dto);
        validateResult(roundtrip);
    }

    @Test
    void test_roundtrip_knytning() throws Exception {
        var dto = new JournalpostKnyttningDto(SAK, JOURNALPOST);

        var json = DefaultJsonMapper.getObjectMapper().writeValueAsString(dto);
        var roundtrip = DefaultJsonMapper.getObjectMapper().readValue(json, JournalpostKnyttningDto.class);

        assertThat(roundtrip.journalpostIdDto().journalpostId()).contains(JOURNALPOST);
        assertThat(roundtrip.saksnummerDto().saksnummer()).isEqualTo(SAK);

        validateResult(dto);
        validateResult(roundtrip);
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