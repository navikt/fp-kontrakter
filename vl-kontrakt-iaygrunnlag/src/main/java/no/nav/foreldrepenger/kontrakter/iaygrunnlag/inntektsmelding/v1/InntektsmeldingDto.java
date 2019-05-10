package no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Aktør;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.JournalpostId;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektsmeldingInnsendingsårsakDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class InntektsmeldingDto {

    @JsonProperty(value = "arbeidsgiver", required = true)
    @Valid
    @NotNull
    private Aktør arbeidsgiver;

    @JsonProperty(value = "journalpostId", required = true)
    @NotNull
    private JournalpostId journalpostId;

    @JsonProperty(value = "innsendingstidspunkt", required = true)
    private OffsetDateTime innsendingstidspunkt;

    @JsonProperty(value = "graderinger")
    @Valid
    private List<GraderingDto> graderinger;

    @JsonProperty(value = "naturalytelser")
    @Valid
    private List<NaturalytelseDto> naturalytelser;

    @JsonProperty(value = "utsettelsePerioder")
    @Valid
    private List<UtsettelsePeriodeDto> utsettelsePerioder;

    @JsonProperty(value = "arbeidsforholdReferanse")
    @Valid
    private ArbeidsforholdRefDto arbeidsforholdRef;

    @JsonProperty(value = "startdatoPermisjon")
    private LocalDate startdatoPermisjon;

    @JsonProperty(value = "erNærRelasjon")
    private Boolean erNærRelasjon;

    @JsonProperty("inntektBeløp")
    @DecimalMin(value = "0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value = "100000000.00", message = "beløp må være < 100000000.00") // TODO: sane verdier
    private BigDecimal inntektBeløp;

    @JsonProperty("refusjonsBeløpPerMnd")
    @DecimalMin(value = "0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value = "100000000.00", message = "beløp må være < 100000000.00") // TODO: sane verdier
    private BigDecimal refusjonsBeløpPerMnd;

    @JsonProperty(value = "kanalreferanse")
    private String kanalreferanse;

    @JsonProperty(value = "kildesystem")
    private String kildesystem;

    @JsonProperty(value = "refusjonOpphører")
    private LocalDate refusjonOpphører;

    @JsonProperty(value = "refusjonEndringer")
    private List<RefusjonDto> refusjonEndringer;

    @JsonProperty(value = "innsendingsårsak")
    private InntektsmeldingInnsendingsårsakDto innsendingsårsak;

    public InntektsmeldingDto(Aktør arbeidsgiver, JournalpostId journalpostId, LocalDateTime innsendingstidspunkt) {
        this.arbeidsgiver = arbeidsgiver;
        this.journalpostId = journalpostId;
        this.innsendingstidspunkt = innsendingstidspunkt == null ? null : innsendingstidspunkt.atZone(ZoneId.of("Europe/Oslo")).toOffsetDateTime();
    }

    protected InntektsmeldingDto() {
    }

    public ArbeidsforholdRefDto getArbeidsforholdRef() {
        return arbeidsforholdRef;
    }

    public Aktør getArbeidsgiver() {
        return arbeidsgiver;
    }

    public List<RefusjonDto> getEndringerRefusjon() {
        return refusjonEndringer;
    }

    public List<GraderingDto> getGraderinger() {
        return graderinger;
    }

    public OffsetDateTime getInnsendingstidspunkt() {
        return innsendingstidspunkt;
    }

    public InntektsmeldingInnsendingsårsakDto getInnsendingsårsak() {
        return innsendingsårsak;
    }

    public BigDecimal getInntektBeløp() {
        return inntektBeløp;
    }

    public String getKanalreferanse() {
        return kanalreferanse;
    }

    public String getKildesystem() {
        return kildesystem;
    }

    public JournalpostId getJournalpostId() {
        return journalpostId;
    }

    public List<NaturalytelseDto> getNaturalytelser() {
        return naturalytelser;
    }

    public LocalDate getRefusjonOpphører() {
        return refusjonOpphører;
    }

    public BigDecimal getRefusjonsBeløpPerMnd() {
        return refusjonsBeløpPerMnd;
    }

    public LocalDate getStartDatoPermisjon() {
        return startdatoPermisjon;
    }

    public List<UtsettelsePeriodeDto> getUtsettelsePerioder() {
        return utsettelsePerioder;
    }

    public Boolean isNærRelasjon() {
        return erNærRelasjon;
    }

    public InntektsmeldingDto medArbeidsforholdRef(ArbeidsforholdRefDto arbeidsforholdRef) {
        setArbeidsforholdRef(arbeidsforholdRef);
        return this;
    }

    public InntektsmeldingDto medEndringerRefusjon(List<RefusjonDto> endringerRefusjon) {
        setEndringerRefusjon(endringerRefusjon);
        return this;
    }

    public InntektsmeldingDto medGraderinger(List<GraderingDto> graderinger) {
        setGraderinger(graderinger);
        return this;
    }

    public InntektsmeldingDto medInnsendingsårsak(InntektsmeldingInnsendingsårsakDto innsendingsårsak) {
        setInnsendingsårsak(innsendingsårsak);
        return this;
    }

    public InntektsmeldingDto medInntektBeløp(BigDecimal inntektBeløp) {
        setInntektBeløp(inntektBeløp);
        return this;
    }

    public InntektsmeldingDto medInntektBeløp(int inntektBeløp) {
        setInntektBeløp(BigDecimal.valueOf(inntektBeløp));
        return this;
    }

    public InntektsmeldingDto medKanalreferanse(String kanalreferanse) {
        setKanalreferanse(kanalreferanse);
        return this;
    }

    public InntektsmeldingDto medKildesystem(String kildesystem) {
        setKildesystem(kildesystem);
        return this;
    }

    public InntektsmeldingDto medNaturalytelser(List<NaturalytelseDto> naturalytelser) {
        setNaturalytelser(naturalytelser);
        return this;
    }

    public InntektsmeldingDto medNærRelasjon(boolean naerRelasjon) {
        setNærRelasjon(naerRelasjon);
        return this;
    }

    public InntektsmeldingDto medRefusjonOpphører(LocalDate refusjonOpphører) {
        setRefusjonOpphører(refusjonOpphører);
        return this;
    }

    public InntektsmeldingDto medRefusjonsBeløpPerMnd(BigDecimal refusjonsBeløpPerMnd) {
        setRefusjonsBeløpPerMnd(refusjonsBeløpPerMnd);
        return this;
    }

    public InntektsmeldingDto medRefusjonsBeløpPerMnd(int refusjonsBeløpPerMnd) {
        setRefusjonsBeløpPerMnd(BigDecimal.valueOf(refusjonsBeløpPerMnd));
        return this;
    }

    public InntektsmeldingDto medStartDatoPermisjon(LocalDate startDatoPermisjon) {
        setStartDatoPermisjon(startDatoPermisjon);
        return this;
    }

    public InntektsmeldingDto medUtsettelsePerioder(List<UtsettelsePeriodeDto> utsettelsePerioder) {
        setUtsettelsePerioder(utsettelsePerioder);
        return this;
    }

    public void setArbeidsforholdRef(ArbeidsforholdRefDto arbeidsforholdRef) {
        this.arbeidsforholdRef = arbeidsforholdRef;
    }

    public void setEndringerRefusjon(List<RefusjonDto> endringerRefusjon) {
        this.refusjonEndringer = endringerRefusjon;
    }

    public void setGraderinger(List<GraderingDto> graderinger) {
        this.graderinger = graderinger;
    }

    public void setInnsendingsårsak(InntektsmeldingInnsendingsårsakDto innsendingsårsak) {
        this.innsendingsårsak = innsendingsårsak;
    }

    public void setInntektBeløp(BigDecimal inntektBeløp) {
        this.inntektBeløp = inntektBeløp == null ? null : inntektBeløp.setScale(2, RoundingMode.HALF_UP);
    }

    public void setKanalreferanse(String kanalreferanse) {
        this.kanalreferanse = kanalreferanse;
    }

    public void setKildesystem(String kildesystem) {
        this.kildesystem = kildesystem;
    }

    public void setNaturalytelser(List<NaturalytelseDto> naturalytelser) {
        this.naturalytelser = naturalytelser;
    }

    public void setNærRelasjon(boolean naerRelasjon) {
        this.erNærRelasjon = naerRelasjon;
    }

    public void setRefusjonOpphører(LocalDate refusjonOpphører) {
        this.refusjonOpphører = refusjonOpphører;
    }

    public void setRefusjonsBeløpPerMnd(BigDecimal refusjonsBeløpPerMnd) {
        this.refusjonsBeløpPerMnd = refusjonsBeløpPerMnd == null ? null : refusjonsBeløpPerMnd.setScale(2, RoundingMode.HALF_UP);
    }

    public void setStartDatoPermisjon(LocalDate startDatoPermisjon) {
        this.startdatoPermisjon = startDatoPermisjon;
    }

    public void setUtsettelsePerioder(List<UtsettelsePeriodeDto> utsettelsePerioder) {
        this.utsettelsePerioder = utsettelsePerioder;
    }
}
