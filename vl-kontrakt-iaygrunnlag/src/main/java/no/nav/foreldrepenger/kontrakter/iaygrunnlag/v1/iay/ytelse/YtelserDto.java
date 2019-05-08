package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.Aktør;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.PersonIdent;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.ALWAYS)
public class YtelserDto {

    /** Bruker ytelse gjelder for. */
    @JsonProperty(value = "aktør", required = true)
    @Valid
    private PersonIdent aktør;

    @JsonProperty(value="ytelser")
    @Valid
    private List<YtelseDto> ytelser = Collections.emptyList();

    public YtelserDto() {
    }

    public Aktør getAktør() {
        return aktør;
    }

    public void setAktør(PersonIdent aktør) {
        this.aktør = aktør;
    }

    public List<YtelseDto> getYtelser() {
        return ytelser;
    }

    public void setYtelser(List<YtelseDto> ytelser) {
        this.ytelser = ytelser;
    }
}
