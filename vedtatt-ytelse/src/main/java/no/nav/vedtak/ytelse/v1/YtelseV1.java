package no.nav.vedtak.ytelse.v1;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.vedtak.ytelse.Kodeverk;
import no.nav.vedtak.ytelse.Periode;
import no.nav.vedtak.ytelse.Ytelse;
import no.nav.vedtak.ytelse.v1.anvisning.Anvisning;

public class YtelseV1 extends Ytelse {

    @NotNull
    @Valid
    @JsonProperty("type")
    private Kodeverk type;

    @Pattern(regexp = "^(-?[1-9]|[a-z0])[a-z0-9_:-]*$", flags = {Pattern.Flag.CASE_INSENSITIVE})
    @JsonProperty("saksnummer")
    private String saksnummer;

    @NotNull
    @Valid
    @JsonProperty("status")
    private Kodeverk status;

    @NotNull
    @Valid
    @JsonProperty("fagsystem")
    private Kodeverk fagsystem;

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

    public Kodeverk getType() {
        return type;
    }

    public void setType(Kodeverk type) {
        this.type = type;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public void setSaksnummer(String saksnummer) {
        this.saksnummer = saksnummer;
    }

    public Kodeverk getStatus() {
        return status;
    }

    public void setStatus(Kodeverk status) {
        this.status = status;
    }

    public Kodeverk getFagsystem() {
        return fagsystem;
    }

    public void setFagsystem(Kodeverk fagsystem) {
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
}
