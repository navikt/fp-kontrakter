package no.nav.foreldrepenger.kontrakter.abonnent.v2;

import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class AktørIdDto {

    @NotNull
    @Digits(integer = 19, fraction = 0)
    private String aktørId;

    public AktørIdDto() { // NOSONAR
        // Jackson
    }

    public AktørIdDto(String aktørId) {
        this.aktørId = aktørId;
    }

    public String getAktørId() {
        return aktørId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || !this.getClass().equals(obj.getClass())) {
            return false;
        }
        AktørIdDto other = (AktørIdDto) obj;
        return Objects.equals(aktørId, other.aktørId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aktørId);
    }
}
