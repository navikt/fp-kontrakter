package no.nav.foreldrepenger.kontrakter.fordel;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JournalpostMottakDto {

    private static final int PAYLOAD_MAX_CHARS = 48000;

    @NotNull
    @Digits(integer = 18, fraction = 0)
    private String saksnummer;

    @NotNull
    @Digits(integer = 18, fraction = 0)
    private String journalpostId;

    private UUID forsendelseId;

    @NotNull
    @Size(max = 8)
    @Pattern(regexp = "^[a-zA-ZæøåÆØÅ_\\-0-9]*")
    private String behandlingstemaOffisiellKode;

    @Size(max = 8)
    @Pattern(regexp = "^[a-zA-ZæøåÆØÅ_\\-0-9]*")
    private String dokumentTypeIdOffisiellKode;

    private LocalDate forsendelseMottatt;

    private LocalDateTime forsendelseMottattTidspunkt;

    @Size(max = 25)
    @Pattern(regexp = "^[a-zA-ZæøåÆØÅ_\\-0-9]*")
    private String dokumentKategoriOffisiellKode;

    @Size(max = 5)
    private String journalForendeEnhet;

    @JsonProperty("payloadXml")
    @Pattern(regexp = "^[a-zA-Z0-9\\-_=]$")
    @Size(max = PAYLOAD_MAX_CHARS * 2) // Gir plass til 50% flere byte enn characters, det bør holde
    protected String base64EncodedPayloadXml;

    /**
     * Siden XML'en encodes før overføring må lengden på XML'en lagres som en separat property for å kunne valideres.
     * Lengden er basert på at MOTTAT_DOKUMENT.XML_PAYLOAD ern en VARCHAR2(4000)
     */
    @JsonProperty("payloadLength")
    @Max(PAYLOAD_MAX_CHARS)
    @Min(1)
    protected Integer payloadLength;

    public JournalpostMottakDto(String saksnummer, String journalpostId, String behandlingstemaOffisiellKode, String dokumentTypeIdOffisiellKode,
                                LocalDateTime forsendelseMottattTidspunkt, String payloadXml) {
        this.saksnummer = saksnummer;
        this.journalpostId = journalpostId;
        this.behandlingstemaOffisiellKode = behandlingstemaOffisiellKode;
        this.dokumentTypeIdOffisiellKode = dokumentTypeIdOffisiellKode;
        this.forsendelseMottatt = forsendelseMottattTidspunkt.toLocalDate();
        this.forsendelseMottattTidspunkt = forsendelseMottattTidspunkt;
        String payload = null;
        if (payloadXml != null && !(payload = payloadXml.trim()).isEmpty()) {
            byte[] bytes = payload.getBytes(Charset.forName("UTF-8"));
            this.payloadLength = payload.length();
            this.base64EncodedPayloadXml = Base64.getUrlEncoder().encodeToString(bytes);
        }
    }

    public void setForsendelseId(UUID forsendelseId) {
        this.forsendelseId = forsendelseId;
    }

    public Optional<UUID> getForsendelseId() {
        return Optional.ofNullable(this.forsendelseId);
    }

    protected JournalpostMottakDto() {
        // For Jackson
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public String getJournalpostId() {
        return journalpostId;
    }

    public String getBehandlingstemaOffisiellKode() {
        return behandlingstemaOffisiellKode;
    }

    public Optional<String> getDokumentTypeIdOffisiellKode() {
        return Optional.ofNullable(dokumentTypeIdOffisiellKode);
    }

    public Optional<LocalDate> getForsendelseMottatt() {
        return Optional.ofNullable(forsendelseMottatt);
    }

    public String getDokumentKategoriOffisiellKode() {
        return dokumentKategoriOffisiellKode;
    }

    public LocalDateTime getForsendelseMottattTidspunkt() {
        return forsendelseMottattTidspunkt;
    }

    public void setDokumentKategoriOffisiellKode(String dokumentKategoriOffisiellKode) {
        this.dokumentKategoriOffisiellKode = dokumentKategoriOffisiellKode;
    }

    public String getJournalForendeEnhet() {
        return journalForendeEnhet;
    }

    public void setJournalForendeEnhet(String journalForendeEnhet) {
        this.journalForendeEnhet = journalForendeEnhet;
    }

}
