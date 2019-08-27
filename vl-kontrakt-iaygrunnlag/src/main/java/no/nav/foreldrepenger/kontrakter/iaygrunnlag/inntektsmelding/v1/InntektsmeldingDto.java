package no.nav.foreldrepenger.kontrakter.iaygrunnlag.inntektsmelding.v1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Aktør;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.JournalpostId;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.InntektsmeldingInnsendingsårsakType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class InntektsmeldingDto {

    @JsonProperty(value = "arbeidsgiver", required = true)
    @Valid
    @NotNull
    private Aktør arbeidsgiver;

    @JsonProperty(value = "journalpostId", required = true)
    @NotNull
    @Valid
    private JournalpostId journalpostId;

    @JsonProperty(value = "innsendingstidspunkt", required = true)
    @NotNull
    @Valid
    private OffsetDateTime innsendingstidspunkt;

    @JsonProperty(value = "mottattDato", required = true)
    @NotNull
    @Valid
    private LocalDate mottattDato;

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

    /** Tillater kun positive verdier.  Max verdi håndteres av mottager. */
    @JsonProperty("inntektBeløp")
    @DecimalMin(value = "0.00", message = "beløp '${validatedValue}' må være >= {value}")
    private BigDecimal inntektBeløp;

    /** Tillater kun positive verdier.  Max verdi håndteres av mottager. */
    @JsonProperty("refusjonsBeløpPerMnd")
    @DecimalMin(value = "0.00", message = "beløp '${validatedValue}' må være >= {value}")
    private BigDecimal refusjonsBeløpPerMnd;

    @JsonProperty(value = "kanalreferanse")
    @Pattern(regexp = "^[\\p{L}\\p{N}\\.\\-()/$=#\\\\,\\+:/\\[\\]@\\s]+$", message="Inntektsmelding kanalreferanse '${validatedValue}' matcher ikke tillatt pattern '{regexp}'")
    private String kanalreferanse;

    /** NB: tilsvarer avsendersystem i Inntektsmelding skjema. */
    @JsonProperty(value = "kildesystem")
    @Pattern(regexp = "^[\\p{L}\\p{N}\\.\\-()/$=#\\\\,\\+:/\\[\\]@\\s]+$", message="Inntektsmelding kildeSystem '${validatedValue}' matcher ikke tillatt pattern '{regexp}'")
    private String kildesystem;

    @JsonProperty(value = "refusjonOpphører")
    private LocalDate refusjonOpphører;

    @JsonProperty(value = "refusjonEndringer")
    private List<RefusjonDto> refusjonEndringer;

    @JsonProperty(value = "innsendingsårsak", required = true)
    @Valid
    @NotNull
    private InntektsmeldingInnsendingsårsakType innsendingsårsak;

    public InntektsmeldingDto(Aktør arbeidsgiver, JournalpostId journalpostId, LocalDateTime innsendingstidspunkt, LocalDate mottattDato) {
        Objects.requireNonNull(arbeidsgiver, "arbeidsgiver");
        Objects.requireNonNull(journalpostId, "journalpostId");
        Objects.requireNonNull(innsendingstidspunkt, "innsendingstidspunkt");
        Objects.requireNonNull(mottattDato, "mottattDato");
        this.arbeidsgiver = arbeidsgiver;
        this.journalpostId = journalpostId;
        this.mottattDato = mottattDato;
        this.innsendingstidspunkt = innsendingstidspunkt.atZone(ZoneId.systemDefault()).toOffsetDateTime();
    }

    protected InntektsmeldingDto() {
        // for jackson
    }

    public ArbeidsforholdRefDto getArbeidsforholdRef() {
        return arbeidsforholdRef;
    }

    public Aktør getArbeidsgiver() {
        return arbeidsgiver;
    }

    public List<RefusjonDto> getEndringerRefusjon() {
        return refusjonEndringer == null ? Collections.emptyList() : List.copyOf(refusjonEndringer);
    }

    public List<GraderingDto> getGraderinger() {
        return graderinger == null ? Collections.emptyList() : List.copyOf(graderinger);
    }

    public OffsetDateTime getInnsendingstidspunkt() {
        return innsendingstidspunkt;
    }

    public InntektsmeldingInnsendingsårsakType getInnsendingsårsak() {
        return innsendingsårsak;
    }

    public BigDecimal getInntektBeløp() {
        return inntektBeløp;
    }

    public JournalpostId getJournalpostId() {
        return journalpostId;
    }

    public String getKanalreferanse() {
        return kanalreferanse;
    }

    public String getKildesystem() {
        return kildesystem;
    }

    public LocalDate getMottattDato() {
        return mottattDato;
    }

    public List<NaturalytelseDto> getNaturalytelser() {
        return naturalytelser == null ? Collections.emptyList(): List.copyOf(naturalytelser);
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
        return utsettelsePerioder == null ? Collections.emptyList() : List.copyOf(utsettelsePerioder);
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

    public InntektsmeldingDto medInnsendingsårsak(InntektsmeldingInnsendingsårsakType innsendingsårsak) {
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

    public InntektsmeldingDto medMottattDato(LocalDate mottattDato) {
        setMottattDato(mottattDato);
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

    public void setInnsendingsårsak(InntektsmeldingInnsendingsårsakType innsendingsårsak) {
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

    public void setMottattDato(LocalDate mottattDato) {
        this.mottattDato = mottattDato;
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
