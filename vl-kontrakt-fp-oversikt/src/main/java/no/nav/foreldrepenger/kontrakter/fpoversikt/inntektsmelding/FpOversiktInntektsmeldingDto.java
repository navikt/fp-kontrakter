package no.nav.foreldrepenger.kontrakter.fpoversikt.inntektsmelding;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FpOversiktInntektsmeldingDto(
        int versjon,
        Boolean erAktiv,
        BigDecimal stillingsprosent,
        BigDecimal inntektPrMnd,
        BigDecimal refusjonPrMnd,
        String arbeidsgiverNavn,
        String arbeidsgiverIdent,
        String journalpostId,
        LocalDateTime mottattTidspunkt,
        LocalDate startDatoPermisjon,
        List<BortfaltNaturalytelse> bortfalteNaturalytelser,
        List<Refusjon> refusjonsperioder
) { }
