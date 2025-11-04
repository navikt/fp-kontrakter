package no.nav.foreldrepenger.kontrakter.fpoversikt;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record Gradering(@NotNull Arbeidstidprosent arbeidstidprosent, @NotNull Aktivitet aktivitet) {

    @JsonCreator
    public Gradering(@JsonProperty("arbeidstidprosent") BigDecimal arbeidstidprosent,
                     @JsonProperty("aktivitet") Aktivitet aktivitet) {
        this(new Arbeidstidprosent(arbeidstidprosent), aktivitet);
    }
}
