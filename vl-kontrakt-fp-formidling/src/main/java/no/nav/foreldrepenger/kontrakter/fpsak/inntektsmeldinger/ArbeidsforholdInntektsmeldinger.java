package no.nav.foreldrepenger.kontrakter.fpsak.inntektsmeldinger;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.util.List;

public record ArbeidsforholdInntektsmeldinger(@NotNull List<@Valid @NotNull ArbeidsforholdInntektsmelding> arbeidsforholdInntektsmelding) {

    public record ArbeidsforholdInntektsmelding(@NotNull @Pattern(regexp = "\\d{9}|\\d{13}") String arbeidsgiverIdent,
                                                @NotNull @Digits(integer = 5, fraction = 2) @DecimalMin("0.00") @DecimalMax("500.00") BigDecimal stillingsprosent,
                                                @NotNull Boolean erInntektsmeldingMottatt) {}
}
