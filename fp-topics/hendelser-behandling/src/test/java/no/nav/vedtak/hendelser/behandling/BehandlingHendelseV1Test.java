package no.nav.vedtak.hendelser.behandling;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.Validation;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.vedtak.hendelser.behandling.v1.BehandlingHendelseV1;

public class BehandlingHendelseV1Test {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    @Test
    public void test_minimal_fp() throws Exception {
        var uuid = UUID.randomUUID();
        var tidspunkt = LocalDateTime.now();
        var inntektsmelding = new BehandlingHendelseV1.Builder()
                .medHendelseUuid(UUID.randomUUID())
                .medBehandlingUuid(uuid)
                .medHendelse(Hendelse.AKSJONSPUNKT)
                .medKildesystem(Kildesystem.FPSAK)
                .medTidspunkt(tidspunkt)
                .build();

        String json = WRITER.writeValueAsString(inntektsmelding);
        System.out.println(json);

        BehandlingHendelseV1 roundTripped = READER.forType(BehandlingHendelseV1.class).readValue(json);

        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.getBehandlingUuid()).isEqualTo(uuid);
        assertThat(roundTripped.getHendelse()).isEqualTo(Hendelse.AKSJONSPUNKT);
        assertThat(roundTripped.getKildesystem()).isEqualTo(Kildesystem.FPSAK);
        assertThat(roundTripped.getTidspunkt()).isEqualTo(tidspunkt);
        validateResult(roundTripped);
    }

    @Test
    public void test_maksimal_fp() throws Exception {
        var uuid = UUID.randomUUID();
        LocalDate startDato = LocalDate.now().plusWeeks(3);
        LocalDateTime innsending = LocalDateTime.now().minusMinutes(3);
        var inntektsmelding = new BehandlingHendelseV1.Builder()
            .medHendelseUuid(UUID.randomUUID())
            .medAktørId("1234567891234")
            .medBehandlingUuid(uuid)
            .medHendelse(Hendelse.OPPRETTET)
            .medKildesystem(Kildesystem.FPSAK)
            .medYtelse(Ytelse.FORELDREPENGER)
            .medBehandlingstype(Behandlingstype.FØRSTEGANGS)
            .medSaksnummer("123456789")
            .build();

        String json = WRITER.writeValueAsString(inntektsmelding);
        System.out.println(json);

        BehandlingHendelseV1 roundTripped = READER.forType(BehandlingHendelseV1.class).readValue(json);

        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.getBehandlingUuid()).isEqualTo(uuid);
        assertThat(roundTripped.getHendelse()).isEqualTo(Hendelse.OPPRETTET);
        assertThat(roundTripped.getKildesystem()).isEqualTo(Kildesystem.FPSAK);
        assertThat(roundTripped.getSaksnummer()).isEqualTo("123456789");
        validateResult(roundTripped);
    }



    private void validateResult(Object roundTripped) {
        assertThat(roundTripped).isNotNull();
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            var validator = factory.getValidator();
            var violations = validator.validate(roundTripped);
            assertThat(violations).isEmpty();
        }
    }
}