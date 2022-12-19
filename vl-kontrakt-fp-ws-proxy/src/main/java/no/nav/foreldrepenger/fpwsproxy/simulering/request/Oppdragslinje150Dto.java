package no.nav.foreldrepenger.fpwsproxy.simulering.request;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record Oppdragslinje150Dto(@Valid @NotNull KodeEndringLinje kodeEndringLinje,
                                  @NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String vedtakId,
                                  @NotNull @Min(0) @Max(Long.MAX_VALUE) Long delytelseId,
                                  @Valid @NotNull KodeKlassifik kodeKlassifik,
                                  @Valid @NotNull LukketPeriode vedtakPeriode,
                                  @Valid @NotNull SatsDto sats,
                                  @Valid @NotNull TypeSats typeSats,
                                  @Valid UtbetalingsgradDto utbetalingsgrad,
                                  @Valid KodeStatusLinje kodeStatusLinje,
                                  LocalDate datoStatusFom,
                                  @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String utbetalesTilId,
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
