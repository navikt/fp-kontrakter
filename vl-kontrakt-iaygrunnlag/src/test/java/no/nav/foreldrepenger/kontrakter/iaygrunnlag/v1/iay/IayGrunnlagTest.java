package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.validation.Validation;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.IayGrunnlagJsonMapper;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidskategoriDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.Fagsystem;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektPeriodeTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektspostTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.SkatteOgAvgiftsregelTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseStatus;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.FnrPersonident;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.Organisasjon;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid.AktivitetsAvtaleDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid.ArbeidDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid.YrkesaktivitetDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt.InntekterDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt.UtbetalingDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt.UtbetalingsPostDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse.AnvisningDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse.FordelingDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse.YtelseDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse.YtelseGrunnlagDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse.YtelserDto;

public class IayGrunnlagTest {

    private static final ObjectWriter WRITER = IayGrunnlagJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = IayGrunnlagJsonMapper.getMapper().reader();

    private final UUID uuid = UUID.randomUUID();
    private final LocalDate fom = LocalDate.now();
    private final LocalDate tom = LocalDate.now();
    private final FnrPersonident fnr = new FnrPersonident("12341234123");
    private final Organisasjon org = new Organisasjon("022090422");
    private final ArbeidTypeDto arbeidType = ArbeidTypeDto.ORDINÆRT_ARBEIDSFORHOLD;
    private final Periode periode = new Periode(fom, tom);
    private final YtelseType ytelseType = YtelseType.FORELDREPENGER;
    private final LocalDateTime tidspunkt = LocalDateTime.now();

    @Test
    public void skal_generere_og_validere_roundtrip_mega_iaygrunnlag_json() throws Exception {

        GrunnlagDto grunnlag = new GrunnlagDto(fnr, uuid);

        grunnlag.medRegister(new InntektArbeidYtelseAggregatDto(tidspunkt)
            .medArbeid(List.of(new ArbeidDto(fnr)
                .medYrkesaktiviteter(List.of(new YrkesaktivitetDto(org, arbeidType)
                    .medAktivitetsAvtaler(List.of(
                        new AktivitetsAvtaleDto(periode)
                            .medAntallTimer(40)
                            .medStillingsprosent(50)))))))
            .medInntekt(List.of(new InntekterDto(fnr)
                .medUtbetalinger(List.of(
                    new UtbetalingDto(org)
                        .medKilde("ARBEID")
                        .medPoster(List.of(
                            new UtbetalingsPostDto(ytelseType, periode, new InntektspostTypeDto("LØNN"))
                                .medBeløp(100)
                                .medSkattAvgiftType(SkatteOgAvgiftsregelTypeDto.NETTOLØNN)))))))
            .medYtelse(List.of(new YtelserDto(fnr)
                .medYtelser(List.of(
                    new YtelseDto(Fagsystem.FPSAK, ytelseType, periode, YtelseStatus.LØPENDE, "1234")
                        .medGrunnlag(
                            new YtelseGrunnlagDto()
                                .medArbeidskategoriDto(ArbeidskategoriDto.ARBEIDSTAKER)
                                .medOpprinneligIdentDato(fom)
                                .medDekningsgradProsent(100)
                                .medInntektsgrunnlagProsent(100)
                                .medGraderingProsent(100)
                                .medFordeling(List.of(new FordelingDto(org, InntektPeriodeTypeDto.PER_DAG, 100))))
                        .medAnvisninger(List.of(
                            new AnvisningDto(periode).medBeløp(100).medDagsats(100))))))))
        ;

        String json = WRITER.writeValueAsString(grunnlag);
        System.out.println(json);

        GrunnlagDto roundTripped = READER.forType(GrunnlagDto.class).readValue(json);

        validateResult(roundTripped);

    }

    private void validateResult(GrunnlagDto roundTripped) {
        assertThat(roundTripped).isNotNull();
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            var validator = factory.getValidator();
            var violations = validator.validate(roundTripped);
            assertThat(violations).isEmpty();
        }
    }
}
