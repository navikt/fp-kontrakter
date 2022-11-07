package no.nav.foreldrepenger.kontrakter.simulering;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import no.nav.vedtak.util.InputValideringRegex;

public record Refusjonsinfo156Dto(@NotNull LocalDate maksDato,
                                  @NotNull @Pattern(regexp = InputValideringRegex.FRITEKST) String refunderesId,
                                  @NotNull LocalDate datoFom) {
}
