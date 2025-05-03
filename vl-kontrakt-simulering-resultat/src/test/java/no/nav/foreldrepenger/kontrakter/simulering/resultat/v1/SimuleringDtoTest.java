package no.nav.foreldrepenger.kontrakter.simulering.resultat.v1;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.validation.Validation;
import no.nav.foreldrepenger.kontrakter.simulering.resultat.kodeverk.Fagområde;
import no.nav.foreldrepenger.kontrakter.simulering.resultat.kodeverk.MottakerType;
import no.nav.foreldrepenger.kontrakter.simulering.resultat.kodeverk.RadId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class SimuleringDtoTest {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    private static final LocalDate IDAG = LocalDate.now();
    private static final LocalDate ENMND = LocalDate.now().plusMonths(1);

    @Test
    void skal_serialisere_og_deserialisere_request() throws Exception {
        // Arrange
        var prMåned1 = new SimuleringDto.SimuleringResultatPerMånedDto(new PeriodeDto(IDAG, IDAG), 1000L);
        var rad1 = new SimuleringDto.SimuleringResultatRadDto(RadId.RESULTAT, List.of(prMåned1));
        var prMåned2 = new SimuleringDto.SimuleringResultatPerMånedDto(new PeriodeDto(ENMND, ENMND), 1400L);
        var rad2 = new SimuleringDto.SimuleringResultatRadDto(RadId.INNTREKK_NESTE_MÅNED, List.of(prMåned2));
        var prFagområde = new SimuleringDto.SimuleringResultatPerFagområdeDto(Fagområde.FP, List.of(rad1, rad2));
        var prMottaker = new SimuleringDto.SimuleringForMottakerDto(MottakerType.BRUKER, "12345678901",
            "1234567890123", List.of(prFagområde), List.of(rad1), new PeriodeDto(null, null));
        var detaljert = new SimuleringDto.DetaljertSimuleringResultatDto(new PeriodeDto(IDAG, IDAG),  true,
        0L, 1000L, 1000L, List.of(prMottaker));
        var request = new SimuleringDto(detaljert, null, false);

        // Act
        var json = WRITER.writeValueAsString(request);
        //System.out.println(json);
        var roundTripped = (SimuleringDto)READER.forType(SimuleringDto.class).readValue(json);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.simuleringResultat().sumInntrekk()).isEqualTo(1000L);
        assertThat(roundTripped.simuleringResultat().perioderPerMottaker()).hasSize(1);
        Assertions.assertThat(roundTripped.simuleringResultat().perioderPerMottaker().get(0).mottakerType()).isEqualTo(MottakerType.BRUKER);
        assertThat(roundTripped.simuleringResultat().perioderPerMottaker().get(0).mottakerNummer()).isEqualTo("12345678901");

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