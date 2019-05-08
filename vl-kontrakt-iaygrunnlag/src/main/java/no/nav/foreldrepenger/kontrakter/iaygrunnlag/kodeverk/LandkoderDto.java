package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;


public class LandkoderDto extends Kodeverk {

    static final String KODEVERK = "LANDKODER";

    /** ISO 3-letter country codes. */
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[A-Z]{3}$")
    private String kode;

    public LandkoderDto(String kode) {
        super();
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
