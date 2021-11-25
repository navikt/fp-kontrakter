package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.AktørId;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.YtelseType;

public record RisikovurderingRequestDto(@NotNull @Valid AktørId søkerAktørId,
                                        @NotNull LocalDate skjæringstidspunkt,
                                        @NotNull LocalDate opplysningsperiodeFom,
                                        LocalDate opplysningsperiodeTom,
                                        @NotNull UUID konsumentId,
                                        @NotNull YtelseType ytelseType,
                                        @Valid AnnenPartDto annenPart) {

    public Optional<LocalDate> opplysningsperiodeTomOpt() {
        return Optional.ofNullable(opplysningsperiodeTom);
    }
}