package no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeid.v1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

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

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class AktivitetsAvtaleDto {

    @JsonProperty("periode")
    @Valid
    @NotNull
    private Periode periode;

    /**
     * Det går an å ha stillingprosent mer enn 100%, men innsendingsfeil hos LPS leverandører og manglende Altinn validering
     * gjør at i noen historiske tilfeller har man akseptert innsending opp til 500% (typisk skjedd når man har tastet inn ett ukesverks antall
     * timer i dag-felt i de systemene).
     */
    @JsonProperty("stillingsprosent")
    @Valid
    @DecimalMin(value = "0.00", message = "stillingsprosent ${validatedValue} må være >= {value}")
    @DecimalMax(value = "1000.00", message = "stillingsprosent ${validatedValue} må være <= {value}")
    private BigDecimal stillingsprosent;

    /**
     * For timelønnede så vil antallet timer i arbeidsavtalen være satt her.
     * Merk her er registrert mye søppel i Aareg, så brukes først og fremst til kontroll når det er en verdi. Eks.kan være registrert antall
     * timer per år (men skal være per uke)
     */
    @JsonProperty("antallTimer")
    @DecimalMin(value = "0.00", message = "antallTimer ${validatedValue} må være >= {value}")
    @DecimalMax(value = "2000.00", message = "antallTimer ${validatedValue} må være <= {value}")
    private BigDecimal antallTimer;

    /**
     * Antall timer som tilsvarer fulltid (f.eks 40 timer). Merk her er registrert mye søppel ved input fra Aareg. Bruker derfor først og fremst
     * til kontroll når det er satt en verdi.
     * Eks. kan være registrert antall timer full tid per år (når det skal være per uke), eller antall timer per uke totalt (eks. 168 timers
     * arbeidsuker).
     */
    @JsonProperty("antallTimerFulltid")
    @DecimalMin(value = "0.00", message = "antallTimerFulltid ${validatedValue} må være >= {value}")
    @DecimalMax(value = "2000.00", message = "antallTimerFulltid ${validatedValue} må være <= {value}")
    private BigDecimal antallTimerFulltid;

    @JsonProperty("sistLønnsendring")
    @Valid
    private LocalDate sistLønnsendring;

    @JsonProperty("beskrivelse")
    @Pattern(regexp = "^[\\p{L}\\p{M}\\p{N}\\.\\-()/$=\\?%#&\\\\,\\+:/;\\[\\]@\\s\\n\\t\\r|]+$", message="Aktivitetsavtale beskrivelse '${validatedValue}' matcher ikke tillatt pattern '{regexp}'")
    @Valid
    private String beskrivelse;

    protected AktivitetsAvtaleDto() {
    }

    public AktivitetsAvtaleDto(@Valid @NotNull Periode periode) {
        this.periode = periode;
    }

    public AktivitetsAvtaleDto(LocalDate fom, LocalDate tom) {
        this(new Periode(fom, tom));
    }

    public LocalDate getSistLønnsendring() {
        return sistLønnsendring;
    }

    public void setSistLønnsendring(LocalDate sistLønnsendring) {
        this.sistLønnsendring = sistLønnsendring;
    }

    public AktivitetsAvtaleDto medSistLønnsendring(LocalDate sistLønnsendring) {
        setSistLønnsendring(sistLønnsendring);
        return this;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public BigDecimal getStillingsprosent() {
        return stillingsprosent;
    }

    public BigDecimal getAntallTimer() {
        return antallTimer;
    }

    public BigDecimal getAntallTimerFulltid() {
        return antallTimerFulltid;
    }

    public void setAntallTimer(BigDecimal antallTimer) {
        this.antallTimer = antallTimer == null ? null : antallTimer.setScale(2, RoundingMode.HALF_UP);
    }

    public void setAntallTimerFulltid(BigDecimal antallTimerFulltid) {
        this.antallTimerFulltid = antallTimerFulltid == null ? null : antallTimerFulltid.setScale(2, RoundingMode.HALF_UP);
    }

    public void setAntallTimerFulltid(int timer) {
        this.setAntallTimerFulltid(BigDecimal.valueOf(timer));
    }

    public void setAntallTimer(int timer) {
        this.setAntallTimer(BigDecimal.valueOf(timer));
    }

    public void setStillingsprosent(BigDecimal stillingsprosent) {
        this.stillingsprosent = stillingsprosent == null ? null : stillingsprosent.setScale(2, RoundingMode.HALF_UP);
    }

    public AktivitetsAvtaleDto medStillingsprosent(BigDecimal stillingsprosent) {
        setStillingsprosent(stillingsprosent);
        return this;
    }

    public AktivitetsAvtaleDto medStillingsprosent(int prosentHeltall) {
        setStillingsprosent(BigDecimal.valueOf(prosentHeltall));
        return this;
    }

    public AktivitetsAvtaleDto medAntallTimer(BigDecimal timer) {
        setAntallTimer(timer);
        return this;
    }

    public AktivitetsAvtaleDto medAntallTimer(int timer) {
        setAntallTimer(timer);
        return this;
    }

    public AktivitetsAvtaleDto medAntallTimerFulltid(BigDecimal timer) {
        setAntallTimerFulltid(timer);
        return this;
    }

    public AktivitetsAvtaleDto medAntallTimerFulltid(int timer) {
        setAntallTimerFulltid(timer);
        return this;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public AktivitetsAvtaleDto medBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
        return this;
    }
}
