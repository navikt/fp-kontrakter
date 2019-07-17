package no.nav.foreldrepenger.kontrakter.iaygrunnlag.ytelse.v1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.Arbeidskategori;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class YtelseGrunnlagDto {

    @JsonProperty(value = "arbeidskategori")
    @Valid
    private Arbeidskategori arbeidskategoriDto;

    @JsonProperty(value = "opprinneligIdentDato")
    @Valid
    private LocalDate opprinneligIdentDato;

    @JsonProperty(value = "dekningsgradProsent")
    @Valid
    @DecimalMin(value = "0.00", message = "dekningsgradprosent ${validatedValue} må være >= {value}")
    @DecimalMax(value = "100.00", message = "dekningsgradprosent ${validatedValue} må være <= {value}")
    private BigDecimal dekningsgradProsent;

    @JsonProperty(value = "graderingProsent")
    @Valid
    @DecimalMin(value = "0.00", message = "graderingprosent ${validatedValue} må være >= {value}")
    @DecimalMax(value = "100.00", message = "graderingprosent ${validatedValue} må være <= {value}")
    private BigDecimal graderingProsent;

    @JsonProperty(value = "inntektsgrunnlagProsent")
    @Valid
    @DecimalMin(value = "0.00", message = "inntektsgrunnlagProsent ${validatedValue} må være >= {value}")
    @DecimalMax(value = "100.00", message = "inntektsgrunnlagProsent ${validatedValue} må være <= {value}") 
    private BigDecimal inntektsgrunnlagProsent;

    @JsonProperty(value = "fordeling")
    @Valid
    private List<FordelingDto> fordeling;

    /** Beløp i hele kroner (currency major unit). Tillater kun positive verdier.  Max verdi håndteres av mottager. */
    @JsonProperty(value = "dagsats")
    @Valid
    @DecimalMin(value = "0.00", message = "vedtaksDagsats må være >= 0.00")
    private BigDecimal vedtaksDagsats;

    public YtelseGrunnlagDto() {
    }

    public Arbeidskategori getArbeidskategoriDto() {
        return arbeidskategoriDto;
    }

    public void setArbeidskategoriDto(Arbeidskategori arbeidskategoriDto) {
        this.arbeidskategoriDto = arbeidskategoriDto;
    }

    public YtelseGrunnlagDto medArbeidskategoriDto(Arbeidskategori arbeidskategoriDto) {
        setArbeidskategoriDto(arbeidskategoriDto);
        return this;
    }

    public LocalDate getOpprinneligIdentDato() {
        return opprinneligIdentDato;
    }

    public void setOpprinneligIdentDato(LocalDate opprinneligIdentDato) {
        this.opprinneligIdentDato = opprinneligIdentDato;
    }

    public YtelseGrunnlagDto medOpprinneligIdentDato(LocalDate opprinneligIdentDato) {
        setOpprinneligIdentDato(opprinneligIdentDato);
        return this;
    }

    public BigDecimal getDekningsgradProsent() {
        return dekningsgradProsent;
    }

    public void setDekningsgradProsent(BigDecimal dekningsgradProsent) {
        this.dekningsgradProsent = dekningsgradProsent == null ? null : dekningsgradProsent.setScale(2, RoundingMode.HALF_UP);
    }

    public YtelseGrunnlagDto medDekningsgradProsent(BigDecimal dekningsgradProsent) {
        setDekningsgradProsent(dekningsgradProsent);
        return this;
    }

    public YtelseGrunnlagDto medDekningsgradProsent(int dekningsgradProsent) {
        setDekningsgradProsent(BigDecimal.valueOf(dekningsgradProsent));
        return this;
    }

    public BigDecimal getGraderingProsent() {
        return graderingProsent;
    }

    public void setGraderingProsent(BigDecimal graderingProsent) {
        this.graderingProsent = graderingProsent == null ? null : graderingProsent.setScale(2, RoundingMode.HALF_UP);
    }

    public YtelseGrunnlagDto medGraderingProsent(BigDecimal graderingProsent) {
        setGraderingProsent(graderingProsent);
        return this;
    }

    public YtelseGrunnlagDto medGraderingProsent(int graderingProsent) {
        setGraderingProsent(BigDecimal.valueOf(graderingProsent));
        return this;
    }

    public BigDecimal getInntektsgrunnlagProsent() {
        return inntektsgrunnlagProsent;
    }

    public void setInntektsgrunnlagProsent(BigDecimal inntektsgrunnlagProsent) {
        this.inntektsgrunnlagProsent = inntektsgrunnlagProsent == null ? null : inntektsgrunnlagProsent.setScale(2, RoundingMode.HALF_UP);
    }

    public YtelseGrunnlagDto medInntektsgrunnlagProsent(BigDecimal inntektsgrunnlagProsent) {
        setInntektsgrunnlagProsent(inntektsgrunnlagProsent);
        return this;
    }

    public YtelseGrunnlagDto medInntektsgrunnlagProsent(int inntektsgrunnlagProsent) {
        setInntektsgrunnlagProsent(BigDecimal.valueOf(inntektsgrunnlagProsent));
        return this;
    }

    public List<FordelingDto> getFordeling() {
        return fordeling;
    }

    public void setFordeling(List<FordelingDto> fordeling) {
        this.fordeling = fordeling;
    }

    public YtelseGrunnlagDto medFordeling(List<FordelingDto> fordeling) {
        setFordeling(fordeling);
        return this;
    }

    public BigDecimal getVedtaksDagsats() { return vedtaksDagsats; }

    public void setVedtaksDagsats(BigDecimal vedtaksDagsats) {
        this.vedtaksDagsats = vedtaksDagsats == null ? null : vedtaksDagsats.setScale(2, RoundingMode.HALF_UP);
    }

    public YtelseGrunnlagDto medVedtaksDagsats(BigDecimal vedtaksDagsats) {
        setVedtaksDagsats(vedtaksDagsats);
        return this;
    }

    public YtelseGrunnlagDto medVedtaksDagsats(int vedtaksDagsats) {
        setVedtaksDagsats(BigDecimal.valueOf(vedtaksDagsats));
        return this;
    }
}
