package no.nav.vedtak.ytelse.v1;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.vedtak.ytelse.Aktør;
import no.nav.vedtak.ytelse.Periode;
import no.nav.vedtak.ytelse.Ytelse;
import no.nav.vedtak.ytelse.v1.anvisning.Anvisning;

public class YtelseV1 extends Ytelse {

    @NotNull
    @Valid
    @JsonProperty("aktør")
    private Aktør aktør;

    @NotNull
    @Valid
    @JsonProperty("vedtattTidspunkt")
    private LocalDateTime vedtattTidspunkt;

    @NotNull
    @Valid
    @JsonProperty("type")
    private YtelseType type;

    @Pattern(regexp = "^(-?[1-9]|[a-z0])[a-z0-9_:-]*$", flags = {Pattern.Flag.CASE_INSENSITIVE})
    @JsonProperty("saksnummer")
    private String saksnummer;

    @NotNull
    @Pattern(regexp = "\\b[0-9a-f]{8}\\b-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-\\b[0-9a-f]{12}\\b")
    @JsonProperty("vedtakReferanse")
    private String vedtakReferanse;

    @NotNull
    @Valid
    @JsonProperty("status")
    private YtelseStatus status;

    @NotNull
    @Valid
    @JsonProperty("fagsystem")
    private Fagsystem fagsystem;

    @NotNull
    @Valid
    @JsonProperty("periode")
    private Periode periode;

    @NotNull
    @Valid
    @JsonProperty("anvist")
    private List<Anvisning> anvist;

    public YtelseV1() {
    }

    public YtelseType getType() {
        return type;
    }

    public void setType(YtelseType type) {
        this.type = type;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public void setSaksnummer(String saksnummer) {
        this.saksnummer = saksnummer;
    }

    public YtelseStatus getStatus() {
        return status;
    }

    public void setStatus(YtelseStatus status) {
        this.status = status;
    }

    public Fagsystem getFagsystem() {
        return fagsystem;
    }

    public void setFagsystem(Fagsystem fagsystem) {
        this.fagsystem = fagsystem;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public List<Anvisning> getAnvist() {
        return anvist;
    }

    public void setAnvist(List<Anvisning> anvist) {
        this.anvist = anvist;
    }

    public Aktør getAktør() {
        return aktør;
    }

    public void setAktør(Aktør aktør) {
        this.aktør = aktør;
    }

    public LocalDateTime getVedtattTidspunkt() {
        return vedtattTidspunkt;
    }

    public void setVedtattTidspunkt(LocalDateTime vedtattTidspunkt) {
        this.vedtattTidspunkt = vedtattTidspunkt;
    }

    public String getVedtakReferanse() {
        return vedtakReferanse;
    }

    public void setVedtakReferanse(String vedtakReferanse) {
        this.vedtakReferanse = vedtakReferanse;
    }
}
