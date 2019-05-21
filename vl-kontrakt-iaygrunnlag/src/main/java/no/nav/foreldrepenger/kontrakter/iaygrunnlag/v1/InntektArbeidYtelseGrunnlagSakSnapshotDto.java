package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Representeer et snapshot aggregert av alle grunnlag knyttet til samme sak. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class InntektArbeidYtelseGrunnlagSakSnapshotDto {

    private static final ZoneId DEFAULT_ZONE = ZoneId.of("Europe/Oslo");
    
    /** Saksnummer alle grunnlag og koblinger er linket til. */
    @JsonProperty(value="saksnummer", required = true)
    @Valid
    private String saksnummer;

    /**
     * Liste av InntektArbeidYtelseGrunnlag.
     * <p>
     * <b>Merk:</b><br>
     * <ul>
     * <li>Det kan kun være ett aktivt grunnlag {@link Konvolutt#erAktiv()} med samme
     * {@link InntektArbeidYtelseGrunnlagDto#getKoblingReferanse()}, men flere inaktive</li>
     * <li>Rekkefølge gitt av {@link InntektArbeidYtelseGrunnlagDto#getGrunnlagTidspunkt()} angir historisk rekkefølge.</li>
     * </ul>
     */
    @JsonProperty(value = "grunnlag", required = true)
    @Valid
    private List<Konvolutt> grunnlag = new ArrayList<>();

    @JsonProperty(value = "snapshotTidspunkt", required = true)
    @Valid
    private OffsetDateTime snapshotTidspunkt = OffsetDateTime.now(DEFAULT_ZONE);

    public InntektArbeidYtelseGrunnlagSakSnapshotDto() {
    }
    
    public void setSaksnummer(String saksnummer) {
        this.saksnummer = saksnummer;
    }

    public void leggTil(InntektArbeidYtelseGrunnlagDto dto, Boolean aktiv) {
        grunnlag.add(new Konvolutt(dto, aktiv));
    }

    public void leggTil(InntektArbeidYtelseGrunnlagDto dto) {
        leggTil(dto, null);
    }

    public void setSnapshotTidspunkt(OffsetDateTime tidspunkt) {
        this.snapshotTidspunkt = tidspunkt;
    }

    public void setSnapshotTidspunkt(LocalDateTime tidspunkt) {
        Objects.requireNonNull(tidspunkt, "tidspunkt");
        this.snapshotTidspunkt = tidspunkt.atZone(DEFAULT_ZONE).toOffsetDateTime();
    }

    public OffsetDateTime getSnapshotTidspunkt() {
        return snapshotTidspunkt;
    }

    public List<Konvolutt> getGrunnlag() {
        return grunnlag;
    }
    
    public String getSaksnummer() {
        return saksnummer;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static class Konvolutt {

        /** Unik og immutable grunnlag. Data kan dedupliseres ved å se på {@link InntektArbeidYtelseGrunnlagDto#getGrunnlagReferanse()} */
        @JsonProperty(value = "data", required = true)
        @Valid
        private InntektArbeidYtelseGrunnlagDto data;

        /**
         * Hvis satt angir at dette grunnlaget er aktivt (eller inaktivt). Hvis ikke satt - så ubestemt.
         * Merk at dette flagget er transient og vil endre seg over tid (når nye grunnnlag blir aktive så blir gamle grunnlag inaktive)
         */
        @JsonProperty(value = "aktiv", required = false)
        private Boolean aktiv;

        @JsonCreator
        public Konvolutt(@JsonProperty(value = "data", required = true) @Valid InntektArbeidYtelseGrunnlagDto data,
                         @JsonProperty(value = "aktiv", required = false) Boolean aktiv) {
            this.data = data;
            this.aktiv = aktiv;
        }

        public Boolean erAktiv() {
            return aktiv;
        }

        public InntektArbeidYtelseGrunnlagDto getData() {
            return data;
        }

    }

}
