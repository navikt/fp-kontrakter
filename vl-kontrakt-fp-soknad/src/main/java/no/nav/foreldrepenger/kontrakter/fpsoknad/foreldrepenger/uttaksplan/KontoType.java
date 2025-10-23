package no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan;

import no.nav.foreldrepenger.kontrakter.fpsoknad.Kodeverdi;

public enum KontoType implements Kodeverdi {
    FELLESPERIODE,
    MØDREKVOTE,
    FEDREKVOTE,
    FORELDREPENGER,
    FORELDREPENGER_FØR_FØDSEL;

    @Override
    public String getKode() {
        return name();
    }
}
