package no.nav.foreldrepenger.fpformidling.beregningsgrunnlag.v2.kodeverk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PeriodeÅrsak {

    NATURALYTELSE_BORTFALT,
    ARBEIDSFORHOLD_AVSLUTTET,
    NATURALYTELSE_TILKOMMER,
    ENDRING_I_REFUSJONSKRAV,
    REFUSJON_OPPHØRER,
    GRADERING,
    GRADERING_OPPHØRER,
    ENDRING_I_AKTIVITETER_SØKT_FOR,
    REFUSJON_AVSLÅTT,
    ;

}
