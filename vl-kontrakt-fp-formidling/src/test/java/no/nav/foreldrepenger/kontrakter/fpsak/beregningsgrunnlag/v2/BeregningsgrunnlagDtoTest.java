package no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2;

import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.AktivitetStatusDto;
import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.HjemmelDto;
import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.OpptjeningAktivitetDto;
import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.PeriodeÅrsakDto;
import no.nav.vedtak.mapper.json.DefaultJsonMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BeregningsgrunnlagDtoTest {

    @Test
    void testRoundtrip() {

        var perÅr = BigDecimal.valueOf(600000L);
        var dagsats = 3000L;
        var grunnbeløp = BigDecimal.valueOf(69000);
        var testIdent = "testIdent";
        var testRef = "testRef";
        var request = new BeregningsgrunnlagDto(
                List.of(AktivitetStatusDto.ARBEIDSTAKER, AktivitetStatusDto.DAGPENGER),
                HjemmelDto.F_14_7,
                grunnbeløp,
                List.of(new BeregningsgrunnlagPeriodeDto(
                        dagsats,
                        perÅr,
                        perÅr,
                        List.of(PeriodeÅrsakDto.ARBEIDSFORHOLD_AVSLUTTET),
                        LocalDate.now(),
                        LocalDate.now(),
                        List.of(new BeregningsgrunnlagAndelDto(
                                dagsats,
                                AktivitetStatusDto.ARBEIDSTAKER,
                                perÅr,
                                perÅr,
                                false,
                                OpptjeningAktivitetDto.ARBEID,
                                LocalDate.now(),
                                LocalDate.now(),
                                new BgAndelArbeidsforholdDto(testIdent, testRef, BigDecimal.ZERO, BigDecimal.ZERO),
                                false,
                                BigDecimal.valueOf(600000L)))
                        )),
                false,
                false); //denne vil alltid være false så lenge erBesteberegnet er false

        // Act
        var json = DefaultJsonMapper.toJson(request);

        var roundTripped = DefaultJsonMapper.fromJson(json, BeregningsgrunnlagDto.class);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.aktivitetstatusListe()).hasSize(2);
        assertThat(roundTripped.aktivitetstatusListe()).containsExactly(AktivitetStatusDto.ARBEIDSTAKER, AktivitetStatusDto.DAGPENGER);
        assertThat(roundTripped.grunnbeløp()).isEqualTo(grunnbeløp);
        assertThat(roundTripped.beregningsgrunnlagperioder()).hasSize(1);
        assertThat(roundTripped.beregningsgrunnlagperioder().getFirst().avkortetPrÅr()).isEqualTo(perÅr);
        assertThat(roundTripped.beregningsgrunnlagperioder().getFirst().bruttoPrÅr()).isEqualTo(perÅr);
        assertThat(roundTripped.beregningsgrunnlagperioder().getFirst().dagsats()).isEqualTo(dagsats);
        assertThat(roundTripped.beregningsgrunnlagperioder().getFirst().periodeårsaker()).containsExactly(PeriodeÅrsakDto.ARBEIDSFORHOLD_AVSLUTTET);

        assertThat(roundTripped.beregningsgrunnlagperioder().getFirst().beregningsgrunnlagandeler()).hasSize(1);
        assertThat(roundTripped.beregningsgrunnlagperioder().getFirst().beregningsgrunnlagandeler().getFirst().avkortetPrÅr()).isEqualTo(perÅr);
        assertThat(roundTripped.beregningsgrunnlagperioder().getFirst().beregningsgrunnlagandeler().getFirst().bruttoPrÅr()).isEqualTo(perÅr);
        assertThat(roundTripped.beregningsgrunnlagperioder().getFirst().beregningsgrunnlagandeler().getFirst().aktivitetStatus()).isEqualTo(AktivitetStatusDto.ARBEIDSTAKER);
        assertThat(roundTripped.beregningsgrunnlagperioder().getFirst().beregningsgrunnlagandeler().getFirst().arbeidsforholdType()).isEqualTo(OpptjeningAktivitetDto.ARBEID);
        assertThat(roundTripped.beregningsgrunnlagperioder().getFirst().beregningsgrunnlagandeler().getFirst().arbeidsforhold().arbeidsgiverIdent()).isEqualTo(testIdent);
        assertThat(roundTripped.beregningsgrunnlagperioder().getFirst().beregningsgrunnlagandeler().getFirst().arbeidsforhold().arbeidsforholdRef()).isEqualTo(testRef);
    }
}