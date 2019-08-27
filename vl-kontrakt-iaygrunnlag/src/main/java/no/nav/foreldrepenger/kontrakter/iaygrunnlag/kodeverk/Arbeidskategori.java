package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Type arbeid oppgitt for ytelse.
 * 
 *  <h3>Bruk av konstanter</h3>
 *  Noen kjente eksempler på konstanter er oppgitt under.  Nye kan benyttes dersom avsender/mottager kjenner til de (listen er ikke utfyllende). 
 */
public class Arbeidskategori extends Kodeverk {
    static final String KODEVERK = "ARBEIDSKATEGORI";

    public static final Arbeidskategori FISKER = new Arbeidskategori("FISKER"); //$NON-NLS-1$
    public static final Arbeidskategori ARBEIDSTAKER = new Arbeidskategori("ARBEIDSTAKER"); //$NON-NLS-1$
    public static final Arbeidskategori SJØMANN = new Arbeidskategori("SJØMANN"); //$NON-NLS-1$
    public static final Arbeidskategori JORDBRUKER = new Arbeidskategori("JORDBRUKER"); //$NON-NLS-1$
    public static final Arbeidskategori DAGPENGER = new Arbeidskategori("DAGPENGER"); //$NON-NLS-1$
    public static final Arbeidskategori INAKTIV = new Arbeidskategori("INAKTIV"); //$NON-NLS-1$
    public static final Arbeidskategori FRILANSER = new Arbeidskategori("FRILANSER"); //$NON-NLS-1$
    public static final Arbeidskategori UGYLDIG = new Arbeidskategori("UGYLDIG"); //$NON-NLS-1$

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$", message="Kode '${validatedValue}' matcher ikke tillatt pattern '{regexp}'")
    @Size(min = 3, max = 100)
    @NotNull
    private String kode;

    @JsonCreator
    public Arbeidskategori(@JsonProperty(value = "kode", required = true) String kode) {
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
