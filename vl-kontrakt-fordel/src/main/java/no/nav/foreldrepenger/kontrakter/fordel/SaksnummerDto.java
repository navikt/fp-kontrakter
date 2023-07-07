package no.nav.foreldrepenger.kontrakter.fordel;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SaksnummerDto {
    @NotNull
    @Size(max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9_\\-]*$")
    private String saksnummer;

    public SaksnummerDto(String saksnummer) {
        this.saksnummer = saksnummer;
    }

    public SaksnummerDto() { //For Jackson
    }

    public String getSaksnummer() {
        return saksnummer;
    }

}
