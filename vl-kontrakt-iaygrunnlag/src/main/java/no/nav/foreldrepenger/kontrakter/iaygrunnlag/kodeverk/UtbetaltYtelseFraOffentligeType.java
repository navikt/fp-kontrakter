package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UtbetaltYtelseFraOffentligeType extends Kodeverk implements UtbetaltYtelseType {
    public static final String KODEVERK = "YTELSE_FRA_OFFENTLIGE";

    /**
     * eksempel verdi
     */
    public static final UtbetaltYtelseFraOffentligeType FORELDREPENGER = new UtbetaltYtelseFraOffentligeType("FORELDREPENGER");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @Size(min = 3, max = 50)
    @NotNull
    private String kode;

    @JsonCreator
    public UtbetaltYtelseFraOffentligeType(@JsonProperty(value = "kode", required = true) String kode) {
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
