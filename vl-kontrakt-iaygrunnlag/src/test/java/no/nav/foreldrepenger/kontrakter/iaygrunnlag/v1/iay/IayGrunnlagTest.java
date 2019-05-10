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

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.FnrPersonident;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.IayGrunnlagJsonMapper;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.JournalpostId;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Organisasjon;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeid.v1.AktivitetsAvtaleDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeid.v1.ArbeidDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeid.v1.PermisjonDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeid.v1.YrkesaktivitetDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntekt.v1.InntekterDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntekt.v1.UtbetalingDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntekt.v1.UtbetalingsPostDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.GraderingDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.InntektsmeldingDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.InntektsmeldingerDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.NaturalytelseDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.RefusjonDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.UtsettelsePeriodeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidskategoriDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.Fagsystem;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektPeriodeTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektsmeldingInnsendingsårsakDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektspostTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.LandkoderDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.NaturalytelseTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.PermisjonsbeskrivelseTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.SkatteOgAvgiftsregelTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.UtsettelseÅrsakDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.VirksomhetTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseStatus;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittArbeidsforholdDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittEgenNæringDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittFrilansDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittFrilansoppdragDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittOpptjeningDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittUtenlandskVirksomhetDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.GrunnlagDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.InntektArbeidYtelseAggregatOverstyrtDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.InntektArbeidYtelseAggregatRegisterDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.ytelse.v1.AnvisningDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.ytelse.v1.FordelingDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.ytelse.v1.YtelseDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.ytelse.v1.YtelseGrunnlagDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.ytelse.v1.YtelserDto;

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
    private final JournalpostId journalpostId = new JournalpostId("ImajournalpostId");

    @Test
    public void skal_generere_og_validere_roundtrip_mega_iaygrunnlag_json() throws Exception {

        GrunnlagDto grunnlag = new GrunnlagDto(fnr, uuid);

        grunnlag.medRegister(
            new InntektArbeidYtelseAggregatRegisterDto(tidspunkt)
                .medArbeid(List.of(
                    new ArbeidDto(fnr)
                        .medYrkesaktiviteter(List.of(
                            new YrkesaktivitetDto(org, arbeidType)
                                .medPermisjoner(List.of(new PermisjonDto(periode, PermisjonsbeskrivelseTypeDto.PERMISJON).medProsentsats(50)))
                                .medAnsettelsesperiode(List.of(periode))
                                .medArbeidsforholdId(new ArbeidsforholdRefDto("intern", "ekstern"))
                                .medAktivitetsAvtaler(List.of(
                                    new AktivitetsAvtaleDto(periode)
                                        .medSistLønnsendring(fom)
                                        .medAntallTimer(40)
                                        .medStillingsprosent(50)))))))
                .medInntekt(List.of(
                    new InntekterDto(fnr)
                        .medUtbetalinger(List.of(
                            new UtbetalingDto(org)
                                .medKilde("ARBEID")
                                .medPoster(List.of(
                                    new UtbetalingsPostDto(ytelseType, periode, new InntektspostTypeDto("LØNN"))
                                        .medBeløp(100)
                                        .medSkattAvgiftType(SkatteOgAvgiftsregelTypeDto.NETTOLØNN)))))))
                .medYtelse(List.of(
                    new YtelserDto(fnr)
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
                                    new AnvisningDto(periode)
                                        .medBeløp(100)
                                        .medDagsats(100)
                                        .medUtbetalingsgrad(100))))))))
            .medOverstyrt(
                new InntektArbeidYtelseAggregatOverstyrtDto(tidspunkt)
                    .medArbeid(List.of(
                        new ArbeidDto(fnr)
                            .medYrkesaktiviteter(List.of(
                                new YrkesaktivitetDto(org, arbeidType)
                                    .medPermisjoner(List.of(new PermisjonDto(periode, PermisjonsbeskrivelseTypeDto.PERMISJON).medProsentsats(50)))
                                    .medAnsettelsesperiode(List.of(periode))
                                    .medArbeidsforholdId(new ArbeidsforholdRefDto("intern", "ekstern"))
                                    .medAktivitetsAvtaler(List.of(
                                        new AktivitetsAvtaleDto(periode)
                                            .medSistLønnsendring(fom)
                                            .medAntallTimer(40)
                                            .medStillingsprosent(30))))))))
            .medInntektsmeldinger(List.of(
                new InntektsmeldingerDto().medInntektsmeldinger(List.of(
                    new InntektsmeldingDto(org, journalpostId, tidspunkt)
                        .medArbeidsforholdRef(new ArbeidsforholdRefDto("internRef", "eksternRef"))
                        .medInnsendingsårsak(InntektsmeldingInnsendingsårsakDto.NY)
                        .medInntektBeløp(99999)
                        .medKanalreferanse("BBC")
                        .medKildesystem("TheSource")
                        .medRefusjonOpphører(fom)
                        .medRefusjonsBeløpPerMnd(100)
                        .medStartDatoPermisjon(fom)
                        .medNærRelasjon(false)
                        .medEndringerRefusjon(List.of(new RefusjonDto(fom, 100)))
                        .medGraderinger(List.of(new GraderingDto(periode, 50)))
                        .medNaturalytelser(List.of(new NaturalytelseDto(periode, NaturalytelseTypeDto.ELEKTRISK_KOMMUNIKASJON, 100)))
                        .medUtsettelsePerioder(List.of(new UtsettelsePeriodeDto(periode, UtsettelseÅrsakDto.LOVBESTEMT_FERIE)))))))
            .medOppgittOpptjening(
                new OppgittOpptjeningDto()
                    .medArbeidsforhold(List.of(
                        new OppgittArbeidsforholdDto(periode, ArbeidTypeDto.ORDINÆRT_ARBEIDSFORHOLD)
                            .medErUtenlandskInntekt(true)
                            .medUtenlandskVirksomhet(new OppgittUtenlandskVirksomhetDto(LandkoderDto.DANMARK, "GammelDansk"))))
                    .medEgenNæring(List.of(
                        new OppgittEgenNæringDto(periode)
                            .medBegrunnelse("MinBegrunnelse")
                            .medBruttoInntekt(10000)
                            .medEndringDato(fom)
                            .medNyIArbeidslivet(false)
                            .medNyoppstartet(false)
                            .medNærRelasjon(false)
                            .medOppgittUtenlandskVirksomhet(new OppgittUtenlandskVirksomhetDto(LandkoderDto.SVERIGE, "DuGamleDuFria"))
                            .medRegnskapsførerNavn("Regnskapsfører")
                            .medRegnskapsførerTlf("+47902348732")
                            .medVarigEndring(true)
                            .medVirksomhet(org)
                            .medVirksomhetTypeDto(VirksomhetTypeDto.ANNEN)))
                    .medAnnenAktivitet(List.of())
                    .medFrilans(new OppgittFrilansDto(List.of(
                        new OppgittFrilansoppdragDto(periode, "MittOppdrag")))
                            .medErNyoppstartet(false)
                            .medHarInntektFraFosterhjem(false)
                            .medHarNærRelasjon(false)));

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
