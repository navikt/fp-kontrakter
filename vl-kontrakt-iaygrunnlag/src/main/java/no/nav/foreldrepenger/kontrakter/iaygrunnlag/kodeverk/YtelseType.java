package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Definerer ytelse typer brukt i IAY.
 * 
 * <h3>Bruk av konstanter</h3>
 * onstanter representerer definerte eksempler på kjente konstanter. Nye kan - men må ikke - legges her - såfremt
 * avsender/mottager er kjent med de og kan håndtere de.
 */
public class YtelseType extends Kodeverk {
    static final String KODEVERK = "YTELSE_TYPE";

    public static final YtelseType ENGANGSSTØNAD = new YtelseType("ES"); //$NON-NLS-1$
    public static final YtelseType FORELDREPENGER = new YtelseType("FP"); //$NON-NLS-1$
    public static final YtelseType SVANGERSKAPSPENGER = new YtelseType("SVP"); //$NON-NLS-1$
    public static final YtelseType ARBEIDSAVKLARINGSPENGER = new YtelseType("AAP");//$NON-NLS-1$
    public static final YtelseType DAGPENGER = new YtelseType("DAG");//$NON-NLS-1$
    public static final YtelseType SYKEPENGER = new YtelseType("SP");//$NON-NLS-1$
    public static final YtelseType PÅRØRENDESYKDOM = new YtelseType("PS");//$NON-NLS-1$
    public static final YtelseType ENSLIG_FORSØRGER = new YtelseType("EF");//$NON-NLS-1$

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]{2,5}$")
    @Size(min = 2, max = 5)
    @NotNull
    private String kode;

    @JsonCreator
    public YtelseType(@JsonProperty(value = "kode", required = true) String kode) {
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
