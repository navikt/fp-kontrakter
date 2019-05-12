package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InntektPeriodeType extends Kodeverk {

    static final String KODEVERK = "INNTEKT_PERIODE_TYPE";

    public static final InntektPeriodeType PER_ÅR = new InntektPeriodeType("Å");
    public static final InntektPeriodeType PER_DAG = new InntektPeriodeType("D");
    public static final InntektPeriodeType PER_MÅNED = new InntektPeriodeType("M");
    public static final InntektPeriodeType PER_UKE = new InntektPeriodeType("U");
    public static final InntektPeriodeType PER_14DAGER = new InntektPeriodeType("F");
    public static final InntektPeriodeType PREMIEGRUNNLAG_OPPDRAGSGIVER = new InntektPeriodeType("Y");
    public static final InntektPeriodeType FASTSATT_ETTER_AVVIKHÅNDTERING = new InntektPeriodeType("X");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public InntektPeriodeType(@JsonProperty(value = "kode", required = true) String kode) {
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
