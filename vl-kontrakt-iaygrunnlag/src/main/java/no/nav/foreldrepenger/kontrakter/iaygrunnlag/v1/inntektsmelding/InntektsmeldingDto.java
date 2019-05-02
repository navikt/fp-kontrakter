package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.inntektsmelding;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektsmeldingInnsendingsårsakDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;

public class InntektsmeldingDto {
    private List<GraderingDto> graderinger;
    private List<NaturalYtelseDto> naturalytelser;
    private List<UtsettelsePeriodeDto> utsettelsePerioder;
    private ArbeidsgiverDto arbeidsgiver;
    private ArbeidsforholdRefDto arbeidsforholdRef;
    private LocalDate startDatoPermisjon;
    private boolean naerRelasjon;
    private Long mottattDokumentId;
    private BigDecimal inntektBeløp;
    private BigDecimal refusjonsBeløpPerMnd;
    private LocalDate refusjonOpphører;
    private LocalDateTime innsendingstidspunkt;
    private String kanalreferanse;
    private String kildesystem;
    private List<RefusjonDto> endringerRefusjon;
    private InntektsmeldingInnsendingsårsakDto innsendingsårsak;

    public InntektsmeldingDto() {
    }

    public List<GraderingDto> getGraderinger() {
        return graderinger;
    }

    public void setGraderinger(List<GraderingDto> graderinger) {
        this.graderinger = graderinger;
    }

    public List<NaturalYtelseDto> getNaturalytelser() {
        return naturalytelser;
    }

    public void setNaturalytelser(List<NaturalYtelseDto> naturalytelser) {
        this.naturalytelser = naturalytelser;
    }

    public List<UtsettelsePeriodeDto> getUtsettelsePerioder() {
        return utsettelsePerioder;
    }

    public void setUtsettelsePerioder(List<UtsettelsePeriodeDto> utsettelsePerioder) {
        this.utsettelsePerioder = utsettelsePerioder;
    }

    public ArbeidsgiverDto getArbeidsgiver() {
        return arbeidsgiver;
    }

    public void setArbeidsgiver(ArbeidsgiverDto arbeidsgiver) {
        this.arbeidsgiver = arbeidsgiver;
    }

    public ArbeidsforholdRefDto getArbeidsforholdRef() {
        return arbeidsforholdRef;
    }

    public void setArbeidsforholdRef(ArbeidsforholdRefDto arbeidsforholdRef) {
        this.arbeidsforholdRef = arbeidsforholdRef;
    }

    public LocalDate getStartDatoPermisjon() {
        return startDatoPermisjon;
    }

    public void setStartDatoPermisjon(LocalDate startDatoPermisjon) {
        this.startDatoPermisjon = startDatoPermisjon;
    }

    public boolean isNaerRelasjon() {
        return naerRelasjon;
    }

    public void setNaerRelasjon(boolean naerRelasjon) {
        this.naerRelasjon = naerRelasjon;
    }

    public Long getMottattDokumentId() {
        return mottattDokumentId;
    }

    public void setMottattDokumentId(Long mottattDokumentId) {
        this.mottattDokumentId = mottattDokumentId;
    }

    public BigDecimal getInntektBeløp() {
        return inntektBeløp;
    }

    public void setInntektBeløp(BigDecimal inntektBeløp) {
        this.inntektBeløp = inntektBeløp;
    }

    public BigDecimal getRefusjonsBeløpPerMnd() {
        return refusjonsBeløpPerMnd;
    }

    public void setRefusjonsBeløpPerMnd(BigDecimal refusjonsBeløpPerMnd) {
        this.refusjonsBeløpPerMnd = refusjonsBeløpPerMnd;
    }

    public LocalDate getRefusjonOpphører() {
        return refusjonOpphører;
    }

    public void setRefusjonOpphører(LocalDate refusjonOpphører) {
        this.refusjonOpphører = refusjonOpphører;
    }

    public LocalDateTime getInnsendingstidspunkt() {
        return innsendingstidspunkt;
    }

    public void setInnsendingstidspunkt(LocalDateTime innsendingstidspunkt) {
        this.innsendingstidspunkt = innsendingstidspunkt;
    }

    public String getKanalreferanse() {
        return kanalreferanse;
    }

    public void setKanalreferanse(String kanalreferanse) {
        this.kanalreferanse = kanalreferanse;
    }

    public String getKildesystem() {
        return kildesystem;
    }

    public void setKildesystem(String kildesystem) {
        this.kildesystem = kildesystem;
    }

    public List<RefusjonDto> getEndringerRefusjon() {
        return endringerRefusjon;
    }

    public void setEndringerRefusjon(List<RefusjonDto> endringerRefusjon) {
        this.endringerRefusjon = endringerRefusjon;
    }

    public InntektsmeldingInnsendingsårsakDto getInnsendingsårsak() {
        return innsendingsårsak;
    }

    public void setInnsendingsårsak(InntektsmeldingInnsendingsårsakDto innsendingsårsak) {
        this.innsendingsårsak = innsendingsårsak;
    }
}
