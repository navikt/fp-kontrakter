package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class HentArbeidsforholdForReferanseDto {

    @NotNull
    @Valid
    private ReferanseDto referanseDto;

    public HentArbeidsforholdForReferanseDto() {
    }

    public ReferanseDto getReferanseDto() {
        return referanseDto;
    }

    public void setReferanseDto(ReferanseDto referanseDto) {
        this.referanseDto = referanseDto;
    }
}
