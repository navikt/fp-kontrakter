package no.nav.vedtak.felles.dokumentbestilling.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.vedtak.felles.dokumentbestilling.kodeverk.FagsakYtelseType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_ABSENT, content = JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class DokumentbestillingV1 {

    // Obligatoriske felter
    /**
     * ID til Behandlingen i FPSAK det bestilles dokument for
     */
    @NotNull
    @JsonProperty(required = true)
    private UUID behandlingUuid;

    /**
     * Unik ID for dokumentbestilling for å håndtere duplikater
     */
    @NotNull
    @JsonProperty(required = true)
    private UUID dokumentbestillingUuid;
    /**
     * Kode for ytelsetypeES
     */
    @NotNull
    @Valid
    @JsonProperty(required = true)
    private FagsakYtelseType ytelseType;
    /**
     * Kode for hvilket dokument som er bestilt
     * Obligatorisk når brev bestilles fordi FPSAK kan utlede dette
     * Se i DokumentMalType.java her  https://github.com/navikt/fp-formidling/
     * For gyldige verdier
     */
    @NotNull
    @Pattern(regexp = "[A-Z]{6}")
    @JsonProperty(required = true)
    private String dokumentMal;


    /**
     * Kode for hvem som har bestilt dokumentet, f.eks VL, default: VL
     */
    @NotNull
    @Pattern(regexp = "[A-ZÆØÅ0-9]{1,100}")
    @JsonProperty(required = true)
    private String historikkAktør;

    /**
     * Fritekstfelt
     */
    @JsonProperty
    private String fritekst;
    /**
     * Kode for Årsak for Varsling av revudering
     * Brukes i brev for varsel om revurding
     * Se RevurderingVarslingÅrsak.java i https://github.com/navikt/fp-formidling/
     * for verdier
     */
    @Pattern(regexp = "[A-ZÆØÅ0-9]{1,100}")
    @JsonProperty
    private String arsakskode;

    public UUID getBehandlingUuid() {
        return behandlingUuid;
    }

    public UUID getDokumentbestillingUuid() {
        return dokumentbestillingUuid;
    }

    public void setDokumentbestillingUuid(UUID dokumentbestillingUuid) {
        this.dokumentbestillingUuid = dokumentbestillingUuid;
    }

    public void setBehandlingUuid(UUID behandlingUuid) {
        this.behandlingUuid = behandlingUuid;
    }

    public FagsakYtelseType getYtelseType() {
        return ytelseType;
    }

    public void setYtelseType(FagsakYtelseType ytelseType) {
        this.ytelseType = ytelseType;
    }

    public String getDokumentMal() {
        return dokumentMal;
    }

    public void setDokumentMal(String dokumentMal) {
        this.dokumentMal = dokumentMal;
    }

    public String getFritekst() {
        return fritekst;
    }

    public void setFritekst(String fritekst) {
        this.fritekst = fritekst;
    }

    public String getArsakskode() {
        return arsakskode;
    }

    public void setArsakskode(String arsakskode) {
        this.arsakskode = arsakskode;
    }

    public String getHistorikkAktør() {
        return historikkAktør;
    }

    public void setHistorikkAktør(String historikkAktør) {
        this.historikkAktør = historikkAktør;
    }
}
