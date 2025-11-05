package no.nav.foreldrepenger.kontrakter.fpoversikt;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Familiehendelse(LocalDate fødselsdato,
                              LocalDate termindato,
                              @NotNull int antallBarn,
                              LocalDate omsorgsovertakelse) {
}
