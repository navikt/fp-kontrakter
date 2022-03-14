package no.nav.foreldrepenger.fpformidling.beregningsgrunnlag.v2.kodeverk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonValue;

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
