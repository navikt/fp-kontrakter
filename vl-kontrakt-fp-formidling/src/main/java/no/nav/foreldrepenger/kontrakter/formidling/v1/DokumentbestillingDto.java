package no.nav.foreldrepenger.kontrakter.formidling.v1;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.FagsakYtelseType;
import no.nav.foreldrepenger.kontrakter.formidling.kodeverk.Vedtaksbrev;

public class DokumentbestillingDto {

    // Obligatoriske felter
    /**
     * ID til Behandlingen i FPSAK det bestilles dokument for
     */
    @NotNull
    private UUID behandlingUuid;
    /**
     * Unik ID for dokumentbestilling for å håndtere duplikater
     * Vurder å innføre @NotNull når frontend sender med en uuid ved forhåndsvisning
     */
    private UUID dokumentbestillingUuid;
    /**
     * Kode for ytelsetypeES
     */
    @NotNull
    private FagsakYtelseType ytelseType;
    /**
     * Kode for hvilket dokument som er bestilt
     * Se i DokumentMalType.java her  https://github.com/navikt/fp-formidling/
     * For gyldige verdier
     */
    @Pattern(regexp = "[A-Z]{6}")
    private String dokumentMal;
    /**
     * Kode for hvem som har bestilt dokumentet, f.eks VL, default: VL
     */
    @Pattern(regexp = "[A-ZÆØÅ0-9]{1,100}")
    private String historikkAktør;
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
    @Pattern(regexp = "[A-ZÆØÅ0-9]{1,100}")
    private String arsakskode;

    /**
     * Disse brukes kun ved forhåndsvisning, ikke ved dokumentbestilling
     * @see Vedtaksbrev kan brukes til å angi hvilken type vedtaksbrev som skal forhåndsvises, typisk AUTOMATISK eller FRITEKST.
     *
     */
    private Vedtaksbrev vedtaksbrev;
    private String tittel;
    private boolean gjelderVedtak;
    private boolean erOpphevetKlage;

    /**
     * Brukes ved dokumentbestilling, ikke forhåndsvisning, for å skille mellom NAV Klageinstans og NFP
     */
    @Pattern(regexp = "[A-ZÆØÅ0-9]{1,100}")
    private String behandlendeEnhetNavn;

    public UUID getBehandlingUuid() {
        return behandlingUuid;
    }

    public void setBehandlingUuid(UUID behandlingUuid) {
        this.behandlingUuid = behandlingUuid;
    }

    public UUID getDokumentbestillingUuid() {
        return dokumentbestillingUuid;
    }

    public void setDokumentbestillingUuid(UUID dokumentbestillingUuid) {
        this.dokumentbestillingUuid = dokumentbestillingUuid;
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

    public String getHistorikkAktør() {
        return historikkAktør;
    }

    public void setHistorikkAktør(String historikkAktør) {
        this.historikkAktør = historikkAktør;
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

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public boolean isGjelderVedtak() {
        return gjelderVedtak;
    }

    public void setGjelderVedtak(boolean gjelderVedtak) {
        this.gjelderVedtak = gjelderVedtak;
    }

    public boolean isErOpphevetKlage() {
        return erOpphevetKlage;
    }

    public void setErOpphevetKlage(boolean erOpphevetKlage) {
        this.erOpphevetKlage = erOpphevetKlage;
    }

    public Vedtaksbrev getVedtaksbrev() {
        return vedtaksbrev;
    }

    public void setVedtaksbrev(Vedtaksbrev vedtaksbrev) {
        this.vedtaksbrev = vedtaksbrev;
    }

    public String getBehandlendeEnhetNavn() {
        return behandlendeEnhetNavn;
    }

    public void setBehandlendeEnhetNavn(String behandlendeEnhetNavn) {
        this.behandlendeEnhetNavn = behandlendeEnhetNavn;
    }
}
