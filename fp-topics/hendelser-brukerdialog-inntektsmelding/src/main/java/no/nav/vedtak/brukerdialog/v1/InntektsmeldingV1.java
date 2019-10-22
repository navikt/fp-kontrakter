package no.nav.vedtak.brukerdialog.v1;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.vedtak.brukerdialog.Aktør;
import no.nav.vedtak.brukerdialog.DokumentHendelse;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_ABSENT, content = JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class InntektsmeldingV1 extends DokumentHendelse {

    public static final String HENDELSE_INNTEKTSMELDING = "INNTEKTSMELDING_";
    private static final String INNTEKTSMELDING_NY = "NY";
    private static final String INNTEKTSMELDING_ENDRING = "ENDRING";

    /**
     * Hendelsetype til bruk for mottatte inntektsmdeldinger. Venter "..._NY" eller "_ENDRING"
     */
    @NotNull
    @Size(max = 50)
    @Pattern(regexp = "INNTEKTSMELDING_NY|INNTEKTSMELDING_ENDRING")
    @JsonProperty(value = "hendelse", required = true, defaultValue = HENDELSE_INNTEKTSMELDING + INNTEKTSMELDING_NY)
    private String hendelse;

    /**
     * Saksnummer som inntektsmeldingen er journalført på
     */
    @NotNull
    @Size(max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9_\\-]*$")
    @JsonProperty(value = "saksnummer", required = true)
    private String saksnummer;

    /**
     * Journalpost for arkivert inntektsmelding
     */
    @NotNull
    @Size(max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9_\\-]*$")
    @JsonProperty(value = "journalpostId", required = true)
    private String journalpostId;

    /**
     * Unik referanse for inntektsmelding - bruker AR-referanse
     */
    @NotNull
    @Size(max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9_\\-]*$")
    @JsonProperty(value = "referanseId", required = true)
    private String referanseId;

    /**
     * Bruker som inntektsmelding gjelder for
     */
    @NotNull
    @Valid
    @JsonProperty(value = "aktørId", required = true)
    private Aktør aktørId;

    /**
     * ID for innsender - kan være org.nr eller aktørId (privat arbeidsgiver)
     */
    @NotNull
    @Valid
    @JsonProperty(value = "arbeidsgiverId", required = true)
    private Aktør arbeidsgiverId;

    /**
     * Innsendinstidspunkt fra inntektsmelding
     */
    @NotNull
    @Valid
    @JsonProperty(value = "innsendingsTidspunkt", required = true)
    private LocalDateTime innsendingsTidspunkt;

    /**
     * Startdato - kun satt for Foreldrepenger, ikke svangerskapspenger
     */
    @Valid
    @JsonProperty(value = "startDato", required = true)
    private LocalDate startDato;

    /**
     * Ytelsetype - framgår av saken
     */
    @Valid
    @Size(max = 20)
    @JsonProperty(value = "ytelse", required = true)
    private String ytelse;

    @Override
    public String getJournalpostId () {
        return journalpostId;
    }

    @Override
    public String getSaksnummer() {
        return saksnummer;
    }

    @Override
    public String getHendelse() {
        return hendelse;
    }

    @Override
    public Aktør getAktørId() {
        return aktørId;
    }

    @Override
    public LocalDateTime getInnsendingsTidspunkt() {
        return innsendingsTidspunkt;
    }

    public Aktør getArbeidsgiverId() {
        return arbeidsgiverId;
    }

    public String getReferanseId() { return referanseId; }

    public LocalDate getStartDato() {
        return startDato;
    }

    public String getYtelse() {
        return ytelse;
    }

    public static class Builder {
        private InntektsmeldingV1 inntektsmelding;

        public Builder() {
            inntektsmelding = new InntektsmeldingV1();
        }

        public Builder medSaksnummer(String saksnummer) {
            inntektsmelding.saksnummer = saksnummer;
            return this;
        }

        public Builder medJournalpostId(String journalpostId) {
            inntektsmelding.journalpostId = journalpostId;
            return this;
        }

        public Builder medReferanseId(String referanseId) {
            inntektsmelding.referanseId = referanseId;
            return this;
        }

        public Builder medAktørId(String aktørId) {
            inntektsmelding.aktørId = new Aktør(aktørId);
            return this;
        }

        public Builder medArbeidsgiverId(String aktørId) {
            inntektsmelding.arbeidsgiverId = new Aktør(aktørId);
            return this;
        }

        public Builder medStartDato(LocalDate startDato) {
            inntektsmelding.startDato = startDato;
            return this;
        }

        public Builder medInnsendingsTidspunkt(LocalDateTime innsendingsTidspunkt) {
            inntektsmelding.innsendingsTidspunkt = innsendingsTidspunkt;
            return this;
        }

        public Builder medInnsendingsÅrsak(String innsendingsÅrsak) {
            inntektsmelding.hendelse = HENDELSE_INNTEKTSMELDING + innsendingsÅrsak;
            return this;
        }

        public Builder medYtelse(String ytelse) {
            inntektsmelding.ytelse = ytelse;
            return this;
        }

        public InntektsmeldingV1 build() {
            return inntektsmelding;
        }
    }
}
