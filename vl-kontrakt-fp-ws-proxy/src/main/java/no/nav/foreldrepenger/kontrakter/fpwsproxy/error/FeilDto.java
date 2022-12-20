package no.nav.foreldrepenger.kontrakter.fpwsproxy.error;

import static java.util.Collections.emptyList;
import static no.nav.foreldrepenger.kontrakter.fpwsproxy.error.FeilType.GENERELL_FEIL;

import java.util.Collection;

/**
 * FeilDto brukes i exception handler i body ved feil
 * @param type mappes til "kjente feil"
 * @param feilmelding er getMessage() -> detailMessage fra Throwable objektet
 * @param feltFeil ekstra info som validerings feil..
 */
public record FeilDto(FeilType type, String feilmelding, Collection<FeltFeilDto> feltFeil) {

    public FeilDto(FeilType type, String feilmelding) {
        this(type, feilmelding, emptyList());
    }

    public FeilDto(String feilmelding, Collection<FeltFeilDto> feltFeil) {
        this(GENERELL_FEIL, feilmelding, feltFeil);
    }

    public FeilDto(String feilmelding) {
        this(GENERELL_FEIL, feilmelding, emptyList());
    }

}
