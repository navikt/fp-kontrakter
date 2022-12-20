package no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.kravgrunnlag.request;

import java.math.BigInteger;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record AnnullerKravGrunnlagDto(@NotNull @Pattern(regexp = "^[A-Z0-9]{1}$") String kodeAksjon,
                                      @NotNull @Digits(integer = 14, fraction = 0) BigInteger vedtakId,
                                      @NotNull @Pattern(regexp = "^[a-zA-ZæøåÆØÅ0-9]{7}$") String saksbehId) {
}
