package no.nav.foreldrepenger.kontrakter.fpsak.tilkjentytelse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record TilkjentYtelseDagytelseDto(@Valid @NotNull List<TilkjentYtelsePeriodeDto> perioder) {

    public record TilkjentYtelsePeriodeDto(@NotNull LocalDate fom,
                                    @NotNull LocalDate tom,
                                    Integer dagsats,
                                    @Valid List<TilkjentYtelseAndelDto> andeler) {}

    public record TilkjentYtelseAndelDto(String arbeidsgiverReferanse,
                                  @Min(0) @Max(Integer.MAX_VALUE) Integer refusjon,
                                  @Min(0) @Max(Integer.MAX_VALUE) Integer tilSoker,
                                  @NotNull @Valid Aktivitetstatus aktivitetstatus,
                                  String arbeidsforholdId,
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


