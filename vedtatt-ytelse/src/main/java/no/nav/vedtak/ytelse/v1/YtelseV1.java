package no.nav.vedtak.ytelse.v1;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import no.nav.vedtak.ytelse.Kodeverk;
import no.nav.vedtak.ytelse.Periode;
import no.nav.vedtak.ytelse.Ytelse;
import no.nav.vedtak.ytelse.v1.anvisning.Anvisning;

public class YtelseV1 extends Ytelse {

    @NotNull
    @Valid
    private Kodeverk type;
    @Pattern(regexp = "^(-?[1-9]|[a-z0])[a-z0-9_:-]*$", flags = {Pattern.Flag.CASE_INSENSITIVE})
    private String saksnummer;
    @NotNull
    @Valid
    private Kodeverk status;
    @NotNull
    @Valid
    private Kodeverk fagsystem;
    @NotNull
    @Valid
    private Periode periode;
    @NotNull
    @Valid
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
