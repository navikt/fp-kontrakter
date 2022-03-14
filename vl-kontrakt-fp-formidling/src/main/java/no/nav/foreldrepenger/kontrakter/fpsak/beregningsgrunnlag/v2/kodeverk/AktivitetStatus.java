package no.nav.foreldrepenger.kontrakter.fpsak.beregningsgrunnlag.v2.kodeverk;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AktivitetStatus {
    ARBEIDSAVKLARINGSPENGER,
    ARBEIDSTAKER,
    DAGPENGER,
    FRILANSER,
    MILITÆR_ELLER_SIVIL,
    SELVSTENDIG_NÆRINGSDRIVENDE,
    KOMBINERT_AT_FL,
    KOMBINERT_AT_SN,
    KOMBINERT_FL_SN,
    KOMBINERT_AT_FL_SN,
    BRUKERS_ANDEL,
    KUN_YTELSE,
    TTLSTØTENDE_YTELSE,
    VENTELØNN_VARTPENGER;

}
