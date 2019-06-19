package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PermisjonsbeskrivelseType extends Kodeverk {

    static final String KODEVERK = "PERMISJONSBESKRIVELSE_TYPE";

    /** Eksempel konstant, PERMISJON */
    public static final PermisjonsbeskrivelseType PERMISJON = new PermisjonsbeskrivelseType("PERMISJON");
    /** Eksempel konstant, PERMITTERING */
    public static final PermisjonsbeskrivelseType PERMITTERING = new PermisjonsbeskrivelseType("PERMITTERING");
    /** Eksempel konstant, VANLIG */
    public static final PermisjonsbeskrivelseType VANLIG = new PermisjonsbeskrivelseType("VANLIG");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$", message="Kode PermisjonsbeskrivelseType '${validatedValue}' matcher ikke tillatt pattern")
    @NotNull
    private String kode;

    @JsonCreator
    public PermisjonsbeskrivelseType(@JsonProperty(value = "kode", required = true) String kode) {
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
