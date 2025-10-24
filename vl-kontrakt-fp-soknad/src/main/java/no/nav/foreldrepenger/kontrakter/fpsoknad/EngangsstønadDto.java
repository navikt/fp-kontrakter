package no.nav.foreldrepenger.kontrakter.fpsoknad;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.BarnDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.validering.VedlegglistestørrelseConstraint;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.VedleggDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public record EngangsstønadDto(LocalDateTime mottattdato,
                               @Valid @NotNull SøkerDto søkerinfo,
                               @NotNull Målform språkkode,
                               @Valid @NotNull BarnDto barn,
                               @Valid @Size(max = 40) List<@Valid @NotNull UtenlandsoppholdsperiodeDto> utenlandsopphold,
                               @Valid @VedlegglistestørrelseConstraint @Size(max = 100) List<@Valid @NotNull VedleggDto> vedlegg) implements SøknadDto {

    public EngangsstønadDto {
        utenlandsopphold = Optional.ofNullable(utenlandsopphold).orElse(List.of());
        vedlegg = Optional.ofNullable(vedlegg).orElse(List.of());
    }
}
