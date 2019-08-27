package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Status på ytelse. tilsvarer FagsakStatus, RelatertYtelseTilstand. */
public class YtelseStatus extends Kodeverk {

    static final String KODEVERK = "YTELSE_STATUS";

    /** Eksempel konstant - Ikke startet ytelse. */
    public static final YtelseStatus OPPRETTET = new YtelseStatus("OPPR");
    /** Eksempel konstant - Åpen ytelse. */
    public static final YtelseStatus UNDER_BEHANDLING = new YtelseStatus("UBEH");
    /** Eksempel konstant - Løpende ytelse. */
    public static final YtelseStatus LØPENDE = new YtelseStatus("LOP");
    /** Eksempel konstant - Avsluttet ytelse. */
    public static final YtelseStatus AVSLUTTET = new YtelseStatus("AVSLU");

    /** Status koder. Tolererer ikke unicode her (sikrer at ingen overfører gamle koder på grensesnittet). */
    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[A-Z0-9\\.\\-]+$", message="Kode '${validatedValue}' matcher ikke tillatt pattern '{regexp}'")
    @Size(min=3, max=5)
    @NotNull
    private String kode;

    @JsonCreator
    public YtelseStatus(@JsonProperty(value = "kode", required = true) String kode) {
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
