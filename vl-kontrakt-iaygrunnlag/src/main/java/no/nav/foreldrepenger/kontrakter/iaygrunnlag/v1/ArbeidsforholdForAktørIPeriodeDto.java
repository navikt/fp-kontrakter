package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Aktør;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.PersonIdent;

/**
 * @deprecated FIXME trengs denne?
 */
@Deprecated
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class ArbeidsforholdForAktørIPeriodeDto {

    @JsonProperty(value = "aktør", required = true)
    @NotNull
    @Valid
    private PersonIdent aktør;
    
    @JsonProperty(value="periode", required = true)
    @NotNull
    @Valid
    private Periode periode;

    protected ArbeidsforholdForAktørIPeriodeDto() {
    }

    public ArbeidsforholdForAktørIPeriodeDto(PersonIdent aktør, Periode periode) {
        this.aktør = aktør;
        this.periode = periode;
    }

    public Aktør getAktør() {
        return aktør;
    }

    public Periode getPeriode() {
        return periode;
    }
}
