package no.nav.foreldrepenger.kontrakter.fpwsproxy.simulering.request;

import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record Oppdragslinje150Dto(@Valid @NotNull KodeEndringLinje kodeEndringLinje,
                                  @NotNull @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String vedtakId,
                                  @NotNull @Pattern(regexp = "^[a-zA-Z0-9-]+$") String delytelseId,
                                  @Valid @NotNull KodeKlassifik kodeKlassifik,
                                  @Valid @NotNull LukketPeriode vedtakPeriode,
                                  @Valid @NotNull SatsDto sats,
                                  @Valid @NotNull TypeSats typeSats,
                                  @Valid UtbetalingsgradDto utbetalingsgrad,
                                  @Valid KodeStatusLinje kodeStatusLinje,
                                  LocalDate datoStatusFom,
                                  @Pattern(regexp = "^[\\p{L}\\p{Blank}.'\\-\\–0-9/\\p{Space}%§\\!?@_()+:;,=\"&\\p{Sc}]*$") String utbetalesTilId,
                                  @Pattern(regexp = "^[a-zA-Z0-9-]+$") String refDelytelseId,
                                  @Pattern(regexp = "^[a-zA-Z0-9-]+$") String refFagsystemId,
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
