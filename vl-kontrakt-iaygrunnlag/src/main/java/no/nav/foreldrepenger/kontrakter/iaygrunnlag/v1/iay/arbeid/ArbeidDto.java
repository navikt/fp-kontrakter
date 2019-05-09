package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.PersonIdent;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.ALWAYS)
public class ArbeidDto {

    @JsonProperty("person")
    @Valid
    private PersonIdent person;
    
    @JsonProperty("yrkesaktiviteter")
    @Valid
    private List<YrkesaktivitetDto> yrkesaktiviteter;

    protected ArbeidDto() {
    }
    
    public ArbeidDto(PersonIdent person) {
        Objects.requireNonNull(person, "person");
        this.person = person;
    }

    public PersonIdent getPerson() {
        return person;
    }

    public List<YrkesaktivitetDto> getYrkesaktiviteter() {
        return yrkesaktiviteter;
    }

    public void setYrkesaktiviteter(List<YrkesaktivitetDto> yrkesaktiviteter) {
        this.yrkesaktiviteter = yrkesaktiviteter;
    }
    
    public ArbeidDto medYrkesaktiviteter(List<YrkesaktivitetDto> yrkesaktiviteter) {
        setYrkesaktiviteter(yrkesaktiviteter);
        return this;
    }
}
