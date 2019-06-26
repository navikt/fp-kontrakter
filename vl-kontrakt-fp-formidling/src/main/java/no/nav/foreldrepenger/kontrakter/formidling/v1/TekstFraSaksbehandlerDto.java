package no.nav.foreldrepenger.kontrakter.formidling.v1;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.Vedtaksbrev;

public class TekstFraSaksbehandlerDto {

    // Obligatoriske felter
    /**
     * ID til Behandlingen i FPSAK det bestilles dokument for
     */
    @NotNull
    private UUID behandlingUuid;

    private Vedtaksbrev vedtaksbrev;

    private String avklarFritekst;

    private String tittel;

    private String fritekst;

    public UUID getBehandlingUuid() {
        return behandlingUuid;
    }

    public void setBehandlingUuid(UUID behandlingUuid) {
        this.behandlingUuid = behandlingUuid;
    }

    public Vedtaksbrev getVedtaksbrev() {
        return vedtaksbrev;
    }

    public void setVedtaksbrev(Vedtaksbrev vedtaksbrev) {
        this.vedtaksbrev = vedtaksbrev;
    }

    public String getAvklarFritekst() {
        return avklarFritekst;
    }

    public void setAvklarFritekst(String avklarFritekst) {
        this.avklarFritekst = avklarFritekst;
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
}
