package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.PersonIdent;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.ALWAYS)
public class ArbeidDto {

    @JsonProperty("aktør")
    @Valid
    private PersonIdent aktør;
    
    @JsonProperty("yrkesaktiviteter")
    @Valid
    private List<YrkesaktivitetDto> yrkesaktiviteter = Collections.emptyList();

    protected ArbeidDto() {
    }

    public PersonIdent getAktør() {
        return aktør;
    }

    public void setAktør(PersonIdent aktør) {
        this.aktør = aktør;
    }

    public List<YrkesaktivitetDto> getYrkesaktiviteter() {
        return yrkesaktiviteter;
    }

    public void setYrkesaktiviteter(List<YrkesaktivitetDto> yrkesaktiviteter) {
        this.yrkesaktiviteter = yrkesaktiviteter;
    }
}
