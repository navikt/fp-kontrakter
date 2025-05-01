package no.nav.foreldrepenger.kontrakter.risk.v1;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.AktørId;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.Saksnummer;
import no.nav.foreldrepenger.kontrakter.risk.kodeverk.YtelseType;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public record RisikovurderingRequestDto(@NotNull @Valid AktørId søkerAktørId,
                                        @NotNull LocalDate skjæringstidspunkt,
                                        @NotNull LocalDate opplysningsperiodeFom,
                                        LocalDate opplysningsperiodeTom,
                                        @NotNull UUID konsumentId,
                                        @NotNull YtelseType ytelseType,
                                        @Valid AnnenPartDto annenPart,
                                        @NotNull @Valid Saksnummer saksnummer) {

    public Optional<LocalDate> opplysningsperiodeTomOpt() {
        return Optional.ofNullable(opplysningsperiodeTom);
    }
}