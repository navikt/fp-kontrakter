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

    public static final String HENDELSE_INNTEKTSMELDING = "INNTEKTSMELDING";

    /**
     * Hendelsetype til brul for mottatte inntektsmdeldinger
     */
    @NotNull
    @Valid
    @JsonProperty(value = "hendelse", required = true, defaultValue = HENDELSE_INNTEKTSMELDING)
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
    @JsonProperty(value = "arbeidsgiver", required = true)
    private Aktør arbeidsgiver;

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
     * Type NY/ENDRING/-
     */
    @NotNull
    @Size(max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9_\\-]*$")
    @JsonProperty(value = "innsendingAarsak", required = true)
    private String innsendingAarsak;

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

    public Aktør getArbeidsgiver() {
        return arbeidsgiver;
    }

    public String getReferanseId() { return referanseId; }

    public LocalDate getStartDato() {
        return startDato;
    }

    public String getInnsendingAarsak() {
        return innsendingAarsak;
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

        public Builder medAktørId(String aktør) {
            inntektsmelding.aktørId = new Aktør(aktør);
            return this;
        }

        public Builder medArbeidsgiver(String aktør) {
            inntektsmelding.arbeidsgiver = new Aktør(aktør);
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

        public Builder medInnsendingAarsak(String innsendingAarsak) {
            inntektsmelding.innsendingAarsak = innsendingAarsak;
            return this;
        }

        public InntektsmeldingV1 build() {
            inntektsmelding.hendelse = HENDELSE_INNTEKTSMELDING;
            return inntektsmelding;
        }
    }
}
