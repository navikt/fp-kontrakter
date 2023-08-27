package no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.kravgrunnlag.request;

import java.math.BigInteger;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

public record AnnullerKravGrunnlagDto(@NotNull @Digits(integer = 14, fraction = 0) BigInteger vedtakId) {
}
