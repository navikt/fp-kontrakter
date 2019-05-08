package no.nav.historikk;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import no.nav.historikk.v1.HistorikkInnslagV1;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "version")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HistorikkInnslagV1.class, name = "1.0"),
})
public abstract class HistorikkInnslag {

}
