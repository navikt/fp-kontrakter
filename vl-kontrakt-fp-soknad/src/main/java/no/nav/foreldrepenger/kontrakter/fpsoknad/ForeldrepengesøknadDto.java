package no.nav.foreldrepenger.kontrakter.fpsoknad;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.BarnDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.Dekningsgrad;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.annenpart.AnnenForelderDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.UttaksplanDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.opptjening.AnnenInntektDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.opptjening.FrilansDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.opptjening.NæringDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.validering.VedlegglistestørrelseConstraint;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.VedleggDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public record ForeldrepengesøknadDto(LocalDateTime mottattdato,
                                     @Valid @NotNull SøkerDto søkerinfo,
                                     @Valid BrukerRolle rolle,
                                     @Valid Målform språkkode,
                                     @Valid @NotNull BarnDto barn,
                                     @Valid FrilansDto frilans,
                                     @Valid NæringDto egenNæring,
                                     @Size(max = 40) List<@Valid @NotNull AnnenInntektDto> andreInntekterSiste10Mnd,
                                     @Valid AnnenForelderDto annenForelder,
                                     @Valid @NotNull Dekningsgrad dekningsgrad,
                                     @Valid @NotNull UttaksplanDto uttaksplan,
                                     @Size(max = 40) List<@Valid @NotNull UtenlandsoppholdsperiodeDto> utenlandsopphold,
                                     @VedlegglistestørrelseConstraint @Size(max = 100)  List<@Valid @NotNull VedleggDto> vedlegg) implements SøknadDto {
    public ForeldrepengesøknadDto {
        andreInntekterSiste10Mnd = Optional.ofNullable(andreInntekterSiste10Mnd).orElse(List.of());
        utenlandsopphold = Optional.ofNullable(utenlandsopphold).orElse(List.of());
        vedlegg = Optional.ofNullable(vedlegg).orElse(List.of());
    }


}
