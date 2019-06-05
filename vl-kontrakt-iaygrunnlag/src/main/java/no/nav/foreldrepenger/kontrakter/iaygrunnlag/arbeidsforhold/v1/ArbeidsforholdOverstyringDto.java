package no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeidsforhold.v1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
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
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidsforholdHandlingType;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.BekreftetPermisjonStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class ArbeidsforholdOverstyringDto {

    @JsonProperty(value = "arbeidsgiver", required = true)
    @Valid
    @NotNull
    private Aktør arbeidsgiver;

    @JsonProperty(value = "arbeidsforholdReferanse")
    @Valid
    @NotNull
    private ArbeidsforholdRefDto arbeidsforholdRef;

    @JsonProperty(value = "nyArbeidsforholdReferanse")
    @Valid
    private ArbeidsforholdRefDto nyArbeidsforholdRef;

    @JsonProperty(value = "arbeidsforholdHandlingType", required = true)
    @Valid
    private ArbeidsforholdHandlingType handling;

    @JsonProperty(value = "overstyringBegrunnelse")
    private String begrunnelse;

    @JsonProperty(value = "arbeidsgiverNavn")
    @Pattern(regexp = "^[\\p{L}\\p{N}\\.\\- ]+$")
    private String arbeidsgiverNavn;

    @JsonProperty(value = "stillingsprosent")
    @DecimalMin(value = "0.00", message = "må være >= 0.00")
    @DecimalMax(value = "500.00", message = "må være < 500.00") // TODO: mer sane verdier
    private BigDecimal stillingsprosent;

    @JsonProperty(value = "overstyrtePerioder")
    @Valid
    private List<Periode> arbeidsforholdOverstyrtePerioder;

    @JsonProperty(value = "bekreftetPermisjon")
    @Valid
    private BekreftetPermisjon bekreftetPermisjon;

    protected ArbeidsforholdOverstyringDto() {
        // default ctor
    }

    public ArbeidsforholdOverstyringDto(Aktør arbeidsgiver, ArbeidsforholdRefDto arbeidsforholdRef) {
        super();
        this.arbeidsgiver = arbeidsgiver;
        this.arbeidsforholdRef = arbeidsforholdRef;
    }

    public Aktør getArbeidsgiver() {
        return arbeidsgiver;
    }

    public ArbeidsforholdRefDto getArbeidsforholdRef() {
        return arbeidsforholdRef;
    }

    public ArbeidsforholdRefDto getNyArbeidsforholdRef() {
        return nyArbeidsforholdRef;
    }

    public void setNyArbeidsforholdRef(ArbeidsforholdRefDto nyArbeidsforholdRef) {
        this.nyArbeidsforholdRef = nyArbeidsforholdRef;
    }

    public ArbeidsforholdHandlingType getHandling() {
        return handling;
    }

    public void setHandling(ArbeidsforholdHandlingType handling) {
        this.handling = handling;
    }

    public String getBegrunnelse() {
        return begrunnelse;
    }

    public void setBegrunnelse(String begrunnelse) {
        this.begrunnelse = begrunnelse;
    }

    public String getAngittArbeidsgiverNavn() {
        return arbeidsgiverNavn;
    }

    public void setNavn(String navn) {
        this.arbeidsgiverNavn = navn;
    }

    public BigDecimal getStillingsprosent() {
        return stillingsprosent;
    }

    public void setStillingsprosent(BigDecimal stillingsprosent) {
        this.stillingsprosent = stillingsprosent;
    }

    public List<Periode> getArbeidsforholdOverstyrtePerioder() {
        return arbeidsforholdOverstyrtePerioder;
    }

    public void setArbeidsforholdOverstyrtePerioder(List<Periode> arbeidsforholdOverstyrtePerioder) {
        this.arbeidsforholdOverstyrtePerioder = arbeidsforholdOverstyrtePerioder;
    }

    public ArbeidsforholdOverstyringDto medArbeidsforholdOverstyrtePerioder(List<Periode> arbeidsforholdOverstyrtePerioder) {
        setArbeidsforholdOverstyrtePerioder(arbeidsforholdOverstyrtePerioder);
        return this;
    }

    public ArbeidsforholdOverstyringDto medBegrunnelse(String begrunnelse) {
        setBegrunnelse(begrunnelse);
        return this;
    }

    public ArbeidsforholdOverstyringDto medHandling(ArbeidsforholdHandlingType handling) {
        setHandling(handling);
        return this;
    }

    public ArbeidsforholdOverstyringDto medNavn(String navn) {
        setNavn(navn);
        return this;
    }

    public ArbeidsforholdOverstyringDto medNyArbeidsforholdRef(ArbeidsforholdRefDto nyArbeidsforholdRef) {
        setNyArbeidsforholdRef(nyArbeidsforholdRef);
        return this;
    }

    public ArbeidsforholdOverstyringDto medStillingsprosent(BigDecimal stillingsprosent) {
        setStillingsprosent(stillingsprosent);
        return this;
    }

    public ArbeidsforholdOverstyringDto medStillingsprosent(int stillingsprosent) {
        setStillingsprosent(BigDecimal.valueOf(stillingsprosent));
        return this;
    }

    public ArbeidsforholdOverstyringDto medBekreftetPermisjon(BekreftetPermisjon bekreftetPermisjon) {
        this.bekreftetPermisjon = bekreftetPermisjon;
        return this;
    }

    public ArbeidsforholdOverstyringDto medBekreftetPermisjon(LocalDate fom, LocalDate tom, BekreftetPermisjonStatus status) {
        if (fom == null && tom==null) {
            return this;
        } else {
            return medBekreftetPermisjon(new BekreftetPermisjon(new Periode(fom, tom), status));
        }
    }

    public Optional<BekreftetPermisjon> getBekreftetPermisjon() {
        return Optional.ofNullable(bekreftetPermisjon);
    }

}
