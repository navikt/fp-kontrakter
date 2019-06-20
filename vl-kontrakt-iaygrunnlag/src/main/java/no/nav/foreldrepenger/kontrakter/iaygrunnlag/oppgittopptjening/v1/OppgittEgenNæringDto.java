package no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
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

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Organisasjon;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.Landkode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.VirksomhetType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class OppgittEgenNæringDto {

    @JsonProperty(value = "periode", required = true)
    @Valid
    @NotNull
    private Periode periode;

    @JsonProperty(value = "virksomhet")
    @Valid
    private Organisasjon virksomhet;

    @JsonProperty(value = "virksomhetType")
    @Valid
    private VirksomhetType virksomhetTypeDto;

    @JsonProperty(value = "regnskapsførerNavn")
    @Pattern(regexp = "^[\\p{L}\\p{N}\\.\\-()/$=\\?%#&\\\\,\\+:/;\\[\\]@\\s]+$", message="Oppgitt Egen Næring - Regnskapsfører navn '${validatedValue}' matcher ikke tillatt pattern '{regexp}'")
    private String regnskapsførerNavn;

    @JsonProperty(value = "regnskapsførerTlf")
    @Pattern(regexp = "^[\\+\\p{L}\\p{N}\\.\\-()/#&\\\\,:/;\\[\\]@\\s]+$", message="Regnskapsfører telefon '${validatedValue}' matcher ikke oppgitt pattern '{regexp}'") // har caser som har sluppet gjennom selvbetjening med alfa
    private String regnskapsførerTlf;

    /** Oppgis normalt dersom ikke orgnr kan gis. F.eks for utlandske virsomheter, eller noen tilfeller Fiskere med Lott. */
    @JsonProperty(value = "virksomhetNavn", required = false)
    @Pattern(regexp = "^[\\p{L}\\p{N}\\.\\-()/$=\\?%#&\\\\,\\+:/;\\[\\]@\\s]+$", message="Oppgitt Egen Næring - Virksomhet navn '${validatedValue}' matcher ikke tillatt pattern '{regexp}'")
    private String virksomhetNavn;
    
    @JsonProperty(value = "landkode", required = true)
    @Valid
    @NotNull
    private Landkode landkode = Landkode.NORGE;

    @JsonProperty(value = "endringDato")
    private LocalDate endringDato;

    @JsonProperty(value = "erVarigEndring")
    private Boolean erVarigEndring;

    @JsonProperty(value = "endringBegrunnelse")
    private String endringBegrunnelse;

    /** Tillater kun positive verdier.  Max verdi håndteres av mottager. */
    @JsonProperty("bruttoInntekt")
    @DecimalMin(value = "0.00", message = "beløp må være >= 0.00")
    private BigDecimal bruttoInntekt;

    @JsonProperty(value = "erNyoppstartet")
    private Boolean nyoppstartet;

    @JsonProperty(value = "erNærRelasjon")
    private Boolean nærRelasjon;

    @JsonProperty(value = "erNyIArbeidslivet")
    private Boolean nyIArbeidslivet;

    protected OppgittEgenNæringDto() {
    }

    public OppgittEgenNæringDto(Periode periode) {
        Objects.requireNonNull(periode, "periode");
        this.periode = periode;
    }

    public Periode getPeriode() {
        return periode;
    }

    public Organisasjon getVirksomhet() {
        return virksomhet;
    }

    public void setVirksomhet(Organisasjon virksomhet) {
        this.virksomhet = virksomhet;
    }

    public OppgittEgenNæringDto medVirksomhet(Organisasjon virksomhet) {
        setVirksomhet(virksomhet);
        return this;
    }

    public VirksomhetType getVirksomhetTypeDto() {
        return virksomhetTypeDto;
    }

    public void setVirksomhetTypeDto(VirksomhetType virksomhetTypeDto) {
        this.virksomhetTypeDto = virksomhetTypeDto;
    }

    public OppgittEgenNæringDto medVirksomhetType(VirksomhetType virksomhetType) {
        setVirksomhetTypeDto(virksomhetType);
        return this;
    }

    public OppgittEgenNæringDto medVirksomhetType(String virksomhetType) {
        if (virksomhetType != null) {
            setVirksomhetTypeDto(new VirksomhetType(virksomhetType));
        }
        return this;
    }

    public String getRegnskapsførerNavn() {
        return regnskapsførerNavn;
    }

    public void setRegnskapsførerNavn(String regnskapsførerNavn) {
        this.regnskapsførerNavn = regnskapsførerNavn;
    }

    public OppgittEgenNæringDto medRegnskapsførerNavn(String regnskapsførerNavn) {
        setRegnskapsførerNavn(regnskapsførerNavn);
        return this;
    }

    public String getRegnskapsførerTlf() {
        return regnskapsførerTlf;
    }

    public void setRegnskapsførerTlf(String regnskapsførerTlf) {
        this.regnskapsførerTlf = regnskapsførerTlf;
    }

    public OppgittEgenNæringDto medRegnskapsførerTlf(String regnskapsførerTlf) {
        setRegnskapsførerTlf(regnskapsførerTlf);
        return this;
    }

    public LocalDate getEndringDato() {
        return endringDato;
    }

    public void setEndringDato(LocalDate endringDato) {
        this.endringDato = endringDato;
    }

    public OppgittEgenNæringDto medEndringDato(LocalDate endringDato) {
        setEndringDato(endringDato);
        return this;
    }

    public String getBegrunnelse() {
        return endringBegrunnelse;
    }

    public void setBegrunnelse(String begrunnelse) {
        this.endringBegrunnelse = begrunnelse;
    }

    public OppgittEgenNæringDto medBegrunnelse(String begrunnelse) {
        setBegrunnelse(begrunnelse);
        return this;
    }

    public BigDecimal getBruttoInntekt() {
        return bruttoInntekt;
    }

    public void setBruttoInntekt(BigDecimal bruttoInntekt) {
        this.bruttoInntekt = bruttoInntekt == null ? null : bruttoInntekt.setScale(2, RoundingMode.HALF_UP);
    }

    public OppgittEgenNæringDto medBruttoInntekt(BigDecimal bruttoInntekt) {
        setBruttoInntekt(bruttoInntekt);
        return this;
    }

    public OppgittEgenNæringDto medBruttoInntekt(int bruttoInntekt) {
        setBruttoInntekt(BigDecimal.valueOf(bruttoInntekt));
        return this;
    }

    public Boolean isNyoppstartet() {
        return nyoppstartet;
    }

    public void setNyoppstartet(boolean nyoppstartet) {
        this.nyoppstartet = nyoppstartet;
    }

    public OppgittEgenNæringDto medNyoppstartet(boolean nyoppstartet) {
        setNyoppstartet(nyoppstartet);
        return this;
    }

    public Boolean isVarigEndring() {
        return erVarigEndring;
    }

    public void setVarigEndring(boolean varigEndring) {
        this.erVarigEndring = varigEndring;
    }

    public OppgittEgenNæringDto medVarigEndring(boolean varigEndring) {
        setVarigEndring(varigEndring);
        return this;
    }

    public Boolean isNærRelasjon() {
        return nærRelasjon;
    }

    public void setNærRelasjon(boolean nærRelasjon) {
        this.nærRelasjon = nærRelasjon;
    }

    public OppgittEgenNæringDto medNærRelasjon(boolean nærRelasjon) {
        setNærRelasjon(nærRelasjon);
        return this;
    }

    public Boolean isNyIArbeidslivet() {
        return nyIArbeidslivet;
    }

    public void setNyIArbeidslivet(boolean nyIArbeidslivet) {
        this.nyIArbeidslivet = nyIArbeidslivet;
    }

    public OppgittEgenNæringDto medNyIArbeidslivet(boolean nyIArbeidslivet) {
        setNyIArbeidslivet(nyIArbeidslivet);
        return this;
    }

    public Landkode getLandkode() {
        return landkode;
    }

    public void setLandkode(Landkode landkode) {
        this.landkode = landkode;
    }

    public String getVirksomhetNavn() {
        return virksomhetNavn;
    }

    public void setVirksomhetNavn(String virksomhetNavn) {
        this.virksomhetNavn = virksomhetNavn;
    }
    
    public OppgittEgenNæringDto medOppgittVirksomhetNavn(String virksomhetNavn, Landkode landkode) {
        setLandkode(landkode);
        setVirksomhetNavn(virksomhetNavn);
        return this;
    }

}
