package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(UtsettelseÅrsakType.KODEVERK)
public class UtsettelseÅrsakType extends Kodeverk {

    static final String KODEVERK = "UTSETTELSE_AARSAK_TYPE";
    
    public static final UtsettelseÅrsakType ARBEID = new UtsettelseÅrsakType("ARBEID");
    public static final UtsettelseÅrsakType SYKDOM = new UtsettelseÅrsakType("SYKDOM");
    public static final UtsettelseÅrsakType LOVBESTEMT_FERIE = new UtsettelseÅrsakType("LOVBESTEMT_FERIE");
    
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$", message="Kode '${validatedValue}' matcher ikke tillatt pattern '{regexp}'")
    @Size(min = 5, max = 50)
    @NotNull
    private String kode;

    @JsonCreator
    public UtsettelseÅrsakType(@JsonProperty(value = "kode", required = true) String kode) {
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
