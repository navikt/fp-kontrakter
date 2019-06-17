package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

import javax.validation.Validation;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.AktørIdPersonident;
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
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeidsforhold.v1.ArbeidsforholdInformasjon;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeidsforhold.v1.ArbeidsforholdOverstyringDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeidsforhold.v1.ArbeidsforholdReferanseDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntekt.v1.InntekterDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntekt.v1.UtbetalingDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntekt.v1.UtbetalingsPostDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.GraderingDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.InntektsmeldingDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.InntektsmeldingerDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.NaturalytelseDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.RefusjonDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1.UtsettelsePeriodeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidsforholdHandlingType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.Arbeidskategori;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.BekreftetPermisjonStatus;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.Fagsystem;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektPeriodeType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektsmeldingInnsendingsårsakType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektspostType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.Landkode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.NaturalytelseType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.PermisjonsbeskrivelseType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.SkatteOgAvgiftsregelType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.TemaUnderkategori;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.UtbetaltYtelseFraOffentligeType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.UtsettelseÅrsakType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.VirksomhetType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseStatus;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittAnnenAktivitetDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittArbeidsforholdDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittEgenNæringDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittFrilansDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittFrilansoppdragDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittOpptjeningDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.InntektArbeidYtelseAggregatOverstyrtDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.InntektArbeidYtelseAggregatRegisterDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.InntektArbeidYtelseGrunnlagDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.InntektArbeidYtelseGrunnlagSakSnapshotDto;
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
    private final AktørIdPersonident aktørId = new AktørIdPersonident("9912341234123");
    private final Organisasjon org = new Organisasjon("022090422");
    private final ArbeidType arbeidType = ArbeidType.ORDINÆRT_ARBEIDSFORHOLD;
    private final Periode periode = new Periode(fom, tom);
    private final YtelseType ytelseType = YtelseType.FORELDREPENGER;
    private final UtbetaltYtelseFraOffentligeType utbetaltYtelse = new UtbetaltYtelseFraOffentligeType("FORELDREPENGER");
    private final LocalDateTime tidspunkt = LocalDateTime.now();
    private final JournalpostId journalpostId = new JournalpostId("ImajournalpostId");

    @Test
    public void skal_generere_og_validere_roundtrip_mega_iaygrunnlag_json() throws Exception {

        var grunnlag = byggInntektArbeidYtelseGrunnlag();

        String json = WRITER.writeValueAsString(grunnlag);
        System.out.println(json);

        InntektArbeidYtelseGrunnlagDto roundTripped = READER.forType(InntektArbeidYtelseGrunnlagDto.class).readValue(json);

        assertThat(roundTripped).isNotNull();
        assertThat(roundTripped.getPerson()).isNotNull();
        validateResult(roundTripped);

    }

    @Test
    public void skal_generere_og_validere_roundtrip_mega_iaygrunnlag_snapshot_json() throws Exception {

        var grunnlag = byggInntektArbeidYtelseGrunnlag();
        var snapshot = new InntektArbeidYtelseGrunnlagSakSnapshotDto("minsak", YtelseType.FORELDREPENGER, fnr);

        snapshot.leggTil(grunnlag, true, new Periode(LocalDate.now().minusMonths(17), LocalDate.now()), null);

        String json = WRITER.writeValueAsString(snapshot);
        System.out.println(json);

        InntektArbeidYtelseGrunnlagSakSnapshotDto roundTripped = READER.forType(InntektArbeidYtelseGrunnlagSakSnapshotDto.class).readValue(json);

        validateResult(roundTripped);

    }

    private InntektArbeidYtelseGrunnlagDto byggInntektArbeidYtelseGrunnlag() {
        OffsetDateTime offTidspunkt = tidspunkt.atZone(ZoneOffset.systemDefault()).toOffsetDateTime();

        var grunnlag = new InntektArbeidYtelseGrunnlagDto(aktørId, offTidspunkt, uuid, uuid);

        var arbeidsforholdId = new ArbeidsforholdRefDto(UUID.randomUUID().toString(), "aaregRef");

        grunnlag.medRegister(
            new InntektArbeidYtelseAggregatRegisterDto(tidspunkt, uuid)
                .medArbeid(List.of(
                    new ArbeidDto(fnr)
                        .medYrkesaktiviteter(List.of(
                            new YrkesaktivitetDto(arbeidType)
                                .medArbeidsgiver(org)
                                .medPermisjoner(List.of(new PermisjonDto(periode, PermisjonsbeskrivelseType.PERMISJON).medProsentsats(50)))
                                .medArbeidsforholdId(arbeidsforholdId)
                                .medNavnArbeidsgiverUtland("UtenlandskArbeidsgiverAS")
                                .medAktivitetsAvtaler(List.of(
                                    new AktivitetsAvtaleDto(periode)
                                        .medSistLønnsendring(fom)
                                        .medBeskrivelse("beskrivelse")
                                        .medStillingsprosent(50)))))))
                .medInntekt(List.of(
                    new InntekterDto(fnr)
                        .medUtbetalinger(List.of(
                            new UtbetalingDto("ARBEID")
                                .medArbeidsgiver(org)
                                .medPoster(List.of(
                                    new UtbetalingsPostDto(periode, new InntektspostType("LØNN"))
                                        .medUtbetaltYtelseType(utbetaltYtelse)
                                        .medBeløp(100)
                                        .medSkattAvgiftType(SkatteOgAvgiftsregelType.NETTOLØNN)))))))
                .medYtelse(List.of(
                    new YtelserDto(fnr)
                        .medYtelser(List.of(
                            new YtelseDto(Fagsystem.FPSAK, ytelseType, periode, YtelseStatus.LØPENDE)
                                .medSaksnummer("1234")
                                .medTemaUnderkategori(TemaUnderkategori.FORELDREPENGER_FODSEL)
                                .medGrunnlag(
                                    new YtelseGrunnlagDto()
                                        .medArbeidskategoriDto(Arbeidskategori.ARBEIDSTAKER)
                                        .medOpprinneligIdentDato(fom)
                                        .medDekningsgradProsent(100)
                                        .medInntektsgrunnlagProsent(100)
                                        .medGraderingProsent(100)
                                        .medFordeling(List.of(new FordelingDto(org, InntektPeriodeType.PER_DAG, 100))))
                                .medAnvisninger(List.of(
                                    new AnvisningDto(periode)
                                        .medBeløp(100)
                                        .medDagsats(100)
                                        .medUtbetalingsgrad(100))))))));

        grunnlag.medArbeidsforholdInformasjon(new ArbeidsforholdInformasjon()
            .medReferanser(List.of(new ArbeidsforholdReferanseDto(org, arbeidsforholdId)))
            .medOverstyringer(List.of(new ArbeidsforholdOverstyringDto(org, arbeidsforholdId)
                .medBegrunnelse("en begrunnelse")
                .medHandling(ArbeidsforholdHandlingType.BRUK_UTEN_INNTEKTSMELDING)
                .medNavn("Mitt arbeisforhold")
                .medStillingsprosent(100)
                .medBekreftetPermisjon(fom, tom, BekreftetPermisjonStatus.BRUK_PERMISJON))));

        grunnlag.medOverstyrt(
            new InntektArbeidYtelseAggregatOverstyrtDto(tidspunkt, uuid)
                .medArbeid(List.of(
                    new ArbeidDto(fnr)
                        .medYrkesaktiviteter(List.of(
                            new YrkesaktivitetDto(arbeidType)
                                .medArbeidsgiver(org)
                                .medPermisjoner(List.of(new PermisjonDto(periode, PermisjonsbeskrivelseType.PERMISJON).medProsentsats(50)))
                                .medArbeidsforholdId(new ArbeidsforholdRefDto(UUID.randomUUID().toString(), "ekstern"))
                                .medAktivitetsAvtaler(List.of(
                                    new AktivitetsAvtaleDto(periode)
                                        .medSistLønnsendring(fom)
                                        .medBeskrivelse("beskrivelse")
                                        .medStillingsprosent(30))))))));

        grunnlag.medInntektsmeldinger(
            new InntektsmeldingerDto().medInntektsmeldinger(List.of(
                new InntektsmeldingDto(org, journalpostId, tidspunkt, fom)
                    .medArbeidsforholdRef(new ArbeidsforholdRefDto(UUID.randomUUID().toString(), "eksternRef"))
                    .medInnsendingsårsak(InntektsmeldingInnsendingsårsakType.NY)
                    .medInntektBeløp(99999)
                    .medKanalreferanse("BBC")
                    .medKildesystem("TheSource")
                    .medRefusjonOpphører(fom)
                    .medRefusjonsBeløpPerMnd(100)
                    .medStartDatoPermisjon(fom)
                    .medNærRelasjon(false)
                    .medEndringerRefusjon(List.of(new RefusjonDto(fom, 100)))
                    .medGraderinger(List.of(new GraderingDto(periode, 50)))
                    .medNaturalytelser(List.of(new NaturalytelseDto(periode, NaturalytelseType.ELEKTRISK_KOMMUNIKASJON, 100)))
                    .medUtsettelsePerioder(List.of(new UtsettelsePeriodeDto(periode, UtsettelseÅrsakType.LOVBESTEMT_FERIE))))));

        grunnlag.medOppgittOpptjening(
            new OppgittOpptjeningDto(uuid, offTidspunkt)
                .medArbeidsforhold(List.of(
                    new OppgittArbeidsforholdDto(periode, ArbeidType.ORDINÆRT_ARBEIDSFORHOLD)
                        .medErUtenlandskInntekt(true)
                        .medOppgittVirksomhetNavn("GammelDansk", Landkode.DANMARK)))
                .medEgenNæring(List.of(
                    new OppgittEgenNæringDto(periode)
                        .medBegrunnelse("MinBegrunnelse")
                        .medBruttoInntekt(10000)
                        .medEndringDato(fom)
                        .medNyIArbeidslivet(false)
                        .medNyoppstartet(false)
                        .medNærRelasjon(false)
                        .medOppgittVirksomhetNavn("DuGamleDuFria", Landkode.SVERIGE)
                        .medRegnskapsførerNavn("Regnskapsfører")
                        .medRegnskapsførerTlf("+47902348732")
                        .medVarigEndring(true)
                        .medVirksomhet(org)
                        .medVirksomhetType(VirksomhetType.ANNEN)))
                .medAnnenAktivitet(List.of(new OppgittAnnenAktivitetDto(periode, arbeidType)))
                .medFrilans(new OppgittFrilansDto(List.of(
                    new OppgittFrilansoppdragDto(periode, "MittOppdrag")))
                        .medErNyoppstartet(false)
                        .medHarInntektFraFosterhjem(false)
                        .medHarNærRelasjon(false)));
        return grunnlag;
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
