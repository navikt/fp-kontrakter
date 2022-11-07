package no.nav.foreldrepenger.kontrakter.simulering;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import no.nav.vedtak.util.InputValideringRegex;

public record Oppdragslinje150Dto(@Valid @NotNull KodeEndringLinje kodeEndringLinje,
                                  @NotNull @Pattern(regexp = InputValideringRegex.FRITEKST) String vedtakId,
                                  @NotNull @Min(0) @Max(Long.MAX_VALUE) Long delytelseId,
                                  @Valid @NotNull KodeKlassifik kodeKlassifik,
                                  @Valid @NotNull LukketPeriode vedtakPeriode,
                                  @Valid @NotNull SatsDto sats,
                                  @Valid @NotNull TypeSats typeSats,
                                  @Valid UtbetalingsgradDto utbetalingsgrad,
                                  @Valid KodeStatusLinje kodeStatusLinje,
                                  LocalDate datoStatusFom,
                                  @Pattern(regexp = InputValideringRegex.FRITEKST) String utbetalesTilId,
                                  @Min(0) @Max(Long.MAX_VALUE) Long refDelytelseId,
                                  @Min(0) @Max(Long.MAX_VALUE) Long refFagsystemId,
                                  @Valid Refusjonsinfo156Dto refusjonsinfo156) {

    @JsonIgnore
    public boolean gjelderOpphør() {
        return kodeStatusLinje() != null;
    }

    @JsonIgnore
    public LocalDate getDatoVedtakFom() {
        return vedtakPeriode.fomDate();
    }

    @JsonIgnore
    public LocalDate getDatoVedtakTom() {
        return vedtakPeriode.tomDate();
    }
}
