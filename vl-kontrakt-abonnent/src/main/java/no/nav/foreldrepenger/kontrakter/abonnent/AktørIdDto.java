package no.nav.foreldrepenger.kontrakter.abonnent;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class AktørIdDto {

    @NotNull
    @Digits(integer = 19, fraction = 0)
    private String aktørId;

    public AktørIdDto() {}

    public AktørIdDto(String aktørId) {
        this.aktørId = aktørId;
    }

    public String getAktørId() {
        return aktørId;
    }

    public void setAktørId(String aktørId) {
        this.aktørId = aktørId;
    }
}
