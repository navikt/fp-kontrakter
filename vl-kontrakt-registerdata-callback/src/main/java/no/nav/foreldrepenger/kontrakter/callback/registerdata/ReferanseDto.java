package no.nav.foreldrepenger.kontrakter.callback.registerdata;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Unik referanse representert som UUID
 */
public class ReferanseDto {

    @NotNull
    @Pattern(regexp = "\\b[0-9a-f]{8}\\b-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-\\b[0-9a-f]{12}\\b")
    private String referanse;

    public String getReferanse() {
        return referanse;
    }

    public void setReferanse(String referanse) {
        this.referanse = referanse;
    }
}
