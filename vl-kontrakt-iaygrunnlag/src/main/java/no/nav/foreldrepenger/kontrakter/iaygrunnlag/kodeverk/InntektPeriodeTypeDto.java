package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;


public class InntektPeriodeTypeDto extends Kodeverk {
    
    static final String KODEVERK = "INNTEKT_PERIODE_TYPE";
    
    @JsonProperty(value = "kode", required = true, index = 1)
    
    
    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    private String kode;

    public InntektPeriodeTypeDto(String kode) {
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
