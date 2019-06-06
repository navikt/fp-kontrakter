package no.nav.vedtak.kontroll.v1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.nav.vedtak.kontroll.KontrollResultat;
import no.nav.vedtak.kontroll.kodeverk.KontrollResultatkode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_ABSENT, content = JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class KontrollResultatV1 extends KontrollResultat {

    @NotNull
    @Valid
    @JsonProperty(value = "behandlingUuid", required = true)
    private UUID behandlingUuid;

    @NotNull
    @Valid
    @JsonProperty(value = "kontrollResultatkode", required = true)
    private KontrollResultatkode kontrollResultatkode;

    public UUID getBehandlingUuid() {
        return behandlingUuid;
    }

    public KontrollResultatkode getKontrollResultatkode() {
        return kontrollResultatkode;
    }

    public static class Builder {
        private KontrollResultatV1 kontrollResultat;

        public Builder() {
            kontrollResultat = new KontrollResultatV1();
        }

        public Builder medBehandlingUuid(UUID behandlingUuid) {
            kontrollResultat.behandlingUuid = behandlingUuid;
            return this;
        }

        public Builder medResultatkode(KontrollResultatkode kontrollResultatkode) {
            kontrollResultat.kontrollResultatkode = kontrollResultatkode;
            return this;
        }

        public KontrollResultatV1 build() {
            return kontrollResultat;
        }
    }

}
