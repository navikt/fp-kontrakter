package no.nav.foreldrepenger.kontrakter.fpsoknad.builder;

import no.nav.foreldrepenger.kontrakter.fpsoknad.SøkerDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.SøknadDto;

public interface SøknadBuilder<S> {
    SøknadBuilder<S> medSøkerinfo(SøkerDto søkerinfo);
    SøknadDto build();
}