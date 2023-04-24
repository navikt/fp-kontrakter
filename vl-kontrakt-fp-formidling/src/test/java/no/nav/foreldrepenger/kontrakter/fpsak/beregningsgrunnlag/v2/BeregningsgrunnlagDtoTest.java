package no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.YtelseType;
import no.nav.foreldrepenger.kontrakter.formidling.v1.DokumentbestillingV2Dto;
import no.nav.foreldrepenger.kontrakter.formidling.v1.TestJsonMapper;
import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.AktivitetStatusDto;
import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.HjemmelDto;
import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.OpptjeningAktivitetDto;
import no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk.PeriodeÅrsakDto;

class BeregningsgrunnlagDtoTest {

    private static final ObjectWriter WRITER = TestJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = TestJsonMapper.getMapper().reader();

    @Test
    void testRoundtrip() throws JsonProcessingException {

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
                                false))
                        )),
                false,
                false);

        // Act
        var json = WRITER.writeValueAsString(request);

        var roundTripped = (BeregningsgrunnlagDto) READER.forType(BeregningsgrunnlagDto.class).readValue(json);

        // Assert
        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.aktivitetstatusListe()).hasSize(2);
        assertThat(roundTripped.aktivitetstatusListe()).containsExactly(AktivitetStatusDto.ARBEIDSTAKER, AktivitetStatusDto.DAGPENGER);
        assertThat(roundTripped.grunnbeløp()).isEqualTo(grunnbeløp);
        assertThat(roundTripped.beregningsgrunnlagperioder()).hasSize(1);
        assertThat(roundTripped.beregningsgrunnlagperioder().get(0).avkortetPrÅr()).isEqualTo(perÅr);
        assertThat(roundTripped.beregningsgrunnlagperioder().get(0).bruttoPrÅr()).isEqualTo(perÅr);
        assertThat(roundTripped.beregningsgrunnlagperioder().get(0).dagsats()).isEqualTo(dagsats);
        assertThat(roundTripped.beregningsgrunnlagperioder().get(0).periodeårsaker()).containsExactly(PeriodeÅrsakDto.ARBEIDSFORHOLD_AVSLUTTET);

        assertThat(roundTripped.beregningsgrunnlagperioder().get(0).beregningsgrunnlagandeler()).hasSize(1);
        assertThat(roundTripped.beregningsgrunnlagperioder().get(0).beregningsgrunnlagandeler().get(0).avkortetPrÅr()).isEqualTo(perÅr);
        assertThat(roundTripped.beregningsgrunnlagperioder().get(0).beregningsgrunnlagandeler().get(0).bruttoPrÅr()).isEqualTo(perÅr);
        assertThat(roundTripped.beregningsgrunnlagperioder().get(0).beregningsgrunnlagandeler().get(0).aktivitetStatus()).isEqualTo(AktivitetStatusDto.ARBEIDSTAKER);
        assertThat(roundTripped.beregningsgrunnlagperioder().get(0).beregningsgrunnlagandeler().get(0).arbeidsforholdType()).isEqualTo(OpptjeningAktivitetDto.ARBEID);
        assertThat(roundTripped.beregningsgrunnlagperioder().get(0).beregningsgrunnlagandeler().get(0).arbeidsforhold().arbeidsgiverIdent()).isEqualTo(testIdent);
        assertThat(roundTripped.beregningsgrunnlagperioder().get(0).beregningsgrunnlagandeler().get(0).arbeidsforhold().arbeidsforholdRef()).isEqualTo(testRef);
    }
}