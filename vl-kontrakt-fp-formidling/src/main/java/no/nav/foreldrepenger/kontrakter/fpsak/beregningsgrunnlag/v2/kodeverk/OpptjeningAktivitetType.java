package no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum OpptjeningAktivitetType {

    ARBEIDSAVKLARING,
    ARBEID,
    DAGPENGER,
    FORELDREPENGER,
    FRILANS,
    MILITÆR_ELLER_SIVILTJENESTE,
    NÆRING,
    OMSORGSPENGER,
    OPPLÆRINGSPENGER,
    PLEIEPENGER,
    FRISINN,
    ETTERLØNN_SLUTTPAKKE,
    SVANGERSKAPSPENGER,
    SYKEPENGER,
    VENTELØNN_VARTPENGER,
    VIDERE_ETTERUTDANNING,
    UTENLANDSK_ARBEIDSFORHOLD,
    UTDANNINGSPERMISJON,
    ;
}
