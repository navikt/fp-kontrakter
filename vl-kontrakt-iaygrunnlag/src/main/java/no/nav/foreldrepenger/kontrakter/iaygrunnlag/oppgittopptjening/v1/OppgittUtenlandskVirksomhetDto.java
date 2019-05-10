package no.nav.foreldrepenger.kontrakter.iaygrunnlag.oppgittopptjening.v1;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.LandkoderDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class OppgittUtenlandskVirksomhetDto {

    @JsonProperty(value = "landkode", required = true)
    @Valid
    @NotNull
    private LandkoderDto landkode;

    @JsonProperty(value = "virksomhetNavn", required = true)
    @NotNull
    @Pattern(regexp = "^[\\p{L}\\p{N}\\.\\- ]+$")
    private String virksomhetNavn;

    protected OppgittUtenlandskVirksomhetDto() {
        // default ctor
    }

    public OppgittUtenlandskVirksomhetDto(LandkoderDto landkode, String virksomhetNavn) {
        this.landkode = landkode;
        this.virksomhetNavn = virksomhetNavn;
    }
    
    public OppgittUtenlandskVirksomhetDto(String landkode, String virksomhetNavn) {
        this.landkode = new LandkoderDto(landkode);
        this.virksomhetNavn = virksomhetNavn;
    }

    public LandkoderDto getLandkode() {
        return landkode;
    }

    public String getVirksomhetNavn() {
        return virksomhetNavn;
    }
}
