package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class ArbeidsforholdForAktørPåDatoDto {

    @JsonProperty(value = "aktør", required = true)
    @NotNull
    @Valid
    private Aktør aktør;

    @JsonProperty(value = "dato", required = true)
    @NotNull
    @Valid
    private LocalDate dato;

    public ArbeidsforholdForAktørPåDatoDto() {
    }

    public ArbeidsforholdForAktørPåDatoDto(Aktør aktør, LocalDate dato) {
        this.aktør = aktør;
        this.dato = dato;
    }

    public Aktør getAktør() {
        return aktør;
    }

    public LocalDate getDato() {
        return dato;
    }

}
