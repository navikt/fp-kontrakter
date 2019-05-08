package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ArbeidskategoriDto extends Kodeverk {
    @JsonProperty(value = "kode", required = true, index = 1)
    
    

    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    private String kode;
    static final String KODEVERK = "ARBEIDSKATEGORI";

    public ArbeidskategoriDto(String kode) {
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
