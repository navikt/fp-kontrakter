package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.VirksomhetTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.Organisasjon;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.NON_EMPTY)
public class OppgittEgenNæringDto {
    
    @JsonProperty(value = "periode", required=true)
    @Valid
    @NotNull
    private PeriodeDto periode;
    
    @JsonProperty(value = "virksomhet")
    @Valid
    private Organisasjon virksomhet;
    
    @JsonProperty(value = "virksomhetType")
    @Valid
    private VirksomhetTypeDto virksomhetTypeDto;
    
    @JsonProperty(value="regnskapsførerNavn")
    @Pattern(regexp = "^[\\p{L}\\p{N}.- ]+$")
    private String regnskapsførerNavn;
    
    @JsonProperty(value="regnskapsførerTlf")
    private String regnskapsførerTlf;
    
    @JsonProperty(value="endringDato")
    private LocalDate endringDato;
    
    @JsonProperty(value="erVarigEndring")
    private boolean erVarigEndring;
    
    @JsonProperty(value="endringBegrunnelse")
    @Pattern(regexp = "^[\\p{L}\\p{N}_.- \\n\\t\\r]+$")
    private String endringBegrunnelse;
    
    @JsonProperty(value = "utenlandskVirksomhet")
    @Valid
    private OppgittUtenlandskVirksomhetDto oppgittUtenlandskVirksomhet;
    
    @JsonProperty("bruttoInntekt")
    @DecimalMin(value="0.00", message = "beløp må være >= 0.00")
    @DecimalMax(value="100000000.00", message="beløp må være < 100000000.00")  // TODO: sane verdier
    private BigDecimal bruttoInntekt;
    
    @JsonProperty(value="erNyoppstartet")
    private boolean nyoppstartet;
    
    @JsonProperty(value="erNærRelasjon")
    private boolean nærRelasjon;
    
    @JsonProperty(value="erNyIArbeidslivet")
    private boolean nyIArbeidslivet;
    
    protected OppgittEgenNæringDto() {
    }

    public OppgittEgenNæringDto(PeriodeDto periode) {
        this.periode = periode;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public Organisasjon getVirksomhet() {
        return virksomhet;
    }

    public void setVirksomhet(Organisasjon virksomhet) {
        this.virksomhet = virksomhet;
    }

    public VirksomhetTypeDto getVirksomhetTypeDto() {
        return virksomhetTypeDto;
    }

    public void setVirksomhetTypeDto(VirksomhetTypeDto virksomhetTypeDto) {
        this.virksomhetTypeDto = virksomhetTypeDto;
    }

    public String getRegnskapsførerNavn() {
        return regnskapsførerNavn;
    }

    public void setRegnskapsførerNavn(String regnskapsførerNavn) {
        this.regnskapsførerNavn = regnskapsførerNavn;
    }

    public String getRegnskapsførerTlf() {
        return regnskapsførerTlf;
    }

    public void setRegnskapsførerTlf(String regnskapsførerTlf) {
        this.regnskapsførerTlf = regnskapsførerTlf;
    }

    public LocalDate getEndringDato() {
        return endringDato;
    }

    public void setEndringDato(LocalDate endringDato) {
        this.endringDato = endringDato;
    }

    public String getBegrunnelse() {
        return endringBegrunnelse;
    }

    public void setBegrunnelse(String begrunnelse) {
        this.endringBegrunnelse = begrunnelse;
    }

    public BigDecimal getBruttoInntekt() {
        return bruttoInntekt;
    }

    public void setBruttoInntekt(BigDecimal bruttoInntekt) {
        this.bruttoInntekt = bruttoInntekt;
    }

    public boolean isNyoppstartet() {
        return nyoppstartet;
    }

    public void setNyoppstartet(boolean nyoppstartet) {
        this.nyoppstartet = nyoppstartet;
    }

    public boolean isVarigEndring() {
        return erVarigEndring;
    }

    public void setVarigEndring(boolean varigEndring) {
        this.erVarigEndring = varigEndring;
    }

    public boolean isNærRelasjon() {
        return nærRelasjon;
    }

    public void setNærRelasjon(boolean nærRelasjon) {
        this.nærRelasjon = nærRelasjon;
    }

    public boolean isNyIArbeidslivet() {
        return nyIArbeidslivet;
    }

    public void setNyIArbeidslivet(boolean nyIArbeidslivet) {
        this.nyIArbeidslivet = nyIArbeidslivet;
    }

    public OppgittUtenlandskVirksomhetDto getOppgittUtenlandskVirksomhet() {
        return oppgittUtenlandskVirksomhet;
    }

    public void setOppgittUtenlandskVirksomhet(OppgittUtenlandskVirksomhetDto oppgittUtenlandskVirksomhet) {
        this.oppgittUtenlandskVirksomhet = oppgittUtenlandskVirksomhet;
    }
}
