package no.nav.foreldrepenger.kontrakter.fpsak.tilkjentytelse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record TilkjentYtelseDagytelseDto(List<@Valid @NotNull TilkjentYtelsePeriodeDto> perioder) {

    public record TilkjentYtelsePeriodeDto(@NotNull LocalDate fom,
                                           @NotNull LocalDate tom,
                                           @Min(0) @Max(Integer.MAX_VALUE) Integer dagsats,
                                           List<@Valid @NotNull TilkjentYtelseAndelDto> andeler) {}

    public record TilkjentYtelseAndelDto(@Pattern(regexp = "\\d{9}|\\d{13}") String arbeidsgiverReferanse,
                                         @Min(0) @Max(Integer.MAX_VALUE) Integer refusjon,
                                         @Min(0) @Max(Integer.MAX_VALUE) Integer tilSoker,
                                         @NotNull @Valid Aktivitetstatus aktivitetstatus,
                                         @Pattern(regexp = "^[\\p{Graph}\\p{Space}\\p{Sc}\\p{L}\\p{M}\\p{N}]+$") String arbeidsforholdId,
                                         @Valid @Digits(integer = 8, fraction = 2) @DecimalMin("0.00") @DecimalMax("10000000.00") BigDecimal stillingsprosent) {}

    public enum Aktivitetstatus {
        ARBEIDSAVKLARINGSPENGER,
        ARBEIDSTAKER,
        DAGPENGER,
        FRILANSER,
        MILITÆR_ELLER_SIVIL,
        SELVSTENDIG_NÆRINGSDRIVENDE,
        KOMBINERT_AT_FL,
        KOMBINERT_AT_SN,
        KOMBINERT_FL_SN,
        KOMBINERT_AT_FL_SN,
        BRUKERS_ANDEL,
        KUN_YTELSE,
        TTLSTØTENDE_YTELSE,
        VENTELØNN_VARTPENGER,
        UDEFINERT,
    }

}


