package no.nav.foreldrepenger.kontrakter.fpsak.tilkjentytelse;

import no.nav.vedtak.mapper.json.DefaultJsonMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class TilkjentYtelseDagytelseDtoTest {

    @Test
    void testRoundtrip() {
        var andelRequest = new TilkjentYtelseDagytelseDto.TilkjentYtelseAndelDto("999999999",
                200000, 100000, TilkjentYtelseDagytelseDto.Aktivitetstatus.ARBEIDSTAKER,
                "arb001", BigDecimal.valueOf(100), BigDecimal.valueOf(100));
        var periodeRequest = new TilkjentYtelseDagytelseDto.TilkjentYtelsePeriodeDto(LocalDate.now(), LocalDate.now().plusDays(10), 0,
                Collections.singletonList(
                        andelRequest));
        var grunnlagRequest = new TilkjentYtelseDagytelseDto(Collections.singletonList(periodeRequest));

        // Act
        var json = DefaultJsonMapper.toJson(grunnlagRequest);

        var grunnlagResponse = DefaultJsonMapper.fromJson(json, TilkjentYtelseDagytelseDto.class);

        // Assert
        assertThat(grunnlagResponse).isNotNull();
        assertThat(grunnlagResponse.perioder()).hasSize(1);
        var periodeResponse = grunnlagResponse.perioder().getFirst();
        assertThat(periodeResponse.fom()).isEqualTo(periodeRequest.fom());
        assertThat(periodeResponse.tom()).isEqualTo(periodeRequest.tom());
        assertThat(periodeResponse.dagsats()).isEqualTo(periodeRequest.dagsats());
        assertThat(periodeResponse.andeler()).hasSize(1);
        var andelResponse = periodeResponse.andeler().getFirst();
        assertThat(andelResponse.aktivitetstatus()).isEqualTo(andelRequest.aktivitetstatus());
        assertThat(andelResponse.arbeidsforholdId()).isEqualTo(andelRequest.arbeidsforholdId());
        assertThat(andelResponse.arbeidsgiverReferanse()).isEqualTo(andelRequest.arbeidsgiverReferanse());
        assertThat(andelResponse.refusjon()).isEqualTo(andelRequest.refusjon());
        assertThat(andelResponse.tilSoker()).isEqualTo(andelRequest.tilSoker());
        assertThat(andelResponse.stillingsprosent()).isEqualByComparingTo(andelRequest.stillingsprosent());
        assertThat(andelResponse.utbetalingsgrad()).isEqualByComparingTo(andelRequest.utbetalingsgrad());
    }
}
