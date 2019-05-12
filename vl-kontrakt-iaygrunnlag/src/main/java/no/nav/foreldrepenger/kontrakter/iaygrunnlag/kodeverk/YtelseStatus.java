package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

    @JsonProperty(value = "kode", required = true, index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
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
