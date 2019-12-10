package no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_ABSENT, content = JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class FagsakYtelseType {

    public static final String DISCRIMINATOR = "YTELSE_TYPE"; //$NON-NLS-1$

    /** Folketrygdloven K4 ytelser. */
    public static final FagsakYtelseType DAGPENGER = new FagsakYtelseType("DAG");//$NON-NLS-1$

    /** Folketrygdloven K8 ytelser. */
    public static final FagsakYtelseType SYKEPENGER = new FagsakYtelseType("SP");//$NON-NLS-1$

    /** Folketrygdloven K9 ytelser. */
    public static final FagsakYtelseType PLEIEPENGER_SYKT_BARN = new FagsakYtelseType("PSB");
    public static final FagsakYtelseType PLEIEPENGER_NÆRSTÅENDE = new FagsakYtelseType("PPN");
    public static final FagsakYtelseType OMSORGSPENGER = new FagsakYtelseType("OMP");
    public static final FagsakYtelseType OPPLÆRINGSPENGER = new FagsakYtelseType("OLP");

    /** Folketrygdloven K11 ytelser. */
    public static final FagsakYtelseType ARBEIDSAVKLARINGSPENGER = new FagsakYtelseType("AAP");//$NON-NLS-1$

    /** Folketrygdloven K14 ytelser. */
    public static final FagsakYtelseType ENGANGSTØNAD = new FagsakYtelseType("ES"); //$NON-NLS-1$
    public static final FagsakYtelseType FORELDREPENGER = new FagsakYtelseType("FP"); //$NON-NLS-1$
    public static final FagsakYtelseType SVANGERSKAPSPENGER = new FagsakYtelseType("SVP"); //$NON-NLS-1$

    /** Folketrygdloven K15 ytelser. */
    public static final FagsakYtelseType ENSLIG_FORSØRGER = new FagsakYtelseType("EF");//$NON-NLS-1$

    @NotNull
    @JsonProperty(required = true)
    private String kodeverk = DISCRIMINATOR;

    @NotNull
    @JsonProperty(required = true)
    private String kode;

    @JsonCreator
    public FagsakYtelseType(@JsonProperty("kode") String kode) {
        this.kode = kode;
    }

}
