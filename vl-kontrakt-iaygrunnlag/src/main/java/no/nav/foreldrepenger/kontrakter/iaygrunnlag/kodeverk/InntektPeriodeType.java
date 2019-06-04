package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InntektPeriodeType extends Kodeverk {

    static final String KODEVERK = "INNTEKT_PERIODE_TYPE";

    public static final InntektPeriodeType PER_ÅR = new InntektPeriodeType("AARLG");
    public static final InntektPeriodeType PER_DAG = new InntektPeriodeType("DAGLG");
    public static final InntektPeriodeType PER_MÅNED = new InntektPeriodeType("MNDLG");
    public static final InntektPeriodeType PER_UKE = new InntektPeriodeType("UKNLG");
    public static final InntektPeriodeType PER_14DAGER = new InntektPeriodeType("14DLG");
    public static final InntektPeriodeType PREMIEGRUNNLAG_OPPDRAGSGIVER = new InntektPeriodeType("PREMGR");
    public static final InntektPeriodeType FASTSATT_ETTER_AVVIKHÅNDTERING = new InntektPeriodeType("INNFS");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @Size(min=4, max=10)
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
