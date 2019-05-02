package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.arbeidsforhold;

import java.math.BigDecimal;
import java.util.List;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidsforholdHandlingTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;

public class ArbeidsforholdOverstyringDto {
    private ArbeidsgiverDto arbeidsgiver;
    private ArbeidsforholdRefDto arbeidsforholdRef;
    private ArbeidsforholdRefDto nyArbeidsforholdRef;
    private ArbeidsforholdHandlingTypeDto handling;
    private String begrunnelse;
    private String navn;
    private BigDecimal stillingsprosent;
    private List<ArbeidsforholdOverstyrtePerioderDto> arbeidsforholdOverstyrtePerioder;

    public ArbeidsforholdOverstyringDto() {
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

    public ArbeidsforholdRefDto getNyArbeidsforholdRef() {
        return nyArbeidsforholdRef;
    }

    public void setNyArbeidsforholdRef(ArbeidsforholdRefDto nyArbeidsforholdRef) {
        this.nyArbeidsforholdRef = nyArbeidsforholdRef;
    }

    public ArbeidsforholdHandlingTypeDto getHandling() {
        return handling;
    }

    public void setHandling(ArbeidsforholdHandlingTypeDto handling) {
        this.handling = handling;
    }

    public String getBegrunnelse() {
        return begrunnelse;
    }

    public void setBegrunnelse(String begrunnelse) {
        this.begrunnelse = begrunnelse;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public BigDecimal getStillingsprosent() {
        return stillingsprosent;
    }

    public void setStillingsprosent(BigDecimal stillingsprosent) {
        this.stillingsprosent = stillingsprosent;
    }

    public List<ArbeidsforholdOverstyrtePerioderDto> getArbeidsforholdOverstyrtePerioder() {
        return arbeidsforholdOverstyrtePerioder;
    }

    public void setArbeidsforholdOverstyrtePerioder(List<ArbeidsforholdOverstyrtePerioderDto> arbeidsforholdOverstyrtePerioder) {
        this.arbeidsforholdOverstyrtePerioder = arbeidsforholdOverstyrtePerioder;
    }
}
