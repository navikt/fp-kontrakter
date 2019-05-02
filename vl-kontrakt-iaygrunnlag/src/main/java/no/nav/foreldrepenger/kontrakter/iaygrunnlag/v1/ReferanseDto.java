package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ReferanseDto {

    @NotNull
    @Pattern(regexp = "\\b[0-9a-f]{8}\\b-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-\\b[0-9a-f]{12}\\b")
    private String referanse;

    public ReferanseDto(String referanse) {
        this.referanse = referanse;
    }

    public ReferanseDto() {
    }

    public String getReferanse() {
        return referanse;
    }

    public void setReferanse(String referanse) {
        this.referanse = referanse;
    }
}
