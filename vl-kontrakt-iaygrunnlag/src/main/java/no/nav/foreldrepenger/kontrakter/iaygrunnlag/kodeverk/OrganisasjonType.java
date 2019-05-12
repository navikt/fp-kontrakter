package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class OrganisasjonType extends Kodeverk {
    static final String KODEVERK = "ORGANISASJONSTYPE";

    /** Eksempel kostant - VIRKSOMHET. */
    public static final OrganisasjonType VIRKSOMHET = new OrganisasjonType("VIRKSOMHET");
    public static final OrganisasjonType JURIDISK_ENHET = new OrganisasjonType("VIRKSJURIDISK_ENHETOMHET");
    public static final OrganisasjonType KUNSTIG = new OrganisasjonType("KUNSTIG");
    
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public OrganisasjonType(@JsonProperty(value = "kode", required = true) String kode) {
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
