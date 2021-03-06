package no.nav.foreldrepenger.kontrakter.fordel;

import java.util.Optional;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OpprettSakDto {

    @Digits(integer = 18, fraction = 0)
    private String journalpostId;

    @NotNull
    @Size(max = 8)
    @Pattern(regexp = "^[a-zA-ZæøåÆØÅ_\\-0-9]*$")
    private String behandlingstemaOffisiellKode;

    @NotNull
    @Digits(integer = 19, fraction = 0)
    private String aktørId;

    public OpprettSakDto(String journalpostId, String behandlingstemaOffisiellKode, String aktørId) {
        this.journalpostId = journalpostId;
        this.behandlingstemaOffisiellKode = behandlingstemaOffisiellKode;
        this.aktørId = aktørId;
    }

    protected OpprettSakDto() { 
        //For Jackson
    }

    public Optional<String> getJournalpostId() {
        return Optional.ofNullable(journalpostId);
    }

    public String getBehandlingstemaOffisiellKode() {
        return behandlingstemaOffisiellKode;
    }

    public String getAktørId() {
        return aktørId;
    }

}
