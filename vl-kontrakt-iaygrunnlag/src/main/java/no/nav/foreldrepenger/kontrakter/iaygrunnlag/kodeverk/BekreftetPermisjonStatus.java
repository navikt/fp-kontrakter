package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class BekreftetPermisjonStatus extends Kodeverk {
    static final String KODEVERK = "BEKREFTET_PERMISJON_STATUS";

    /** Eksempelkonstanter BekreftetPermisjonStatus*/
    public static final BekreftetPermisjonStatus BRUK_PERMISJON = new BekreftetPermisjonStatus("BRUK_PERMISJON");
    public static final BekreftetPermisjonStatus IKKE_BRUK_PERMISJON = new BekreftetPermisjonStatus("IKKE_BRUK_PERMISJON");
    public static final BekreftetPermisjonStatus UGYLDIGE_PERIODER = new BekreftetPermisjonStatus("UGYLDIGE_PERIODER");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @Size(min=5, max=20)
    @NotNull
    private String kode;

    @JsonCreator
    public BekreftetPermisjonStatus(@JsonProperty(value = "kode", required = true) String kode) {
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
