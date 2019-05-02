package no.nav.foreldrepenger.kontrakter.callback.registerdata;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Metadata for callback
 * Inneholder:
 * - referanse: referanse til behandlingen
 * - grunnlagReferanse: resultatet av registerinnhenting, referanse til nytt grunnlag
 * - grunnlagType: Grunnlaget
 */
public class CallbackDto {

    @NotNull
    @Valid
    private ReferanseDto referanse;

    @Valid
    private ReferanseDto grunnlagReferanse;

    @NotNull
    @Valid
    private Grunnlag grunnlagType;

    public ReferanseDto getReferanse() {
        return referanse;
    }

    public void setReferanse(ReferanseDto referanse) {
        this.referanse = referanse;
    }

    public ReferanseDto getGrunnlagReferanse() {
        return grunnlagReferanse;
    }

    public void setGrunnlagReferanse(ReferanseDto grunnlagReferanse) {
        this.grunnlagReferanse = grunnlagReferanse;
    }

    public Grunnlag getGrunnlagType() {
        return grunnlagType;
    }

    public void setGrunnlagType(Grunnlag grunnlagType) {
        this.grunnlagType = grunnlagType;
    }
}
