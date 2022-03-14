package no.nav.foreldrepenger.fpformidling.beregningsgrunnlag.v2.kodeverk;

import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.ANY)
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
    VENTELØNN_VARTPENGER
    ;

}
