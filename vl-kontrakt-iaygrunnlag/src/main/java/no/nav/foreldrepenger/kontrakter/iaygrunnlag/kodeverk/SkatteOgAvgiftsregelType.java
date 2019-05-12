package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SkatteOgAvgiftsregelType extends Kodeverk {
    static final String KODEVERK = "SKATTE_OG_AVGIFTSREGEL";

    /** EKsempel konstant. Nettolønn. */
    public static final SkatteOgAvgiftsregelType NETTOLØNN = new SkatteOgAvgiftsregelType("NETTOLØNN");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public SkatteOgAvgiftsregelType(@JsonProperty(value = "kode", required = true) String kode) {
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