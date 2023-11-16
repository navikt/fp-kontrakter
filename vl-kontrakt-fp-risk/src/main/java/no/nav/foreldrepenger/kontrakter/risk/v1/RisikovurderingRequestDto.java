package no.nav.foreldrepenger.kontrakter.risk.v1;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import no.nav.foreldrepenger.kontrakter.risk.kodeverk.AktørId;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.YtelseType;

// TODO Sett @NotNull på saksnummer når fpsak og fprisk tar i bruk ny kontrakt
public record RisikovurderingRequestDto(@NotNull @Valid AktørId søkerAktørId,
                                        @NotNull LocalDate skjæringstidspunkt,
                                        @NotNull LocalDate opplysningsperiodeFom,
                                        LocalDate opplysningsperiodeTom,
                                        @NotNull UUID konsumentId,
                                        String saksnummer,
                                        @NotNull YtelseType ytelseType,
                                        @Valid AnnenPartDto annenPart) {

    public Optional<LocalDate> opplysningsperiodeTomOpt() {
        return Optional.ofNullable(opplysningsperiodeTom);
    }
}
