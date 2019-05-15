package no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeid.v1;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.PersonIdent;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.ALWAYS)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class ArbeidDto {

    @JsonProperty("person")
    @Valid
    private PersonIdent person;

    @JsonProperty("yrkesaktiviteter")
    @NotNull
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
