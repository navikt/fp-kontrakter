package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(UtsettelseÅrsakDto.KODEVERK)
public class UtsettelseÅrsakDto extends Kodeverk {

    static final String KODEVERK = "UTSETTELSE_AARSAK_TYPE";
    
    public static final UtsettelseÅrsakDto ARBEID = new UtsettelseÅrsakDto("ARBEID");
    public static final UtsettelseÅrsakDto SYKDOM = new UtsettelseÅrsakDto("SYKDOM");
    public static final UtsettelseÅrsakDto LOVBESTEMT_FERIE = new UtsettelseÅrsakDto("LOVBESTEMT_FERIE");
    
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    @NotNull
    private String kode;

    @JsonCreator
    public UtsettelseÅrsakDto(@JsonProperty(value = "kode", required = true) String kode) {
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
