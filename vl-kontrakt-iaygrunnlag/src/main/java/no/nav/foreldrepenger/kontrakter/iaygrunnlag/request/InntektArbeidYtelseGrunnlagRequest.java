package no.nav.foreldrepenger.kontrakter.iaygrunnlag.request;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.PersonIdent;

/**
 * Spesifikasjon for å hente opp et InntektArbeidYtelseGrunnlag.
 * Merk at props her kan ekskludere/kombineres.
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

    @JsonProperty("dataset")
    @Valid
    public Set<Dataset> dataset = EnumSet.of(Dataset.REGISTER, Dataset.OVERSTYRT);

    public InntektArbeidYtelseGrunnlagRequest() {
        // default ctor.
    }

    @AssertTrue(message = "grunnlagReferanse eller koblingReferanse må spesifiseres")
    private boolean isOk() {
        return grunnlagReferanse != null || koblingReferanse != null;
    }

    public InntektArbeidYtelseGrunnlagRequest medDataset(Dataset data) {
        dataset.add(data);
        return this;
    }

    public InntektArbeidYtelseGrunnlagRequest medDataset(Collection<Dataset> data) {
        dataset = Set.copyOf(data);
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
}
