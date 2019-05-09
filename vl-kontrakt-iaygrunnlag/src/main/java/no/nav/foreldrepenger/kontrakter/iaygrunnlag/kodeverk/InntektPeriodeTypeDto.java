package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InntektPeriodeTypeDto extends Kodeverk {

    static final String KODEVERK = "INNTEKT_PERIODE_TYPE";

    public static final InntektPeriodeTypeDto PER_ÅR = new InntektPeriodeTypeDto("Å");
    public static final InntektPeriodeTypeDto PER_DAG = new InntektPeriodeTypeDto("D");
    public static final InntektPeriodeTypeDto PER_MÅNED = new InntektPeriodeTypeDto("M");
    public static final InntektPeriodeTypeDto PER_UKE = new InntektPeriodeTypeDto("U");
    public static final InntektPeriodeTypeDto PER_14DAGER = new InntektPeriodeTypeDto("F");
    public static final InntektPeriodeTypeDto PREMIEGRUNNLAG_OPPDRAGSGIVER = new InntektPeriodeTypeDto("Y");
    public static final InntektPeriodeTypeDto FASTSATT_ETTER_AVVIKHÅNDTERING = new InntektPeriodeTypeDto("X");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public InntektPeriodeTypeDto(@JsonProperty(value = "kode", required = true) String kode) {
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
