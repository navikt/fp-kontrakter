package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;


public class InntektspostTypeDto extends Kodeverk {
    @JsonProperty(value = "kode", required = true, index = 1)
    
    

    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    private String kode;
    static final String KODEVERK = "INNTEKTSPOST_TYPE";

    public InntektspostTypeDto(String kode) {
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
