package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(UtsettelseÅrsakDto.KODEVERK)
public class UtsettelseÅrsakDto extends Kodeverk {

    static final String KODEVERK = "UTSETTELSE_AARSAK_TYPE";
    
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    @NotNull
    private String kode;

    public UtsettelseÅrsakDto(String kode) {
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
