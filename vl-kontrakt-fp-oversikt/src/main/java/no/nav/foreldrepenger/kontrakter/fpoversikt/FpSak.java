package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.felles.typer.Saksnummer;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public record FpSak(@NotNull Saksnummer saksnummer,
                    @NotNull boolean sakAvsluttet,
                    @NotNull boolean kanSøkeOmEndring,
                    @NotNull boolean sakTilhørerMor, //TODO fjern når frontend er over på forelder
                    @NotNull boolean gjelderAdopsjon,
                    @NotNull boolean morUføretrygd,
                    boolean harAnnenForelderTilsvarendeRettEØS,
                    boolean ønskerJustertUttakVedFødsel,
                    @NotNull RettighetType rettighetType,
                    Person annenPart,
                    @NotNull Familiehendelse familiehendelse,
                    FpVedtak gjeldendeVedtak,
                    FpÅpenBehandling åpenBehandling,
                    Set<Person> barn,
                    DekningsgradSak dekningsgrad,
                    @NotNull LocalDateTime oppdatertTidspunkt,
                    @NotNull BrukerRolleSak forelder) implements Sak {

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        FpSak fpSak = (FpSak) o;
        return sakAvsluttet == fpSak.sakAvsluttet && kanSøkeOmEndring == fpSak.kanSøkeOmEndring
                && sakTilhørerMor == fpSak.sakTilhørerMor && gjelderAdopsjon == fpSak.gjelderAdopsjon
                && morUføretrygd == fpSak.morUføretrygd
                && harAnnenForelderTilsvarendeRettEØS == fpSak.harAnnenForelderTilsvarendeRettEØS
                && ønskerJustertUttakVedFødsel == fpSak.ønskerJustertUttakVedFødsel
                && Objects.equals(saksnummer, fpSak.saksnummer)
                && rettighetType == fpSak.rettighetType
                && Objects.equals(annenPart, fpSak.annenPart) && Objects.equals(familiehendelse, fpSak.familiehendelse)
                && Objects.equals(gjeldendeVedtak, fpSak.gjeldendeVedtak) && Objects.equals(åpenBehandling, fpSak.åpenBehandling)
                && Objects.equals(barn, fpSak.barn) && dekningsgrad == fpSak.dekningsgrad
                && forelder == fpSak.forelder
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(saksnummer, sakAvsluttet, kanSøkeOmEndring, sakTilhørerMor, gjelderAdopsjon,
                morUføretrygd, harAnnenForelderTilsvarendeRettEØS, ønskerJustertUttakVedFødsel, rettighetType, annenPart,
                familiehendelse, gjeldendeVedtak, åpenBehandling, barn, dekningsgrad, forelder);
    }
}
