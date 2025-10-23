package no.nav.foreldrepenger.kontrakter.fpsoknad.barn;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record FødselDto(@Min(1) @Max(Integer.MAX_VALUE) int antallBarn,
                        @NotNull @PastOrPresent LocalDate fødselsdato,
                        LocalDate termindato) implements BarnDto {
}
