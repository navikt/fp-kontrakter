package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class OrganisasjonstypeDto extends Kodeverk {
    static final String KODEVERK = "ORGANISASJONSTYPE";

    /** Eksempel kostant - VIRKSOMHET. */
    public static final OrganisasjonstypeDto VIRKSOMHET = new OrganisasjonstypeDto("VIRKSOMHET");
    public static final OrganisasjonstypeDto JURIDISK_ENHET = new OrganisasjonstypeDto("VIRKSJURIDISK_ENHETOMHET");
    public static final OrganisasjonstypeDto KUNSTIG = new OrganisasjonstypeDto("KUNSTIG");
    
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public OrganisasjonstypeDto(@JsonProperty(value = "kode", required = true) String kode) {
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
