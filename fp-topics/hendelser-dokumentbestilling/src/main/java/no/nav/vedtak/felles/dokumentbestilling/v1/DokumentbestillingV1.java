package no.nav.vedtak.felles.dokumentbestilling.v1;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import no.nav.vedtak.felles.dokumentbestilling.kodeverk.FagsakYtelseType;

public class DokumentbestillingV1 {

    // Obligatoriske felter
    /**
     * ID til Behandlingen i FPSAK det bestilles dokument for
     */
    @NotNull
    @Min(0)
    @Max(Long.MAX_VALUE)
    private Long behandlingId;
    /**
     * Kode for ytelsetypeES
     */
    @NotNull
    private FagsakYtelseType ytelseType;
    /**
     * Kode for hvilket dokument som er bestilt
     * Obligatorisk når brev bestilles fordi FPSAK kan utlede dette
     * Se i DokumentMalType.java her  https://github.com/navikt/fp-formidling/
     * For gyldige verdier
     */
    @NotNull
    @Pattern(regexp = "[A-Z]{6}")
    private String dokumentMal;

    /**
     * Tittel for fritekstbrev
     */
    private String tittel;
    /**
     * Fritekstfelt
     */
    private String fritekst;
    /**
     * Kode for Årsak for Varsling av revudering
     * Brukes i brev for varsel om revurding
     * Se RevurderingVarslingÅrsak.java i https://github.com/navikt/fp-formidling/
     * for verdier
     */
    @Pattern(regexp = "[A-Z]{1,100}]")
    private String arsakskode;

    /**
     * Kode for hvem som har bestilt dokumentet, f.eks VL, default: VL
     */

    public Long getBehandlingId() {
        return behandlingId;
    }

    public void setBehandlingId(Long behandlingId) {
        this.behandlingId = behandlingId;
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

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
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
}
