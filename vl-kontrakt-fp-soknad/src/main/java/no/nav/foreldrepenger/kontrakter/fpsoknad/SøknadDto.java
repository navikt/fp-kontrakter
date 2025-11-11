package no.nav.foreldrepenger.kontrakter.fpsoknad;

import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.BarnDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.VedleggDto;

import java.time.LocalDateTime;
import java.util.List;

public sealed interface SøknadDto permits EndringssøknadForeldrepengerDto, ForeldrepengesøknadDto, EngangsstønadDto, SvangerskapspengesøknadDto {
    LocalDateTime mottattdato();
    Målform språkkode();
    SøkerDto søkerinfo();
    BarnDto barn();
    List<VedleggDto> vedlegg();
}
