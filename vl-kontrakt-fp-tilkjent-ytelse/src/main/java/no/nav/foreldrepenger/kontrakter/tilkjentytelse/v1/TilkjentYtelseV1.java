package no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.tilkjentytelse.TilkjentYtelse;

public class TilkjentYtelseV1 implements TilkjentYtelse {
    @Valid
    @NotNull
    private TilkjentYtelseBehandlingInfoV1 behandingsinfo;

    @JsonProperty(value = "erOpphoer")
    private boolean erOpphør;

    @JsonProperty(value = "erOpphoerEtterSkjaeringTidspunkt")
    private Boolean erOpphørEtterSkjæringstidspunkt;

    private LocalDate endringsdato;

    @Valid
    @NotNull
    @Size(max = 100)
    private Collection<TilkjentYtelsePeriodeV1> perioder = new ArrayList<>();

    TilkjentYtelseV1() {
        //for jackson
    }

    public TilkjentYtelseV1(TilkjentYtelseBehandlingInfoV1 behandingsinfo, Collection<TilkjentYtelsePeriodeV1> perioder) {
        this.behandingsinfo = behandingsinfo;
        this.perioder = perioder;
    }

    public TilkjentYtelseBehandlingInfoV1 getBehandingsinfo() {
        return behandingsinfo;
    }

    public Collection<TilkjentYtelsePeriodeV1> getPerioder() {
        return perioder;
    }

    public boolean getErOpphør() {
        return erOpphør;
    }

    public LocalDate getEndringsdato() {
        return endringsdato;
    }

    public Boolean getErOpphørEtterSkjæringstidspunkt() {
        return erOpphørEtterSkjæringstidspunkt;
    }

    public TilkjentYtelseV1 setErOpphør(boolean erOpphør) {
        this.erOpphør = erOpphør;
        return this;
    }

    public TilkjentYtelseV1 setErOpphørEtterSkjæringstidspunkt(Boolean erOpphørEtterSkjæringstidspunkt) {
        this.erOpphørEtterSkjæringstidspunkt = erOpphørEtterSkjæringstidspunkt;
        return this;
    }

    public TilkjentYtelseV1 setEndringsdato(LocalDate endringsdato) {
        this.endringsdato = endringsdato;
        return this;
    }

    public void kryssvalider() throws ParseException {
        for (TilkjentYtelsePeriodeV1 periode : perioder) {
            periode.kryssvalider();
        }
        if (erOpphørEtterSkjæringstidspunkt != null && !erOpphør) {
            throw new ParseException("Ulovlig kombinasjon: er ikke opphør, men er opphør etter skjæringstidspunktet er satt", 0);
        }
    }

    /**
     * @deprecated bytt til FagsakYtelseType kodeverk
     */
    @Deprecated
    public enum YtelseType {
        FORELDREPENGER, SVANGERSKAPSPENGER, ENGANGSTØNAD;
    }

    public enum Inntektskategori {
        ARBEIDSAVKLARINGSPENGER,
        ARBEIDSTAKER,
        ARBEIDSTAKER_UTEN_FERIEPENGER,
        DAGMAMMA,
        DAGPENGER,
        FISKER,
        FRILANSER,
        JORDBRUKER,
        SELVSTENDIG_NÆRINGSDRIVENDE,
        SJØMANN,
        IKKE_RELEVANT //brukes for engangstønad
        ;
    }

    public enum SatsType {
        DAGSATS, ENGANGSUTBETALING;
    }
}
