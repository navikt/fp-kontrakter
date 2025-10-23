package no.nav.foreldrepenger.kontrakter.fpsoknad;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.BarnDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.FødselDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.TerminDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.opptjening.AnnenInntektDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.opptjening.FrilansDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.opptjening.NæringDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.svangerskapspenger.AvtaltFerieDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.svangerskapspenger.BarnSvpDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.svangerskapspenger.TilretteleggingbehovDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.validering.VedlegglistestørrelseConstraint;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.VedleggDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public record SvangerskapspengesøknadDto(LocalDateTime mottattdato,
                                         @Valid @NotNull SøkerDto søkerinfo,
                                         @NotNull @Valid Målform språkkode,
                                         @NotNull @Valid @JsonProperty("barn") BarnSvpDto barnSvp, // Litt hack eller?
                                         @Valid FrilansDto frilans,
                                         @Valid NæringDto egenNæring,
                                         @Valid @Size(max = 20) List<@Valid @NotNull AnnenInntektDto> andreInntekterSiste10Mnd,
                                         @Valid @Size(max = 20) List<@Valid @NotNull UtenlandsoppholdsperiodeDto> utenlandsopphold,
                                         @NotNull @Valid @Size(min = 1, max = 20) List<@Valid @NotNull TilretteleggingbehovDto> tilretteleggingsbehov,
                                         @NotNull @Valid @Size(max = 20) List<@Valid @NotNull AvtaltFerieDto> avtaltFerie,
                                         @NotNull @Valid @VedlegglistestørrelseConstraint @Size(min = 1, max = 20) List<@Valid @NotNull VedleggDto> vedlegg) implements SøknadDto {

    public SvangerskapspengesøknadDto {
        andreInntekterSiste10Mnd = Optional.ofNullable(andreInntekterSiste10Mnd).orElse(List.of());
        utenlandsopphold = Optional.ofNullable(utenlandsopphold).orElse(List.of());
        tilretteleggingsbehov = Optional.ofNullable(tilretteleggingsbehov).orElse(List.of());
        avtaltFerie = Optional.ofNullable(avtaltFerie).orElse(List.of());
        vedlegg = Optional.ofNullable(vedlegg).orElse(List.of());
    }

    @Override
    public BarnDto barn() {
        var barnet = barnSvp();
        if (barnet.fødselsdato() != null) {
            return new FødselDto(1, barnet.fødselsdato(), barnet.termindato());
        }
        return new TerminDto(1, barnet.termindato(), null);
    }
}
