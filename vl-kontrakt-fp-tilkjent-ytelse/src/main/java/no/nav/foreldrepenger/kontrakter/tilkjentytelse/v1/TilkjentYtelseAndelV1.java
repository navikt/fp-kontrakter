package no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Year;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1.TilkjentYtelseV1.Inntektskategori;
import no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1.TilkjentYtelseV1.SatsType;

public class TilkjentYtelseAndelV1 {
    private boolean utbetalesTilBruker;

    @Size(min = 9, max = 9)
    @Pattern(regexp = "^\\d*$")
    private String arbeidsgiverOrgNr;

    @Min(0)
    @Max(Long.MAX_VALUE)
    @Digits(integer = 10, fraction = 0)
    private String arbeidsgiverAktørId;

    @Min(0)
    @Max(100)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal utbetalingsgrad;

    @NotNull
    private Inntektskategori inntektskategori;

    @NotNull
    @Min(0)
    @Max(1000000)
    @JsonProperty("satsBeloep")
    private long satsBeløp;

    @NotNull
    private SatsType satsType;

    @Valid
    private TilkjentYtelseFeriepengerV1 feriepenger;

    TilkjentYtelseAndelV1() {
        //for jackson
    }

    private TilkjentYtelseAndelV1(Inntektskategori inntektskategori, long satsBeløp, SatsType satsType) {
        this.inntektskategori = inntektskategori;
        this.satsBeløp = satsBeløp;
        this.satsType = satsType;
    }

    public static TilkjentYtelseAndelV1 tilBruker(Inntektskategori inntektskategori, long beløp, SatsType satsType) {
        TilkjentYtelseAndelV1 andel = new TilkjentYtelseAndelV1(inntektskategori, beløp, satsType);
        andel.utbetalesTilBruker = true;
        return andel;
    }

    public static TilkjentYtelseAndelV1 tilOrgnrArbeidsgiver(Inntektskategori inntektskategori, long beløp, SatsType satsType, String arbeidsgiverOrgNr) {
        TilkjentYtelseAndelV1 andel = new TilkjentYtelseAndelV1(inntektskategori, beløp, satsType);
        andel.arbeidsgiverOrgNr = arbeidsgiverOrgNr;
        return andel;
    }

    public static TilkjentYtelseAndelV1 tilPrivArbeidsgiver(Inntektskategori inntektskategori, long beløp, SatsType satsType, String arbeidsgiverAktørId) {
        TilkjentYtelseAndelV1 andel = new TilkjentYtelseAndelV1(inntektskategori, beløp, satsType);
        andel.arbeidsgiverAktørId = arbeidsgiverAktørId;
        return andel;
    }

    public BigDecimal getUtbetalingsgrad() {
        return utbetalingsgrad;
    }

    public TilkjentYtelseAndelV1 setUtbetalingsgrad(BigDecimal utbetalingsgrad) {
        this.utbetalingsgrad = utbetalingsgrad;
        return this;
    }

    public void kryssvalider() throws ParseException {
        if (utbetalesTilBruker && arbeidsgiverAktørId != null) {
            throw new ParseException("Inkonsistente data, utbetales til bruker kombinert med arbeidsgiverAktørId", 0);
        }
        if (utbetalesTilBruker && arbeidsgiverOrgNr != null) {
            throw new ParseException("Inkonsistente data, utbetales til bruker kombinert med arbeidsgiverOrgNr", 0);
        }
        if (arbeidsgiverAktørId != null && arbeidsgiverOrgNr != null) {
            throw new ParseException("Inkonsistente data, har både arbeidsgiverOrgNr og arbeidsgiverAktørId", 0);
        }
        if (!utbetalesTilBruker && arbeidsgiverOrgNr == null && arbeidsgiverAktørId == null) {
            throw new ParseException("Inkonsistente data, utbetales til arbeidsgiver og ingen arbeidsgiver oppgitt", 0);
        }
    }

    public boolean getUtbetalesTilBruker() {
        return utbetalesTilBruker;
    }

    public String getArbeidsgiverOrgNr() {
        return arbeidsgiverOrgNr;
    }

    public String getArbeidsgiverAktørId() {
        return arbeidsgiverAktørId;
    }

    public Inntektskategori getInntektskategori() {
        return inntektskategori;
    }

    public long getSatsBeløp() {
        return satsBeløp;
    }

    public SatsType getSatsType() {
        return satsType;
    }

    //settere brukes av jackson
    void setUtbetalesTilBruker(boolean utbetalesTilBruker) {
        this.utbetalesTilBruker = utbetalesTilBruker;
    }

    void setArbeidsgiverOrgNr(String arbeidsgiverOrgNr) {
        this.arbeidsgiverOrgNr = arbeidsgiverOrgNr;
    }

    void setArbeidsgiverAktørId(String arbeidsgiverAktørId) {
        this.arbeidsgiverAktørId = arbeidsgiverAktørId;
    }

    void setInntektskategori(Inntektskategori inntektskategori) {
        this.inntektskategori = inntektskategori;
    }

    void setSatsBeløp(long satsBeløp) {
        this.satsBeløp = satsBeløp;
    }

    void setSatsType(SatsType satsType) {
        this.satsType = satsType;
    }

    public TilkjentYtelseAndelV1 medFeriepenger(Year år, long beløp) {
        if (feriepenger != null) {
            throw new IllegalArgumentException("Feriepenger er allerede lagt til");
        }
        feriepenger = new TilkjentYtelseFeriepengerV1(år, beløp);
        return this;
    }

    public Optional<TilkjentYtelseFeriepengerV1> getFeriepenger() {
        return Optional.ofNullable(feriepenger);
    }
}
