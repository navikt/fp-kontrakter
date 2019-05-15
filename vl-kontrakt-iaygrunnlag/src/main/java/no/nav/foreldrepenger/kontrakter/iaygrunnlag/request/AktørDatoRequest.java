package no.nav.foreldrepenger.kontrakter.iaygrunnlag.request;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Aktør;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.PersonIdent;

/**
 * Input request strutkur for en Aktør for en periode (evt. dato)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class AktørDatoRequest {

    @JsonProperty(value = "aktør", required = true)
    @NotNull
    @Valid
    private PersonIdent aktør;

    @JsonProperty(value = "periode", required = true)
    @NotNull
    @Valid
    private Periode periode;

    @JsonCreator
    public AktørDatoRequest(@JsonProperty(value = "aktør", required = true) @NotNull @Valid PersonIdent aktør,
                            @JsonProperty(value = "periode", required = true) @NotNull @Valid Periode periode) {
        this.aktør = aktør;
        this.periode = periode;
    }

    public AktørDatoRequest(PersonIdent aktør,
                            LocalDate dato) {
        this.aktør = aktør;
        this.periode = new Periode(dato, dato);
    }

    public Aktør getAktør() {
        return aktør;
    }

    public Periode getPeriode() {
        return periode;
    }
    
    /** Fungerer kun dersom fom/tom er like (perioden dekker kun en dag) */
    public LocalDate getDato() {
        if(Objects.equals(periode.getFom(), periode.getTom())&& periode.getFom()!=null) {
            return periode.getFom();
        } else {
            return null; // ubestemt
        }
    }
}
