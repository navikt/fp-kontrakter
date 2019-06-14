package no.nav.foreldrepenger.kontrakter.iaygrunnlag.request;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.PersonIdent;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1.OppgittOpptjeningDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(value = JsonInclude.Include.NON_ABSENT, content = JsonInclude.Include.NON_EMPTY)
public class OppgittOpptjeningMottattRequest {

    @JsonProperty(value = "saksnummer", required = true)
    @NotNull
    @Valid
    private String saksnummer;

    @JsonProperty(value = "koblingReferanse", required = true)
    @NotNull
    @Valid
    private UUID koblingReferanse;

    @JsonProperty(value = "aktør", required = true)
    @NotNull
    @Valid
    private PersonIdent aktør;

    @JsonProperty(value = "oppgittOpptjening", required = true)
    @NotNull
    @Valid
    private OppgittOpptjeningDto oppgittOpptjening;

    @JsonCreator
    public OppgittOpptjeningMottattRequest(@JsonProperty(value = "saksnummer", required = true) @Valid @NotNull String saksnummer,
                                           @JsonProperty(value = "koblingReferanse", required = true) @Valid @NotNull UUID koblingReferanse,
                                           @JsonProperty(value = "aktør", required = true) @NotNull @Valid PersonIdent aktør,
                                           @JsonProperty(value = "oppgittOpptjening", required = true) @NotNull @Valid OppgittOpptjeningDto oppgittOpptjening) {
        this.saksnummer = saksnummer;
        this.koblingReferanse = koblingReferanse;
        this.aktør = aktør;
        this.oppgittOpptjening = oppgittOpptjening;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public UUID getKoblingReferanse() {
        return koblingReferanse;
    }

    public PersonIdent getAktør() {
        return aktør;
    }

    public OppgittOpptjeningDto getOppgittOpptjening() {
        return oppgittOpptjening;
    }
}
