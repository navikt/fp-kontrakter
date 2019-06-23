package no.nav.foreldrepenger.kontrakter.iaygrunnlag.request;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.PersonIdent;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseType;

/**
 * Spesifikasjon for å hente opp et InntektArbeidYtelseGrunnlag.
 * Merk at props her kan ekskludere/kombineres.
 * Må minimum angi personident og en eller flere referanser (grunnlag, kobling, saksnummer)
 */ 
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE, creatorVisibility = Visibility.NONE)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class InntektArbeidYtelseGrunnlagRequest {

    public enum Dataset {
        REGISTER,
        OVERSTYRT,
        INNTEKTSMELDING,
        OPPGITT_OPPTJENING
    }

    /** Angi hvem grunnlaget hentes for. */
    @JsonProperty(value = "personIdent", required = true)
    @Valid
    @NotNull
    private PersonIdent person;

    @JsonProperty(value = "ytelseType")
    @Valid
    private YtelseType ytelseType;

    /** Forespørsel på grunnlag referanse gir eksakt grunnlag forespurt (også utdaterte versjoner). */
    @JsonProperty("grunnlagReferanse")
    @Valid
    private UUID grunnlagReferanse;

    /**
     * Forespørsel på kobling referanse gir kun siste grunnlag på koblingen (kobling er typisk eks. behandling). Ignoreres dersom
     * grunnlagReferanse er satt.
     */
    @JsonProperty("koblingReferanse")
    @Valid
    private UUID koblingReferanse;

    /** Angi evt. hvilken sak det gjelder. */
    @JsonProperty(value = "saksnummer")
    @Valid
    @Pattern(regexp = "^[A-Za-z0-9_\\.\\-]+$", message = "Saksnummer '${validatedValue}' matcher ikke tillatt pattern '{value}'")
    private String saksnummer;

    @JsonProperty("dataset")
    @Valid
    public Set<Dataset> dataset = EnumSet.of(Dataset.REGISTER, Dataset.OVERSTYRT);

    protected InntektArbeidYtelseGrunnlagRequest() {
        // default ctor.
    }

    @JsonCreator
    public InntektArbeidYtelseGrunnlagRequest(@JsonProperty(value = "personIdent", required = true) @Valid @NotNull PersonIdent person) {
        this.person = Objects.requireNonNull(person, "person");
    }

    @AssertTrue(message = "grunnlagReferanse eller koblingReferanse eller saksnummer må spesifiseres")
    private boolean isOk() {
        return grunnlagReferanse != null || koblingReferanse != null || saksnummer != null;
    }

    public InntektArbeidYtelseGrunnlagRequest medDataset(Dataset data) {
        this.dataset.add(data);
        return this;
    }

    public InntektArbeidYtelseGrunnlagRequest medDataset(Collection<Dataset> data) {
        this.dataset = Set.copyOf(data);
        return this;
    }

    public InntektArbeidYtelseGrunnlagRequest medSaksnummer(String saksnummer) {
        this.saksnummer = saksnummer;
        return this;
    }
    
    public InntektArbeidYtelseGrunnlagRequest medYtelseType(YtelseType ytelseType) {
        this.ytelseType = ytelseType;
        return this;
    }
    
    public InntektArbeidYtelseGrunnlagRequest forKobling(UUID koblingReferanse) {
        this.koblingReferanse = koblingReferanse;
        return this;
    }

    public InntektArbeidYtelseGrunnlagRequest forGrunnlag(UUID grunnlagReferanse) {
        this.grunnlagReferanse = grunnlagReferanse;
        return this;
    }

    public Set<Dataset> getDataset() {
        return dataset;
    }

    public UUID getKoblingReferanse() {
        return koblingReferanse;
    }

    public UUID getGrunnlagReferanse() {
        return grunnlagReferanse;
    }

    public PersonIdent getPerson() {
        return person;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public YtelseType getYtelseType() {
        return ytelseType;
    }
}
