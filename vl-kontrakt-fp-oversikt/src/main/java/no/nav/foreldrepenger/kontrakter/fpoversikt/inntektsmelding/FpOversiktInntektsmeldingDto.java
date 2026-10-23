package no.nav.foreldrepenger.kontrakter.fpoversikt.inntektsmelding;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record FpOversiktInntektsmeldingDto(
        @NotNull int versjon,
        @NotNull Boolean erAktiv,
        BigDecimal stillingsprosent,
        @NotNull BigDecimal inntektPrMnd,
        BigDecimal refusjonPrMnd,
        @NotNull String arbeidsgiverNavn,
        @NotNull String arbeidsgiverIdent,
        @NotNull String journalpostId,
        @NotNull LocalDateTime mottattTidspunkt,
        @NotNull List<BortfaltNaturalytelse> bortfalteNaturalytelser,
        @NotNull List<Refusjon> refusjonsperioder
) { }
