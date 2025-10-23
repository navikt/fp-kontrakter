package no.nav.foreldrepenger.kontrakter.fpsoknad.barn;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record OmsorgsovertakelseDto(@Min(1) @Max(Integer.MAX_VALUE) int antallBarn,
                                    @Size(min = 1, max = 10) List<@PastOrPresent LocalDate> fødselsdatoer,
                                    @NotNull LocalDate foreldreansvarsdato) implements BarnDto {
}
