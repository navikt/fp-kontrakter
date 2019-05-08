package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.PersonIdent;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.ALWAYS)
public class InntekterDto {

    /** Bruker som har inntektene. */
    @JsonProperty("aktør")
    @Valid
    private PersonIdent aktør;

    @JsonProperty("utbetalinger")
    @Valid
    private List<UtbetalingDto> utbetalinger;

    public InntekterDto() {
    }

    public InntekterDto(PersonIdent aktør) {
        this.aktør = aktør;
    }

    public PersonIdent getAktør() {
        return aktør;
    }

    public List<UtbetalingDto> getUtbetalinger() {
        return utbetalinger;
    }

    public void setUtbetalinger(List<UtbetalingDto> utbetalinger) {
        this.utbetalinger = utbetalinger;
    }
}
