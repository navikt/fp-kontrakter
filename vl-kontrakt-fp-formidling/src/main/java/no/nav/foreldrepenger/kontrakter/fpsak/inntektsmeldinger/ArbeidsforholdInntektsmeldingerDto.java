package no.nav.foreldrepenger.kontrakter.fpsak.inntektsmeldinger;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record ArbeidsforholdInntektsmeldingerDto(@NotNull List<@Valid @NotNull ArbeidsforholdInntektsmeldingDto> arbeidsforholdInntektsmelding) {

    public record ArbeidsforholdInntektsmeldingDto(@NotNull @Pattern(regexp = "\\d{9}|\\d{13}") String arbeidsgiverIdent,
                                                @NotNull Boolean erInntektsmeldingMottatt) {}
}
