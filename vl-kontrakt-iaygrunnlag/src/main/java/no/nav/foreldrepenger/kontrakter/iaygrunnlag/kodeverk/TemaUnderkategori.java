package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class TemaUnderkategori extends Kodeverk {
    static final String KODEVERK = "TEMA_UNDERKATEGORI";

    /** Eksempelkonstanter TemaUnderkategori*/
    public static final TemaUnderkategori FORELDREPENGER_FODSEL = new TemaUnderkategori("FØ");
    public static final TemaUnderkategori FORELDREPENGER_ADOPSJON = new TemaUnderkategori("AP");
    public static final TemaUnderkategori FORELDREPENGER_SVANGERSKAPSPENGER = new TemaUnderkategori("SV");

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$", message="Kode '${validatedValue}' matcher ikke tillatt pattern '{regexp}'")
    @Size(min=2, max=10)
    @NotNull
    private String kode;

    @JsonCreator
    public TemaUnderkategori(@JsonProperty(value = "kode", required = true) String kode) {
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
