package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.inntektsmelding;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektsmeldingInnsendingsårsakDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class InntektsmeldingDto {
    
    @JsonProperty(value = "arbeidsgiver", required = true)
    @Valid
    @NotNull
    private ArbeidsgiverDto arbeidsgiver;

    @JsonProperty(value = "mottattDokumentId", required = true)
    @NotNull
    private Long mottattDokumentId;
    
    @JsonProperty(value = "innsendingstidspunkt", required = true)
    private LocalDateTime innsendingstidspunkt;
    
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
    private boolean erNærRelasjon;
    
    @JsonProperty("inntektBeløp")
    @DecimalMin(value="0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value="1000000.00", message="beløp må være < 1000000.00")  // TODO: sane verdier
    private BigDecimal inntektBeløp;
    
    @JsonProperty("refusjonsBeløpPerMnd")
    @DecimalMin(value="0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value="1000000.00", message="beløp må være < 1000000.00")  // TODO: sane verdier
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

    protected InntektsmeldingDto() {
    }

    public InntektsmeldingDto(ArbeidsgiverDto arbeidsgiver, Long mottattDokumentId, LocalDateTime innsendingstidspunkt) {
        this.arbeidsgiver = arbeidsgiver;
        this.mottattDokumentId = mottattDokumentId;
        this.innsendingstidspunkt = innsendingstidspunkt;
    }



    public List<GraderingDto> getGraderinger() {
        return graderinger;
    }

    public void setGraderinger(List<GraderingDto> graderinger) {
        this.graderinger = graderinger;
    }

    public List<NaturalytelseDto> getNaturalytelser() {
        return naturalytelser;
    }

    public void setNaturalytelser(List<NaturalytelseDto> naturalytelser) {
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

    public ArbeidsforholdRefDto getArbeidsforholdRef() {
        return arbeidsforholdRef;
    }

    public void setArbeidsforholdRef(ArbeidsforholdRefDto arbeidsforholdRef) {
        this.arbeidsforholdRef = arbeidsforholdRef;
    }

    public LocalDate getStartDatoPermisjon() {
        return startdatoPermisjon;
    }

    public void setStartDatoPermisjon(LocalDate startDatoPermisjon) {
        this.startdatoPermisjon = startDatoPermisjon;
    }

    public boolean isNaerRelasjon() {
        return erNærRelasjon;
    }

    public void setNaerRelasjon(boolean naerRelasjon) {
        this.erNærRelasjon = naerRelasjon;
    }

    public Long getMottattDokumentId() {
        return mottattDokumentId;
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
        return refusjonEndringer;
    }

    public void setEndringerRefusjon(List<RefusjonDto> endringerRefusjon) {
        this.refusjonEndringer = endringerRefusjon;
    }

    public InntektsmeldingInnsendingsårsakDto getInnsendingsårsak() {
        return innsendingsårsak;
    }

    public void setInnsendingsårsak(InntektsmeldingInnsendingsårsakDto innsendingsårsak) {
        this.innsendingsårsak = innsendingsårsak;
    }
}
