package no.nav.vedtak.felles.dokumentbestilling.v1;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import no.nav.vedtak.felles.dokumentbestilling.kodeverk.DokumentMalType;
import no.nav.vedtak.felles.dokumentbestilling.kodeverk.FagsakYtelseType;
import no.nav.vedtak.felles.dokumentbestilling.kodeverk.RevurderingVarslingÅrsak;

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
     */
    @NotNull
    private DokumentMalType dokumentMal;

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
     */
    private RevurderingVarslingÅrsak arsakskode = RevurderingVarslingÅrsak.UDEFINERT;

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

    public DokumentMalType getDokumentMal() {
        return dokumentMal;
    }

    public void setDokumentMal(DokumentMalType dokumentMal) {
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

    public RevurderingVarslingÅrsak getArsakskode() {
        return arsakskode;
    }

    public void setArsakskode(RevurderingVarslingÅrsak arsakskode) {
        this.arsakskode = arsakskode;
    }
}
