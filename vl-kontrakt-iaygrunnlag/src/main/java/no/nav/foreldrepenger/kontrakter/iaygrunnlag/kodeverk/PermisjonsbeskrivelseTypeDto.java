package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PermisjonsbeskrivelseTypeDto extends Kodeverk {

    static final String KODEVERK = "PERMISJONSBESKRIVELSE_TYPE";

    /** Eksempel konstant, PERMISJON */
    public static final PermisjonsbeskrivelseTypeDto PERMISJON = new PermisjonsbeskrivelseTypeDto("PERMISJON");
    /** Eksempel konstant, PERMITTERING */
    public static final PermisjonsbeskrivelseTypeDto PERMITTERING = new PermisjonsbeskrivelseTypeDto("PERMITTERING");
    /** Eksempel konstant, VANLIG */
    public static final PermisjonsbeskrivelseTypeDto VANLIG = new PermisjonsbeskrivelseTypeDto("VANLIG");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public PermisjonsbeskrivelseTypeDto(@JsonProperty(value = "kode", required = true) String kode) {
        Objects.requireNonNull(kode, "kode");
        this.kode = kode;
    }

    @Override
    public String getKode() {
        return kode;
    }

    @Override
    public String getKodeverk() {
        return KODEVERK;
    }
}
