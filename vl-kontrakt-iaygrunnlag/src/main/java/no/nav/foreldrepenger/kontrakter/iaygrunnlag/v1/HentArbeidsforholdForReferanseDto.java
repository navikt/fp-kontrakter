package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.UuidDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class HentArbeidsforholdForReferanseDto {

    @NotNull
    @Valid
    private UuidDto referanseDto;

    public HentArbeidsforholdForReferanseDto() {
    }

    public HentArbeidsforholdForReferanseDto(UuidDto referanseDto) {
        super();
        this.referanseDto = referanseDto;
    }

    public UuidDto getReferanseDto() {
        return referanseDto;
    }

}
