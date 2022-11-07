package no.nav.foreldrepenger.kontrakter.simulering;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import no.nav.vedtak.util.InputValideringRegex;

public record Ompostering116Dto(@NotNull boolean omPostering,
                                LocalDate datoOmposterFom,
                                @NotNull @Pattern(regexp = InputValideringRegex.FRITEKST) String tidspktReg) {
}
