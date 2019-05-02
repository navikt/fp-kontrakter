package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidskategoriDto;

public class YtelseGrunnlagDto {

    private ArbeidskategoriDto arbeidskategoriDto;
    private LocalDate opprinneligIdentDato;
    private BigDecimal dekningsgradProsent;
    private BigDecimal graderingProsent;
    private BigDecimal inntektsgrunnlagProsent;
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
