package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AktørDto {
    @NotNull
    @Pattern(regexp = "[\\d]{11}|[\\d]{13}")
    private String id;

    public AktørDto() {
    }

    public AktørDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
