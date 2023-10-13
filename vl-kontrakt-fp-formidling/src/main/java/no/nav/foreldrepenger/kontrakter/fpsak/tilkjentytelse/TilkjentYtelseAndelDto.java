package no.nav.foreldrepenger.kontrakter.fpsak.tilkjentytelse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.fpsak.tilkjentytelse.kodeverk.Aktivitetstatus;

import java.math.BigDecimal;

public record TilkjentYtelseAndelDto(String arbeidsgiverReferanse,
                                     @Min(0) @Max(Integer.MAX_VALUE) Integer refusjon,
                                     @Min(0) @Max(Integer.MAX_VALUE) Integer tilSoker,
                                     @NotNull @Valid Aktivitetstatus aktivitetstatus,
                                     String arbeidsforholdId,
                                     @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000000.00") BigDecimal stillingsprosent) {
}
