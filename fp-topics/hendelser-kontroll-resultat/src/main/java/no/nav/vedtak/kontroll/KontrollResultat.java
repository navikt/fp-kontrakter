package no.nav.vedtak.kontroll;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import no.nav.vedtak.kontroll.v1.KontrollResultatV1;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "version")
@JsonSubTypes({
        @JsonSubTypes.Type(value = KontrollResultatV1.class, name = "1.0"),
})
public abstract class KontrollResultat {

}
