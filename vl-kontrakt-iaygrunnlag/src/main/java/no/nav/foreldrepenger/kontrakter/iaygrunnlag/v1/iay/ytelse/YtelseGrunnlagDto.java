package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidskategoriDto;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class YtelseGrunnlagDto {

    @JsonProperty(value="arbeidskategori")
    @Valid
    private ArbeidskategoriDto arbeidskategoriDto;
    
    @JsonProperty(value="opprinneligIdentDato")
    @Valid
    private LocalDate opprinneligIdentDato;
    
    @JsonProperty(value="dekningsgradProsent")
    @DecimalMin(value="0.00", message = "må være >= 0.00")
    @DecimalMax(value="500.00", message="må være < 500.00") // TODO: mer sane verdier
    private BigDecimal dekningsgradProsent;
    
    @JsonProperty(value="graderingProsent")
    @DecimalMin(value="0.00", message = "må være >= 0.00")
    @DecimalMax(value="500.00", message="må være < 500.00") // TODO: mer sane verdier
    private BigDecimal graderingProsent;
    
    @JsonProperty(value="inntektsgrunnlagProsent")
    @DecimalMin(value="0.00", message = "må være >= 0.00")
    @DecimalMax(value="500.00", message="må være < 500.00") // TODO: mer sane verdier
    private BigDecimal inntektsgrunnlagProsent;
    
    @JsonProperty(value="fordeling")
    @Valid
    private List<FordelingDto> fordeling;

    public YtelseGrunnlagDto() {
    }

    public ArbeidskategoriDto getArbeidskategoriDto() {
        return arbeidskategoriDto;
    }

    public void setArbeidskategoriDto(ArbeidskategoriDto arbeidskategoriDto) {
        this.arbeidskategoriDto = arbeidskategoriDto;
    }

    public LocalDate getOpprinneligIdentDato() {
        return opprinneligIdentDato;
    }

    public void setOpprinneligIdentDato(LocalDate opprinneligIdentDato) {
        this.opprinneligIdentDato = opprinneligIdentDato;
    }

    public BigDecimal getDekningsgradProsent() {
        return dekningsgradProsent;
    }

    public void setDekningsgradProsent(BigDecimal dekningsgradProsent) {
        this.dekningsgradProsent = dekningsgradProsent;
    }

    public BigDecimal getGraderingProsent() {
        return graderingProsent;
    }

    public void setGraderingProsent(BigDecimal graderingProsent) {
        this.graderingProsent = graderingProsent;
    }

    public BigDecimal getInntektsgrunnlagProsent() {
        return inntektsgrunnlagProsent;
    }

    public void setInntektsgrunnlagProsent(BigDecimal inntektsgrunnlagProsent) {
        this.inntektsgrunnlagProsent = inntektsgrunnlagProsent;
    }

    public List<FordelingDto> getFordeling() {
        return fordeling;
    }

    public void setFordeling(List<FordelingDto> fordeling) {
        this.fordeling = fordeling;
    }
}
